package com.bwie.huangxiaoer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.bwie.huangxiaoer.R;
import com.bwie.huangxiaoer.adapter.MainViewPagerAdapter;
import com.bwie.huangxiaoer.fragment.Fragment1;
import com.bwie.huangxiaoer.fragment.Fragment2;
import com.bwie.huangxiaoer.fragment.MainFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton but1, but2;
    private RadioButton main_img;
    private ViewPager viewPager;
    private MainViewPagerAdapter pagerAdapter;
    private FrameLayout frameLayout;
    private MainFragment mainFragment;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private MainViewPagerAdapter pagerAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏，一定要在setContentView之前
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        pagerAdapter1 = new MainViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter1);
        //接收跳转
        Intent intent = getIntent();
        int aa = intent.getIntExtra("aa", 0);
        if (aa == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, mainFragment).commit();
        } else if (aa == 2) {
            getSupportFragmentManager().beginTransaction().hide(mainFragment).commit();
            but1.setChecked(true);
            but2.setChecked(false);
            viewPager.setVisibility(View.VISIBLE);
            viewPager.setCurrentItem(0);
        } else if (aa == 3) {
            getSupportFragmentManager().beginTransaction().hide(mainFragment).commit();
            but2.setChecked(true);
            but1.setChecked(false);
            viewPager.setVisibility(View.VISIBLE);
            viewPager.setCurrentItem(1);
        }
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    //滑动时图片的选中状态
                    case 0:
                        but1.setChecked(true);
                        but2.setChecked(false);
                        break;
                    case 1:
                        but2.setChecked(true);
                        but1.setChecked(false);
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        viewPager = (ViewPager) findViewById(R.id.viewPager);//ViewPager
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);//FrameLayout
        mainFragment = new MainFragment();
        but1 = (RadioButton) findViewById(R.id.but1);
        but2 = (RadioButton) findViewById(R.id.but2);
        main_img = (RadioButton) findViewById(R.id.main_img);
        main_img.setOnClickListener(this);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, mainFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, fragment1).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, fragment2).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, mainFragment).commit();
        viewPager.setVisibility(View.GONE);//隐藏ViewPager
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but1:
                viewPager.setVisibility(View.VISIBLE);
                viewPager.setCurrentItem(0);
                getSupportFragmentManager().beginTransaction().hide(mainFragment).commit();
                break;
            case R.id.main_img:
//                viewPager.setCurrentItem(1);
                //展示中间的Fragment  隐藏ViewPager
                getSupportFragmentManager().beginTransaction().show(mainFragment).commit();
                viewPager.setVisibility(View.GONE);
                but1.setChecked(false);
                but2.setChecked(false);
                break;
            case R.id.but2:
                viewPager.setVisibility(View.VISIBLE);
                viewPager.setCurrentItem(1);
                getSupportFragmentManager().beginTransaction().hide(mainFragment).commit();
                break;
        }
    }
}
