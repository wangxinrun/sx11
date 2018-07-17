package com.bwie.huangxiaoer.presenter;


import com.bwie.huangxiaoer.bean.ClassBean;
import com.bwie.huangxiaoer.model.ClassModelImp;
import com.bwie.huangxiaoer.presenter.inter.ClassPresenter;
import com.bwie.huangxiaoer.utils.OnNetListener;
import com.bwie.huangxiaoer.view.ClassView;

/**
 * author: Wangxinrun
 * Date: 2018/7/2
 * Time: 10:52
 */

public class ClassPresenterImp implements ClassPresenter {
    ClassView classView;
    ClassModelImp classModelImp;

    public ClassPresenterImp(ClassView classView) {
        this.classView = classView;
        classModelImp = new ClassModelImp();
    }

    @Override
    public void getfen() {
        classModelImp.getfen(new OnNetListener() {
            @Override
            public void onSuccess(Object o) {
                classView.getfen((ClassBean) o);
            }
        });
    }
}
