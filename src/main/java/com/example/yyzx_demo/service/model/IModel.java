package com.example.yyzx_demo.service.model;

import com.example.yyzx_demo.service.model.entity.CategoryGetPerfesionalEntity;
import com.example.yyzx_demo.service.model.entity.GetHomeEntity;
import com.example.yyzx_demo.service.model.entity.GetMasterLiveEntity;
import com.example.yyzx_demo.service.model.entity.GetVideoEntity;

import java.util.HashMap;

/**
 * Created by Android Studio.
 * User: 王震
 * Date: 2019/10/14
 * Time: 9:08
 */
public interface IModel {

    /**
     * 调度器开关
     */
    void onCreateRX();

    void onDestoryRX();

    /**
     * 创建新用户获取Token
     */
    void newCreate(HashMap<String, String> map, OnLoadDataListener<String> onLoadDataListener);

    /**
     * 获取主页面数据
     */
    void getHome(String token, OnLoadDataListener<GetHomeEntity> onLoadDataListener);

    /**
     * 获取视频数据
     */
    void getVideo(String token, OnLoadDataListener<GetVideoEntity> onLoadDataListener);

    /**
     * -------------------------------Category-----------------------------------
     */

    /**
     * 获取音乐课堂数据
     */
    void getPerfesional(String token, OnLoadDataListener<CategoryGetPerfesionalEntity> onLoadDataListener);

    /**
     * 获取在线直播数据
     */
    void getMasterLive(String token, OnLoadDataListener<GetMasterLiveEntity> onLoadDataListener);
}
