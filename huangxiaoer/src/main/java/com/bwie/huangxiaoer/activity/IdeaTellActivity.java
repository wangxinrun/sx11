package com.bwie.huangxiaoer.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.bwie.huangxiaoer.R;

public class IdeaTellActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView idea_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏，一定要在setContentView之前
        setContentView(R.layout.activity_idea_tell);
        initView();
    }
    private void initView() {
        idea_back = (ImageView) findViewById(R.id.idea_back);
        idea_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.idea_back:
                finish();
                break;
        }
    }
}
