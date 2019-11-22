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
import com.example.yyzx_demo.service.model.entity.GetMasterLiveEntity;
import com.example.yyzx_demo.view.activity.GetVideoActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Android Studio.
 * User: 王震
 * Date: 2019/10/15
 * Time: 19:25
 */
public class MasterLiveAdapter extends RecyclerView.Adapter<MasterLiveAdapter.RVHolder> {

    List<GetMasterLiveEntity.DataBean> list;
    Context context;

    public MasterLiveAdapter(List<GetMasterLiveEntity.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RVHolder(LayoutInflater.from(context).inflate(R.layout.item_lives_rv, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder rvHolder, int i) {
        GetMasterLiveEntity.DataBean dataBean = list.get(i);

        rvHolder.img.setImageURI(dataBean.getImageUrl());
        rvHolder.title.setText(dataBean.getCourseTitle());
        rvHolder.teacherName.setText(dataBean.getTeacherName());
        rvHolder.teacherTitle.setText(dataBean.getTeacherTitle());
        if (!dataBean.isLiveIsBuy() & dataBean.getPrice() != 0) {
            rvHolder.price.setText(dataBean.getPrice() + "元");
        } else {
            rvHolder.price.setText("免费");
        }

        rvHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GetVideoActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list.size() == 0) {
            return 0;
        }
        return list.size();
    }

    class RVHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView img;
        TextView title, teacherName, teacherTitle, price;

        public RVHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.lives_img);
            title = itemView.findViewById(R.id.lives_title);
            teacherName = itemView.findViewById(R.id.lives_teacher_name);
            teacherTitle = itemView.findViewById(R.id.lives_teacher_title);
            price = itemView.findViewById(R.id.lives_price);
        }
    }
}
