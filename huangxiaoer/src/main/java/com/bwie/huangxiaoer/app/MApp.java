package com.bwie.huangxiaoer.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * author: Wangxinrun
 * Date: 2018/7/5
 * Time: 15:44
 */

public class MApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        CrashReport.initCrashReport(getApplicationContext(), "b61c1fdc17", false);
    }
}
