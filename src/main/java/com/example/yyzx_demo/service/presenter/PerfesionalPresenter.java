package com.example.yyzx_demo.service.presenter;

import com.example.yyzx_demo.service.model.Model;
import com.example.yyzx_demo.service.model.OnLoadDataListener;
import com.example.yyzx_demo.service.model.entity.CategoryGetPerfesionalEntity;
import com.example.yyzx_demo.service.model.entity.GetHomeEntity;
import com.example.yyzx_demo.service.view.IHomeView;
import com.example.yyzx_demo.service.view.IPerfesionalView;

import java.util.HashMap;

/**
 * Created by Android Studio.
 * User: 王震
 * Date: 2019/10/14
 * Time: 8:59
 */
public class PerfesionalPresenter extends BasePresenter<IPerfesionalView> {

    Model model;

    public PerfesionalPresenter(String baseUrl) {
        model = new Model(baseUrl);
        model.onCreateRX();
    }

    /**
     * 获取音乐课堂数据
     */
    public void getCategoryPerfesionalData(String token) {
        model.getPerfesional(token, new OnLoadDataListener<CategoryGetPerfesionalEntity>() {
            @Override
            public void onSuccess(CategoryGetPerfesionalEntity categoryGetPerfesionalEntity) {
                mview.showCategoryPerfesional(categoryGetPerfesionalEntity);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    public void onAttach(IPerfesionalView ivIew) {
        onAttachView(ivIew);
    }

    public void onDestory() {
        model.onDestoryRX();
        onDestoryView();
    }
}
