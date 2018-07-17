package com.bwie.huangxiaoer.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * author: Wangxinrun
 * Date: 2018/7/4
 * Time: 14:45
 */

public class ViewPagerAdapter extends PagerAdapter{
    private Context context;
    private List<Integer> list;

    public ViewPagerAdapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub

        ImageView imageView = new ImageView(context);

        imageView.setImageResource(list.get(position%list.size()));//以取模的形式 实现图片轮播

        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        container.addView(imageView);

        return imageView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub

        container.removeView((View) object);

    }
}
