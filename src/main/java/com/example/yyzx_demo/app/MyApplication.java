package com.example.yyzx_demo.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Android Studio.
 * User: 王震
 * Date: 2019/10/14
 * Time: 14:12
 */
public class MyApplication extends Application {
    private static RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
        Fresco.initialize(this);
    }

    public static RefWatcher getRefWatcher() {
        return refWatcher;
    }
}
