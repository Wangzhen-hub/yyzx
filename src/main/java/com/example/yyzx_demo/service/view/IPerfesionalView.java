package com.example.yyzx_demo.service.view;

import com.example.yyzx_demo.service.model.entity.CategoryGetPerfesionalEntity;

/**
 * Created by Android Studio.
 * User: 王震
 * Date: 2019/10/23
 * Time: 11:28
 */
public interface IPerfesionalView extends IBaseView {
    //显示Category音乐课堂页面
    void showCategoryPerfesional(CategoryGetPerfesionalEntity categoryGetPerfesionalEntity);
}
