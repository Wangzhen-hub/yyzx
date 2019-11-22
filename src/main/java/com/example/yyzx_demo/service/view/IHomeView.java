package com.example.yyzx_demo.service.view;

import com.example.yyzx_demo.service.model.entity.GetHomeEntity;

/**
 * Created by Android Studio.
 * User: 王震
 * Date: 2019/10/23
 * Time: 11:28
 */
public interface IHomeView extends IBaseView{
    //返回Token值
    void backToken(String token);

    //显示主页面数据
    void showGetHome(GetHomeEntity entity);
}
