package com.example.yyzx_demo.view.activity.category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.yyzx_demo.R;
import com.example.yyzx_demo.adapter.MasterLiveAdapter;
import com.example.yyzx_demo.service.model.entity.GetMasterLiveEntity;
import com.example.yyzx_demo.service.presenter.MasterLivePresenter;
import com.example.yyzx_demo.service.view.IMasterLiveView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.example.yyzx_demo.api.ApiService.BASE_URL;
import static com.example.yyzx_demo.app.MainActivity.TOKEN;

public class MasterLiveActivity extends AppCompatActivity implements IMasterLiveView {

    @BindView(R.id.master_live_back)
    ImageView back;
    @BindView(R.id.master_live_rv)
    RecyclerView rv;
    @BindView(R.id.master_live_refresh)
    SmartRefreshLayout refresh;
    private MasterLivePresenter presenter;
    private Unbinder bind;

    private List<GetMasterLiveEntity.DataBean> list = new ArrayList<>();
    private MasterLiveAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_live);
        bind = ButterKnife.bind(this);

        setWindowFlag();

        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MasterLiveAdapter(list, this);
        rv.setAdapter(adapter);

        presenter = new MasterLivePresenter(BASE_URL);
        presenter.onAttach(this);
        presenter.getCategoryMasterLiveData(TOKEN);

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                list.clear();
                presenter.getCategoryMasterLiveData(TOKEN);
                refresh.finishRefresh();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void showMsterLiveData(GetMasterLiveEntity getMasterLiveEntity) {
        Log.e("###在线直播", getMasterLiveEntity.toString());
        list.addAll(getMasterLiveEntity.getData());
        adapter.notifyDataSetChanged();
    }

    private void setWindowFlag() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestory();
        bind.unbind();
    }
}
