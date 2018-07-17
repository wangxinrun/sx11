package com.bwie.huangxiaoer.initserver;

import com.bwie.huangxiaoer.bean.ClassBean;
import com.bwie.huangxiaoer.bean.GetAdBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * author: Wangxinrun
 * Date: 2018/7/5
 * Time: 15:46
 */

public interface ApiServer {
    @GET("ad/getAd")
    Observable<GetAdBean> getAd();

    @GET("6523/restaurant-list")
    Observable<ClassBean> fen();
}
