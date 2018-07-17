package com.bwie.huangxiaoer.model;

import com.bwie.huangxiaoer.bean.GetAdBean;
import com.bwie.huangxiaoer.model.inter.GetAdModel;
import com.bwie.huangxiaoer.utils.OnNetListener;
import com.bwie.huangxiaoer.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * author: Wangxinrun
 * Date: 2018/7/9
 * Time: 10:32
 */

public class GetAdModelImp implements GetAdModel {
    @Override
    public void getAd(final OnNetListener onNetListener) {
        RetrofitUtils.getInstance().server().getAd()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<GetAdBean>() {
                    @Override
                    public void accept(GetAdBean getAdBean) throws Exception {
                        onNetListener.onSuccess(getAdBean);
                    }
                });
    }
}
