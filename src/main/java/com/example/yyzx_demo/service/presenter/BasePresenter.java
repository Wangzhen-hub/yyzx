package com.example.yyzx_demo.service.presenter;

import com.example.yyzx_demo.service.view.IBaseView;

import java.lang.ref.WeakReference;

/**
 * Created by Android Studio.
 * User: 王震
 * Date: 2019/11/1
 * Time: 10:06
 */
public class BasePresenter<V extends IBaseView> {

    protected V mview;

    private WeakReference<V> weakReferenceView;

    public void onAttachView(V view) {
        if (view != null) {
            weakReferenceView = new WeakReference<>(view);
            this.mview = weakReferenceView.get();
        }
    }

    public void onDestoryView() {
        weakReferenceView.clear();
        weakReferenceView = null;
        mview = null;
    }

}
