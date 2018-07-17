package com.bwie.huangxiaoer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.RadioGroup;

import com.bwie.huangxiaoer.R;
import com.bwie.huangxiaoer.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<Integer> list;
    private RadioGroup radioGroup;
    private int i = 0;
    private boolean mIsScrolled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏，一定要在setContentView之前
        setContentView(R.layout.activity_guide);
        initView();

    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        list = new ArrayList<Integer>();
        list.add(R.mipmap.q1);
        list.add(R.mipmap.q2);
        list.add(R.mipmap.q3);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, list);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                switch (arg0) {
                    case 0:
                        radioGroup.check(R.id.but01);
                        break;
                    case 1:
                        radioGroup.check(R.id.but02);
                        break;
                    case 2:
                        radioGroup.check(R.id.but03);
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub
                switch (arg0) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        mIsScrolled = false;
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        mIsScrolled = true;
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        if (!mIsScrolled) {
                            // TODO     你想要实现的操作
                            Intent intent = new Intent(GuideActivity.this, WelActivity.class);
                            startActivity(intent);
                        }
                        mIsScrolled = true;
                }
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.but01:
                        viewPager.setCurrentItem(0, false);
                        break;
                    case R.id.but02:
                        viewPager.setCurrentItem(1, false);
                        break;
                    case R.id.but03:
                        viewPager.setCurrentItem(2, false);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
