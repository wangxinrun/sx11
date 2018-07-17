package com.bwie.huangxiaoer.utils;

import com.bwie.huangxiaoer.api.Api;
import com.bwie.huangxiaoer.initserver.ApiServer;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: Wangxinrun
 * Date: 2018/7/12
 * Time: 10:07
 */

public class RetrofitUtils1 {
    private static RetrofitUtils1 instance;
    private static ApiServer apiServer;
    private OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build();

    private RetrofitUtils1() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Api.URL1)
                .build();
        apiServer = retrofit.create(ApiServer.class);
    }

    public static RetrofitUtils1 getInstance() {
        if (instance == null) {
            instance = new RetrofitUtils1();
        }
        return instance;
    }

    public static ApiServer server() {
        return apiServer;
    }
}
