package com.example.yyzx_demo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yyzx_demo.R;
import com.example.yyzx_demo.service.model.entity.CategoryGetPerfesionalEntity;
import com.example.yyzx_demo.service.model.entity.GetHomeEntity;
import com.example.yyzx_demo.view.activity.category.PerfesionalActivity;

import java.util.List;

/**
 * Created by Android Studio.
 * User: 王震
 * Date: 2019/10/15
 * Time: 19:25
 */
public class PerfesionalAdapter extends RecyclerView.Adapter<PerfesionalAdapter.RVHolder> {

    List<CategoryGetPerfesionalEntity.DataBean> list;
    Context context;

    public PerfesionalAdapter(List<CategoryGetPerfesionalEntity.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RVHolder(LayoutInflater.from(context).inflate(R.layout.item_category_rv, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder rvHolder, int i) {
        CategoryGetPerfesionalEntity.DataBean dataBean = list.get(i);
        Glide.with(context).load(dataBean.getImage()).into(rvHolder.img);
        rvHolder.title.setText(dataBean.getShortName());
    }

    @Override
    public int getItemCount() {
        if (list.size() == 0) {
            return 0;
        }
        return list.size();
    }

    class RVHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title;

        public RVHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.category_img);
            title = itemView.findViewById(R.id.category_title);
        }
    }
}
