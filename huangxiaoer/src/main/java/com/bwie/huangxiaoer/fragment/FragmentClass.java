package com.bwie.huangxiaoer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.bwie.huangxiaoer.R;
import com.bwie.huangxiaoer.adapter.LeftAdapter;
import com.bwie.huangxiaoer.adapter.RightAdapter;
import com.bwie.huangxiaoer.bean.ClassBean;
import com.bwie.huangxiaoer.presenter.ClassPresenterImp;
import com.bwie.huangxiaoer.presenter.RightPresenterImp;
import com.bwie.huangxiaoer.view.ClassView;
import com.bwie.huangxiaoer.view.RightView;

/**
 * author: Wangxinrun
 * Date: 2018/7/12
 * Time: 9:44
 */

public class FragmentClass extends Fragment implements ClassView,RightView {
    View view;
    RecyclerView rlv1;
    ClassPresenterImp classPresenterImp;
    ExpandableListView elv;
    RightPresenterImp rightPresenterImp;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_class, container, false);
        initView();
        return view;
    }

    private void initView() {
        rlv1 = view.findViewById(R.id.rlv1);
        rlv1.setLayoutManager(new LinearLayoutManager(getContext()));
        classPresenterImp = new ClassPresenterImp(this);
        classPresenterImp.getfen();
        elv = view.findViewById(R.id.elv);
        rightPresenterImp = new RightPresenterImp(this);
        rightPresenterImp.getRight();
    }

    @Override
    public void getfen(ClassBean classBean) {
        final LeftAdapter leftAdapter = new LeftAdapter(getContext(), classBean.getData());
        rlv1.setAdapter(leftAdapter);
        leftAdapter.setRecyclerViewItemClieck(new LeftAdapter.RecyclerViewItemClieck() {
            @Override
            public void recyclerViewItemClieck(int position, View view, RecyclerView.ViewHolder viewHolder) {
                leftAdapter.setGetPosition(position);
                leftAdapter.notifyDataSetChanged();
            }
        });
    }

       @Override
    public void getRight(ClassBean classBean) {
        RightAdapter rightAdapter = new RightAdapter(getContext(), classBean.getData());
        elv.setAdapter(rightAdapter);
        for (int i = 0; i < classBean.getData().size(); i++) {
            elv.expandGroup(i);
        }
    }
}
