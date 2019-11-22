package com.example.yyzx_demo.app;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.yyzx_demo.R;
import com.example.yyzx_demo.adapter.CategoryAdapter;
import com.example.yyzx_demo.adapter.CourseRecommendsAdapter;
import com.example.yyzx_demo.adapter.LivesAdapter;
import com.example.yyzx_demo.adapter.VipListAdapter;
import com.example.yyzx_demo.adapter.ZlListAdapter;
import com.example.yyzx_demo.service.model.entity.CategoryGetPerfesionalEntity;
import com.example.yyzx_demo.service.model.entity.GetHomeEntity;
import com.example.yyzx_demo.service.presenter.HomePresenter;
import com.example.yyzx_demo.service.view.IHomeView;
import com.example.yyzx_demo.util.Md5Utils;
import com.example.yyzx_demo.view.MyRecyclerView;
import com.example.yyzx_demo.view.activity.GetVideoActivity;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.example.yyzx_demo.api.ApiService.BASE_URL;

public class MainActivity extends AppCompatActivity implements IHomeView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.category_rv)
    MyRecyclerView categoryRV;
    @BindView(R.id.lives_rv)
    MyRecyclerView livesRV;
    @BindView(R.id.vip_rv)
    MyRecyclerView vipRV;
    @BindView(R.id.zl_rv)
    MyRecyclerView zlRV;
    @BindView(R.id.course_rv)
    MyRecyclerView courseRV;
    @BindView(R.id.main_refresh_layout)
    SmartRefreshLayout refreshLayout;
    private Unbinder bind;

    //用户TOKEN
    public static String TOKEN = "";

    HomePresenter homePresenter = new HomePresenter(BASE_URL);
    private GetHomeEntity.DataBean data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);
        //调用沉浸式状态栏
        makeStatusBarTransparent();
//        Log.e("TagA", "设备:" + Build.DEVICE);
//        Log.e("TagA", "设备的key:" + getDeviceKey());
//        Log.e("TagA", "系统版本:" + Build.VERSION.SDK_INT);
//        Log.e("TagA", "品牌:" + Build.BRAND);
//        Log.e("TagA", "产品型号:" + Build.PRODUCT);

        //LeakCanary绑定监听
        //MyApplication.getRefWatcher().watch(this);
        //6.0.动态申请权限
        requestPermiss();
        //初始化提交Token的Map
        HashMap<String, String> map = new HashMap<>();
        map.put("device", Build.DEVICE);
        map.put("deviceKey", getDeviceKey());
        map.put("sdkVersion", String.valueOf(Build.VERSION.SDK_INT));
        map.put("brand", Build.BRAND);
        map.put("product", Build.PRODUCT);
        //MVP Presenter绑定View
        homePresenter.onAttach(this);
        //提交创建Token
        homePresenter.newCreateToken(map);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(1000);
            }
        });
    }

    //6.0.动态申请权限
    private void requestPermiss() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            int i = checkSelfPermission(Manifest.permission.INTERNET);
            int i1 = checkSelfPermission(Manifest.permission.READ_PHONE_STATE);
            if (i != PackageManager.PERMISSION_GRANTED | i1 != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.INTERNET, Manifest.permission.READ_PHONE_STATE}, 100);
            }
        }
    }

    //MD5加密
    @SuppressLint("MissingPermission")
    private String getDeviceKey() {
        String deviceKey = null;
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        deviceKey = tm.getSimSerialNumber();
        deviceKey = Md5Utils.MD5(deviceKey);
        return deviceKey;
    }

    //返回Token
    @Override
    public void backToken(String token) {
        Log.e("###BackToken", token);
        TOKEN = token;
        homePresenter.getHomeData(TOKEN);
    }

    //回调数据
    @Override
    public void showGetHome(GetHomeEntity entity) {
        Log.e("###showGetHome", entity.toString());
        data = entity.getData();

        initBanner();
        initCategory();
        initVipList();
        initZlList();
        initCourseRecommends();
        initLives();
    }

    /**
     * 加载推荐课程列表
     */
    private void initCourseRecommends() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        courseRV.setLayoutManager(linearLayoutManager);
        CourseRecommendsAdapter adapter = new CourseRecommendsAdapter(data.getCourseRecommends(), this);
        courseRV.setAdapter(adapter);
    }

    /**
     * 加载专栏列表
     */
    private void initZlList() {
        zlRV.setLayoutManager(new GridLayoutManager(this, 2));
        ZlListAdapter adapter = new ZlListAdapter(data.getZlList(), this);
        zlRV.setAdapter(adapter);
    }

    /**
     * 加载Vip列表
     */
    private void initVipList() {
        vipRV.setLayoutManager(new GridLayoutManager(this, 2));
        VipListAdapter adapter = new VipListAdapter(data.getViplist(), this);
        vipRV.setAdapter(adapter);
    }

    /**
     * 加载直播列表
     */
    private void initLives() {
        livesRV.setLayoutManager(new LinearLayoutManager(this));
        LivesAdapter adapter = new LivesAdapter(data.getMasterLives(), this);
        livesRV.setAdapter(adapter);
    }

    /**
     * 加载分类列表
     */
    private void initCategory() {
        categoryRV.setLayoutManager(new GridLayoutManager(this, 4));
        CategoryAdapter adapter = new CategoryAdapter(data.getHomeCategory(), this);
        categoryRV.setAdapter(adapter);
    }

    /**
     * 加载Banner轮播图数据
     */
    private void initBanner() {
        List<GetHomeEntity.DataBean.HomeBannerBean> homeBanner = data.getHomeBanner();
        final ArrayList<String> bannerList = new ArrayList<>();
        for (int i = 0; i < homeBanner.size(); i++) {
            bannerList.add(homeBanner.get(i).getBannerUrl());
        }
        banner.setImages(bannerList);
        banner.setImageLoader(new ImageLoader() {

            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                imageView.setPadding(35, 10, 35, 0);
                imageView.setImageURI(Uri.parse(String.valueOf(path)));
            }

            @Override
            public ImageView createImageView(Context context) {
                SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
                RoundingParams roundingParams = new RoundingParams();
                roundingParams.setCornersRadius(30);
                simpleDraweeView.getHierarchy().setRoundingParams(roundingParams);
                return simpleDraweeView;
            }
        });
        banner.start();

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(getApplicationContext(), GetVideoActivity.class);
//                intent.putExtra("position", bannerList.get(position));
                startActivity(intent);
            }
        });
    }

    /*设置透明状态栏*/
    private void makeStatusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.onDestory();
        bind.unbind();
        //MyApplication.getRefWatcher().clearWatchedReferences();
        finish();
    }
}
