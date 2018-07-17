package com.bwie.huangxiaoer.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bwie.huangxiaoer.R;
import com.bwie.huangxiaoer.activity.ChangeNewsActivity;
import com.bwie.huangxiaoer.activity.CheapActivity;
import com.bwie.huangxiaoer.activity.IdeaTellActivity;
import com.bwie.huangxiaoer.activity.LikeShopActivity;
import com.bwie.huangxiaoer.activity.SettingActivity;


/**
 * Created by robot on 2017/11/20.
 */

public class Fragment2 extends Fragment implements View.OnClickListener {
    Context context;
    private View view;
    private RelativeLayout change_news,like_shop,cheap_shop,idea_tell,setting;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment2,container,false);
        initView();
        return view;
    }

    private void initView() {
        change_news = view.findViewById(R.id.change_news);
        change_news.setOnClickListener(this);
        like_shop=view.findViewById(R.id.like_shop);
        like_shop.setOnClickListener(this);
        cheap_shop=view.findViewById(R.id.cheap_shop);
        cheap_shop.setOnClickListener(this);
        idea_tell=view.findViewById(R.id.idea_tell);
        idea_tell.setOnClickListener(this);
        setting=view.findViewById(R.id.setting);
        setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.change_news:
                Intent intent=new Intent(getActivity(), ChangeNewsActivity.class);
                startActivity(intent);
                break;
            case R.id.like_shop:
                Intent intent1=new Intent(getActivity(), LikeShopActivity.class);
                startActivity(intent1);
                break;
            case R.id.cheap_shop:
                Intent intent2=new Intent(getActivity(), CheapActivity.class);
                startActivity(intent2);
                break;
            case R.id.idea_tell:
                Intent intent3=new Intent(getActivity(), IdeaTellActivity.class);
                startActivity(intent3);
                break;
            case R.id.setting:
                Intent intent4=new Intent(getActivity(), SettingActivity.class);
                startActivity(intent4);
                break;
        }
    }
}
