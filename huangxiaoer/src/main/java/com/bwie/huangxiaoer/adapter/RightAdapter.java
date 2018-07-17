package com.bwie.huangxiaoer.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.bwie.huangxiaoer.R;
import com.bwie.huangxiaoer.bean.ClassBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * author: Wangxinrun
 * Date: 2018/7/2
 * Time: 11:16
 */

public class RightAdapter extends BaseExpandableListAdapter {
    Context context;
    List<ClassBean.DataBean> list;

    public RightAdapter(Context context, List<ClassBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return list.get(i).getSpus().size();
    }

    @Override
    public Object getGroup(int i) {
        return list.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return list.get(i).getSpus().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        GroupViewHolder groupViewHolder;
        if (view == null) {
            groupViewHolder = new GroupViewHolder();
            view = view.inflate(context, R.layout.item1, null);
            groupViewHolder.tv = view.findViewById(R.id.tv);
            view.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) view.getTag();

        }
        groupViewHolder.tv.setText(list.get(i).getName());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup){
        ChildViewHolde childViewHolde;
        if (view == null) {
            childViewHolde = new ChildViewHolde();
            view = view.inflate(context, R.layout.item2, null);
            childViewHolde.tv1 = view.findViewById(R.id.tv1);
            childViewHolde.tv2 = view.findViewById(R.id.tv2);
            childViewHolde.tv3 = view.findViewById(R.id.tv3);
            childViewHolde.sv = view.findViewById(R.id.sv);
//            childViewHolde.adv = view.findViewById(R.id.adv_main);
            view.setTag(childViewHolde);
        } else {
            childViewHolde = (ChildViewHolde) view.getTag();
        }
        ClassBean.DataBean.SpusBean spusBean = list.get(i).getSpus().get(i1);
        childViewHolde.tv1.setText(spusBean.getName());
        childViewHolde.tv2.setText("月售:" + spusBean.getMonth_saled_content());
        childViewHolde.tv3.setText("￥:" + spusBean.getRestaurant_id() + "");
        Uri uri = Uri.parse(spusBean.getPic_url());
        childViewHolde.sv.setImageURI(uri);
//        childViewHolde.adv.setNumber(spusBean.getMonth_saled());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }


    class GroupViewHolder {
        TextView tv;
    }

    class ChildViewHolde {
        TextView tv1;
        TextView tv2;
        TextView tv3;
        SimpleDraweeView sv;
//        AddDeleteView adv;
    }

}
