package com.example.yyzx_demo.util;

import com.example.yyzx_demo.api.ApiService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Android Studio.
 * User: 王震
 * Date: 2019/10/12
 * Time: 10:58
 */
public class RetrofitUtil {
    public static RetrofitUtil instance = null;
    Retrofit retrofit;

    public RetrofitUtil(String url) {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static RetrofitUtil getInstance(String url) {
        if (instance == null) {
            synchronized (RetrofitUtil.class) {
                if (instance == null) {
                    instance = new RetrofitUtil(url);
                }
            }
        }
        return instance;
    }

    public ApiService getService() {
        return retrofit.create(ApiService.class);
    }
}
