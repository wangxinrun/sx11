package com.bwie.huangxiaoer.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwie.huangxiaoer.R;
import com.bwie.huangxiaoer.activity.ListActivity;
import com.bwie.huangxiaoer.adapter.MyPageAdapter;

import java.util.ArrayList;


/**
 * Created by robot on 2017/11/20.
 */

public class MainFragment extends Fragment implements View.OnClickListener {
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mainfragment, container, false);
        initView();
        return view;
    }

    private void initView() {
        ImageView imageView = view.findViewById(R.id.iv);
        imageView.setOnClickListener(this);
        MyPageAdapter myPageAdapter = new MyPageAdapter(getFragmentManager());
        ArrayList<Fragment> datas = new ArrayList<Fragment>();
        datas.add(new FragmentRx());
        datas.add(new FragmentXc());
        datas.add(new FragmentYp());
        datas.add(new FragmentZp());
        datas.add(new FragmentZs());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("热销");
        strings.add("招牌");
        strings.add("主食");
        strings.add("小吃");
        strings.add("饮品");
        myPageAdapter.setTitles(strings);
        myPageAdapter.setData(datas);
        TabLayout tabLayout = view.findViewById(R.id.tl_tab);
        ViewPager viewPager = view.findViewById(R.id.vp_pager);
        viewPager.setAdapter(myPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), ListActivity.class);
        getActivity().startActivity(intent);
    }
}
