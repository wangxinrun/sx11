package com.bwie.huangxiaoer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;

import com.bwie.huangxiaoer.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import pl.droidsonroids.gif.GifImageView;

public class WelActivity extends AppCompatActivity {

    @InjectView(R.id.giv)
    GifImageView giv;
    @InjectView(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏，一定要在setContentView之前
        setContentView(R.layout.activity_wel);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {

    }

    @OnClick(R.id.iv)
    public void onViewClicked() {
        Intent intent=new Intent(WelActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
