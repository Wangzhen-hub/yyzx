package com.example.yyzx_demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yyzx_demo.R;
import com.example.yyzx_demo.service.model.entity.GetHomeEntity;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Android Studio.
 * User: 王震
 * Date: 2019/10/15
 * Time: 20:16
 */
public class LivesAdapter extends RecyclerView.Adapter<LivesAdapter.RVHolder> {

    List<GetHomeEntity.DataBean.MasterLivesBean> list;
    Context context;

    public LivesAdapter(List<GetHomeEntity.DataBean.MasterLivesBean> list, Context context) {
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
        GetHomeEntity.DataBean.MasterLivesBean masterLivesBean = list.get(i);
        rvHolder.img.setImageURI(masterLivesBean.getImageUrl());
        rvHolder.title.setText(masterLivesBean.getAppTitle());
        rvHolder.teacherName.setText(masterLivesBean.getTeacherName());
        rvHolder.teacherTitle.setText(masterLivesBean.getTeacherTitle());
        if (!masterLivesBean.isLiveIsBuy() & masterLivesBean.getPrice() != 0) {
            rvHolder.price.setText(masterLivesBean.getPrice() + "元");
        } else {
            rvHolder.price.setText("免费");
        }
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
