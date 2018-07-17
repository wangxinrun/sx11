package com.bwie.huangxiaoer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.huangxiaoer.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @InjectView(R.id.logo)
    ImageView logo;
    @InjectView(R.id.et_login_phone)
    EditText etLoginPhone;
    @InjectView(R.id.layout_name)
    RelativeLayout layoutName;
    @InjectView(R.id.view1)
    View view1;
    @InjectView(R.id.et_login_pwd)
    EditText etLoginPwd;
    @InjectView(R.id.iv_login_yanzhengma)
    ImageView ivLoginYanzhengma;
    @InjectView(R.id.daojishi_text)
    TextView daojishiText;
    @InjectView(R.id.daojishi)
    RelativeLayout daojishi;
    @InjectView(R.id.relativeLayout1)
    RelativeLayout relativeLayout1;
    @InjectView(R.id.et_login_pwd2)
    EditText etLoginPwd2;
    @InjectView(R.id.showmima)
    ImageView showmima;
    @InjectView(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @InjectView(R.id.ll2)
    RelativeLayout ll2;
    @InjectView(R.id.login)
    Button login;
    @InjectView(R.id.tv_login_changgui)
    TextView tvLoginChanggui;
    @InjectView(R.id.layout_login)
    RelativeLayout layoutLogin;
    @InjectView(R.id.tv1)
    TextView tv1;
    @InjectView(R.id.iv_dxlogin_WX)
    ImageView ivDxloginWX;
    @InjectView(R.id.iv_dxlogin_QQ)
    ImageView ivDxloginQQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏，一定要在setContentView之前
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {

    }

    @OnClick(R.id.login)
    public void onViewClicked() {
        Intent intent = new Intent(LoginActivity.this, SaoActivity.class);
        startActivity(intent);
    }
}
