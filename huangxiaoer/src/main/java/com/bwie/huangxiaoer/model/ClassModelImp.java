package com.bwie.huangxiaoer.model;

import com.bwie.huangxiaoer.bean.ClassBean;
import com.bwie.huangxiaoer.model.inter.ClassModel;
import com.bwie.huangxiaoer.utils.OnNetListener;
import com.bwie.huangxiaoer.utils.RetrofitUtils1;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * author: Wangxinrun
 * Date: 2018/7/2
 * Time: 10:50
 */

public class ClassModelImp implements ClassModel {
    @Override
    public void getfen(final OnNetListener onNetListener) {
        RetrofitUtils1.getInstance().server().fen()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ClassBean>() {
                    @Override
                    public void accept(ClassBean classBean) throws Exception {
                        onNetListener.onSuccess(classBean);
                    }
                });
    }
}
