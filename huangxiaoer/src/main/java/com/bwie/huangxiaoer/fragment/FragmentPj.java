package com.bwie.huangxiaoer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.huangxiaoer.R;

/**
 * author: Wangxinrun
 * Date: 2018/7/12
 * Time: 9:44
 */

public class FragmentPj extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pj, container, false);
        return view;
    }
}