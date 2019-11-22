package com.example.yyzx_demo.service.model;

/**
 * Created by Android Studio.
 * User: 王震
 * Date: 2019/11/1
 * Time: 18:56
 */
public interface OnLoadDataListener<T> {

    /*
    成功回调方法
     */
    void onSuccess(T t);

    /*
    失败回调方法
     */
    void onFailure(String error);

}
