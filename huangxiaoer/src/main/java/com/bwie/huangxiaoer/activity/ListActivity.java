package com.bwie.huangxiaoer.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.bwie.huangxiaoer.R;
import com.bwie.huangxiaoer.adapter.MyPageAdapter;
import com.bwie.huangxiaoer.fragment.FragmentClass;
import com.bwie.huangxiaoer.fragment.FragmentPj;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏，一定要在setContentView之前
        setContentView(R.layout.activity_list);
        initView();
    }

    private void initView() {

        MyPageAdapter myPageAdapter = new MyPageAdapter(getSupportFragmentManager());
        ArrayList<Fragment> datas = new ArrayList<Fragment>();
        datas.add(new FragmentClass());
        datas.add(new FragmentPj());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("餐品");
        strings.add("评价(999+)");
        myPageAdapter.setTitles(strings);
        myPageAdapter.setData(datas);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tl_tab);
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_pager);
        viewPager.setAdapter(myPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
