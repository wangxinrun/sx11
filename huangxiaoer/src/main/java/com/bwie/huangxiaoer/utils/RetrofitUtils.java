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
 * Date: 2018/7/5
 * Time: 15:39
 */

public class RetrofitUtils {
    private static RetrofitUtils instance;
    private static ApiServer apiServer;
    private OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build();

    private RetrofitUtils() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Api.URL)
                .build();
        apiServer = retrofit.create(ApiServer.class);
    }


    public static RetrofitUtils getInstance() {
        if (instance == null) {
            instance = new RetrofitUtils();
        }
        return instance;
    }

    public static ApiServer server() {
        return apiServer;
    }
}
