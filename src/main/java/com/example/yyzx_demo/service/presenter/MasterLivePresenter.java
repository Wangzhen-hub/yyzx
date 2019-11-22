package com.example.yyzx_demo.service.presenter;

import com.example.yyzx_demo.service.model.Model;
import com.example.yyzx_demo.service.model.OnLoadDataListener;
import com.example.yyzx_demo.service.model.entity.CategoryGetPerfesionalEntity;
import com.example.yyzx_demo.service.model.entity.GetMasterLiveEntity;
import com.example.yyzx_demo.service.view.IMasterLiveView;
import com.example.yyzx_demo.service.view.IPerfesionalView;

/**
 * Created by Android Studio.
 * User: 王震
 * Date: 2019/10/14
 * Time: 8:59
 */
public class MasterLivePresenter extends BasePresenter<IMasterLiveView> {

    Model model;

    public MasterLivePresenter(String baseUrl) {
        model = new Model(baseUrl);
        model.onCreateRX();
    }

    /**
     * 获取在线直播数据
     */
    public void getCategoryMasterLiveData(String token) {
        model.getMasterLive(token, new OnLoadDataListener<GetMasterLiveEntity>() {
            @Override
            public void onSuccess(GetMasterLiveEntity getMasterLiveEntity) {
                mview.showMsterLiveData(getMasterLiveEntity);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    public void onAttach(IMasterLiveView ivIew) {
        onAttachView(ivIew);
    }

    public void onDestory() {
        model.onDestoryRX();
        onDestoryView();
    }
}
