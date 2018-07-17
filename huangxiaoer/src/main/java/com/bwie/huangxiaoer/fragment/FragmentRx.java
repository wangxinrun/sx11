package com.bwie.huangxiaoer.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwie.huangxiaoer.R;
import com.bwie.huangxiaoer.adapter.TuiAdapter;
import com.bwie.huangxiaoer.bean.GetAdBean;
import com.bwie.huangxiaoer.presenter.GetAdPresenterImp;
import com.bwie.huangxiaoer.view.GetAdView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;


public class FragmentRx extends Fragment implements GetAdView {
    Context context;
    View view;
    XBanner xBanner;
    GetAdPresenterImp getAdPresenterImp;
    RecyclerView rlv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rx, container, false);
        initView();
        return view;
    }

    private void initView() {
        xBanner = view.findViewById(R.id.xb);
        getAdPresenterImp = new GetAdPresenterImp(this);
        getAdPresenterImp.getAd();
        rlv = view.findViewById(R.id.rlv);
        rlv.setLayoutManager(new GridLayoutManager(getContext(),2,LinearLayoutManager.VERTICAL,false));
        getAdPresenterImp.getTui();
    }

    @Override
    public void getAd(GetAdBean getAdBean) {
        List<GetAdBean.DataBean> data = getAdBean.getData();
        final List<String> list = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String icon = data.get(i).getIcon();
            list.add(icon);
        }
        xBanner.setData(list, null);
        xBanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getActivity()).load(list.get(position)).into((ImageView) view);
            }
        });
    }

    @Override
    public void getTui(GetAdBean getAdBean) {
        TuiAdapter tuiAdapter = new TuiAdapter(getContext(), getAdBean.getTuijian().getList());
        rlv.setAdapter(tuiAdapter);
    }
}