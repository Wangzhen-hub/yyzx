package com.example.yyzx_demo.api;

import com.example.yyzx_demo.service.model.entity.CategoryGetPerfesionalEntity;
import com.example.yyzx_demo.service.model.entity.GetHomeEntity;
import com.example.yyzx_demo.service.model.entity.GetMasterLiveEntity;
import com.example.yyzx_demo.service.model.entity.GetVideoEntity;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Android Studio.
 * User: 王震
 * Date: 2019/10/12
 * Time: 11:05
 */
public interface ApiService {
    String BASE_URL = "http://api.immedc.com/restapi/";
    //获取主页信息
    String GET_HOME = "loading/getHome";
    //创建新用户
    String CREATE_NEW = "account/createNew";
    //获取视频页面
    String GET_VIDEO = "course/getVideo2";
    //音乐课堂
    String CATEGORY_GET_PERFESIONAL = "category/getPerfesional?pid=1";
    //在线直播
    String CATEGORY_GET_MASTER_LIVE = "live/getMasterlives?grade=0&page=1&size=20";

    @POST(CREATE_NEW)
    @FormUrlEncoded
    Observable<ResponseBody> createNew(@FieldMap HashMap<String, String> map);

    @GET(GET_HOME)
    Observable<GetHomeEntity> getHome(@Header("CH-TOKEN") String token);

    @POST(GET_VIDEO)
    @FormUrlEncoded
    Observable<GetVideoEntity> getVideo(@FieldMap HashMap<String, String> map);

    @GET(CATEGORY_GET_PERFESIONAL)
    Observable<CategoryGetPerfesionalEntity> getPerfesional(@Header("CH-TOKEN") String token);

    @GET(CATEGORY_GET_MASTER_LIVE)
    Observable<GetMasterLiveEntity> getMasterLive(@Header("CH-TOKEN") String token);
}
