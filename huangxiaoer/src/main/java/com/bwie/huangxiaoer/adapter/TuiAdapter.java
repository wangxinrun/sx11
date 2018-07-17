package com.bwie.huangxiaoer.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.huangxiaoer.R;
import com.bwie.huangxiaoer.bean.GetAdBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * author: Wangxinrun
 * Date: 2018/7/10
 * Time: 11:06
 */

public class TuiAdapter extends RecyclerView.Adapter<TuiAdapter.VH> {

    Context context;
    List<GetAdBean.TuijianBean.ListBean> list;

    public TuiAdapter(Context context, List<GetAdBean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tui, parent, false);
        VH vh = new VH(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.textView1.setText(list.get(position).getTitle());
        holder.textView2.setText(list.get(position).getPrice() + "");
        String[] split = list.get(position).getImages().split("\\|");
        Uri uri = Uri.parse(split[0]);
        holder.simpleDraweeView.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder {
        SimpleDraweeView simpleDraweeView;
        TextView textView1, textView2;

        public VH(View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.iv);
            textView1 = itemView.findViewById(R.id.tv1);
            textView2 = itemView.findViewById(R.id.tv2);
        }
    }
}
