package com.example.yyzx_demo.service.model;

import android.util.Log;

import com.example.yyzx_demo.api.ApiService;
import com.example.yyzx_demo.service.model.entity.CategoryGetPerfesionalEntity;
import com.example.yyzx_demo.service.model.entity.GetHomeEntity;
import com.example.yyzx_demo.service.model.entity.GetMasterLiveEntity;
import com.example.yyzx_demo.service.model.entity.GetVideoEntity;
import com.example.yyzx_demo.util.RetrofitUtil;

import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.ResponseBody;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Android Studio.
 * User: 王震
 * Date: 2019/10/12
 * Time: 11:43
 */
public class Model implements IModel {
    ApiService apiService;
    CompositeSubscription compositeSubscription;

    public Model(String url) {
        apiService = RetrofitUtil.getInstance(url).getService();
    }

    @Override
    public void onCreateRX() {
        compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onDestoryRX() {
        compositeSubscription.unsubscribe();
    }

    @Override
    public void newCreate(HashMap<String, String> map, final OnLoadDataListener<String> onLoadDataListener) {
        compositeSubscription.add(apiService.createNew(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("###", "error = " + e.getMessage());
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            JSONObject object = new JSONObject(responseBody.string());
                            JSONObject data = object.getJSONObject("data");
                            String accessToken = data.getString("accessToken");
                            onLoadDataListener.onSuccess(accessToken);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }));
    }

    @Override
    public void getHome(String token, final OnLoadDataListener<GetHomeEntity> onLoadDataListener) {
        compositeSubscription.add(apiService.getHome(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetHomeEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("###Model", "getHome--->error:" + e.getMessage());
                    }

                    @Override
                    public void onNext(GetHomeEntity getHomeEntity) {
                        onLoadDataListener.onSuccess(getHomeEntity);
                    }
                }));
    }

    @Override
    public void getVideo(String token, final OnLoadDataListener<GetVideoEntity> onLoadDataListener) {
        HashMap<String, String> map = new HashMap<>();
        map.put("courseId", "31");
        map.put("packageId", "0");
        compositeSubscription.add(apiService.getVideo(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetVideoEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("###Model", "getVideo--->error:" + e.getMessage());
                    }

                    @Override
                    public void onNext(GetVideoEntity getVideoEntity) {
                        onLoadDataListener.onSuccess(getVideoEntity);
                    }
                }));
    }

    @Override
    public void getPerfesional(String token, final OnLoadDataListener<CategoryGetPerfesionalEntity> onLoadDataListener) {
        compositeSubscription.add(apiService.getPerfesional(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryGetPerfesionalEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("###Model", "getPerfesional--->error:" + e.getMessage());
                    }

                    @Override
                    public void onNext(CategoryGetPerfesionalEntity categoryGetPerfesionalEntity) {
                        onLoadDataListener.onSuccess(categoryGetPerfesionalEntity);
                    }
                }));
    }

    @Override
    public void getMasterLive(String token, final OnLoadDataListener<GetMasterLiveEntity> onLoadDataListener) {
        compositeSubscription.add(apiService.getMasterLive(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetMasterLiveEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("###Model", "getMasterLive--->error:" + e.getMessage());
                    }

                    @Override
                    public void onNext(GetMasterLiveEntity getMasterLiveEntity) {
                        onLoadDataListener.onSuccess(getMasterLiveEntity);
                    }
                }));
    }
}
