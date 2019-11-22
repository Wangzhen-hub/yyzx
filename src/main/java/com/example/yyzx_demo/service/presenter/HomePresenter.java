package com.example.yyzx_demo.service.presenter;

import com.example.yyzx_demo.service.model.Model;
import com.example.yyzx_demo.service.model.OnLoadDataListener;
import com.example.yyzx_demo.service.model.entity.GetHomeEntity;
import com.example.yyzx_demo.service.view.IHomeView;

import java.util.HashMap;

/**
 * Created by Android Studio.
 * User: 王震
 * Date: 2019/10/14
 * Time: 8:59
 */
public class HomePresenter extends BasePresenter<IHomeView> {

    Model model;

    public HomePresenter(String baseUrl) {
        model = new Model(baseUrl);
        model.onCreateRX();
    }

    public void newCreateToken(HashMap<String, String> map) {
        model.newCreate(map, new OnLoadDataListener<String>() {
            @Override
            public void onSuccess(String s) {
                mview.backToken(s);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    public void getHomeData(final String token) {
        model.getHome(token, new OnLoadDataListener<GetHomeEntity>() {
            @Override
            public void onSuccess(GetHomeEntity getHomeEntity) {
                mview.showGetHome(getHomeEntity);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    public void onAttach(IHomeView ivIew) {
        onAttachView(ivIew);
    }

    public void onDestory() {
        model.onDestoryRX();
        model = null;
        onDestoryView();
    }
}
