package com.bwie.huangxiaoer.presenter;

import com.bwie.huangxiaoer.bean.GetAdBean;
import com.bwie.huangxiaoer.model.GetAdModelImp;
import com.bwie.huangxiaoer.presenter.inter.GetAdPresenter;
import com.bwie.huangxiaoer.utils.OnNetListener;
import com.bwie.huangxiaoer.view.GetAdView;

/**
 * author: Wangxinrun
 * Date: 2018/7/9
 * Time: 10:35
 */

public class GetAdPresenterImp implements GetAdPresenter {
    GetAdView getAdView;
    GetAdModelImp getAdModelImp;

    public GetAdPresenterImp(GetAdView getAdView) {
        this.getAdView = getAdView;
        getAdModelImp = new GetAdModelImp();
    }

    @Override
    public void getAd() {
        getAdModelImp.getAd(new OnNetListener() {
            @Override
            public void onSuccess(Object o) {
                getAdView.getAd((GetAdBean) o);
            }
        });
    }

    @Override
    public void getTui() {
        getAdModelImp.getAd(new OnNetListener() {
            @Override
            public void onSuccess(Object o) {
                getAdView.getTui((GetAdBean) o);
            }
        });
    }
}
