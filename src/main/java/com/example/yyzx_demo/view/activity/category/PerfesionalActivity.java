package com.example.yyzx_demo.view.activity.category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.yyzx_demo.R;
import com.example.yyzx_demo.adapter.PerfesionalAdapter;
import com.example.yyzx_demo.service.model.entity.CategoryGetPerfesionalEntity;
import com.example.yyzx_demo.service.presenter.PerfesionalPresenter;
import com.example.yyzx_demo.service.view.IPerfesionalView;
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

public class PerfesionalActivity extends AppCompatActivity implements IPerfesionalView {

    @BindView(R.id.perfesional_toolbar)
    Toolbar toolbar;
    @BindView(R.id.perfesional_rv)
    RecyclerView rv;
    @BindView(R.id.perfesional_refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.perfesional_back)
    ImageView back;
    private Unbinder bind;

    private List<CategoryGetPerfesionalEntity.DataBean> list = new ArrayList<>();
    private PerfesionalPresenter presenter = new PerfesionalPresenter(BASE_URL);
    private PerfesionalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfesional);
        bind = ButterKnife.bind(this);

        setWindowFlag();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onAttach(this);
        presenter.getCategoryPerfesionalData(TOKEN);

        rv.setLayoutManager(new GridLayoutManager(this, 4));
        adapter = new PerfesionalAdapter(list, this);
        rv.setAdapter(adapter);

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                list.clear();
                presenter.getCategoryPerfesionalData(TOKEN);
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

    private void setWindowFlag() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    @Override
    public void showCategoryPerfesional(CategoryGetPerfesionalEntity categoryGetPerfesionalEntity) {
        list.addAll(categoryGetPerfesionalEntity.getData());
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
        presenter.onDestory();
    }
}
