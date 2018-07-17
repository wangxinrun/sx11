package com.bwie.huangxiaoer.presenter;


import com.bwie.huangxiaoer.bean.ClassBean;
import com.bwie.huangxiaoer.model.ClassModelImp;
import com.bwie.huangxiaoer.presenter.inter.RightPresenter;
import com.bwie.huangxiaoer.utils.OnNetListener;
import com.bwie.huangxiaoer.view.RightView;

/**
 * author: Wangxinrun
 * Date: 2018/7/2
 * Time: 11:26
 */

public class RightPresenterImp implements RightPresenter {
    RightView rightView;
    ClassModelImp classModelImp;
    public RightPresenterImp(RightView rightView) {
        this.rightView = rightView;
        classModelImp = new ClassModelImp();
    }

    @Override
    public void getRight() {
        classModelImp.getfen(new OnNetListener() {
            @Override
            public void onSuccess(Object o) {
                rightView.getRight((ClassBean) o);
            }
        });
    }
}
