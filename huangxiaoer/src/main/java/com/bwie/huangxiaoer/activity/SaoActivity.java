package com.bwie.huangxiaoer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwie.huangxiaoer.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class SaoActivity extends AppCompatActivity {

    @InjectView(R.id.img)
    ImageView img;
    @InjectView(R.id.but1)
    RadioButton but1;
    @InjectView(R.id.but2)
    RadioButton but2;
    @InjectView(R.id.rlbuttom)
    RadioGroup rlbuttom;
    @InjectView(R.id.iv_zhong)
    RadioButton ivZhong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏，一定要在setContentView之前
        setContentView(R.layout.activity_sao);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.img, R.id.but1, R.id.but2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img:
                Bundle bundle1=new Bundle();
                bundle1.putInt("aa",1);
                Intent intent1=new Intent(SaoActivity.this,MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.but1:
                Bundle bundle2=new Bundle();
                bundle2.putInt("aa",2);
                Intent intent2=new Intent(SaoActivity.this, MainActivity.class);
                intent2.putExtras(bundle2);
                startActivity(intent2);
                break;
            case R.id.but2:
                Bundle bundle3=new Bundle();
                bundle3.putInt("aa",3);
                Intent intent3=new Intent(SaoActivity.this, MainActivity.class);
                intent3.putExtras(bundle3);
                startActivity(intent3);
                break;
        }
    }
}
