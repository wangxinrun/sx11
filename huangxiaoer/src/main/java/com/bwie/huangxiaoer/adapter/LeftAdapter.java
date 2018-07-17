package com.bwie.huangxiaoer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.huangxiaoer.R;
import com.bwie.huangxiaoer.bean.ClassBean;

import java.util.List;

/**
 * author: Wangxinrun
 * Date: 2018/7/2
 * Time: 10:54
 */

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.VH> {

    Context context;
    List<ClassBean.DataBean> list;
    public static int getPosition;

    public static int getGetPosition() {
        return getPosition;
    }

    public static void setGetPosition(int getPosition) {
        LeftAdapter.getPosition = getPosition;
    }

    public LeftAdapter(Context context, List<ClassBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.left_item, parent, false);
        final VH vh = new VH(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerViewItemClieck.recyclerViewItemClieck(vh.getAdapterPosition(),view,vh);
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.textView.setText(list.get(position).getName());
        if (getPosition==position){
            holder.itemView.setBackgroundResource(R.color.colorHui);
        }else{
            holder.itemView.setBackgroundResource(R.color.colorWhile);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder {
        TextView textView;

        public VH(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
        }
    }

    RecyclerViewItemClieck recyclerViewItemClieck;
    public interface RecyclerViewItemClieck{
        void recyclerViewItemClieck(int position, View view, RecyclerView.ViewHolder viewHolder);
    }

    public void setRecyclerViewItemClieck(RecyclerViewItemClieck recyclerViewItemClieck) {
        this.recyclerViewItemClieck = recyclerViewItemClieck;
    }
}
