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
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Android Studio.
 * User: 王震
 * Date: 2019/10/15
 * Time: 20:16
 */
public class VipListAdapter extends RecyclerView.Adapter<VipListAdapter.RVHolder> {

    List<GetHomeEntity.DataBean.ViplistBean> list;
    Context context;

    public VipListAdapter(List<GetHomeEntity.DataBean.ViplistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RVHolder(LayoutInflater.from(context).inflate(R.layout.item_viplist_rv, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder rvHolder, int i) {
        GetHomeEntity.DataBean.ViplistBean viplistBean = list.get(i);
        rvHolder.img.setImageURI(viplistBean.getImage());
        rvHolder.title.setText(viplistBean.getTitle());
        rvHolder.text.setText(viplistBean.getText1());
        if (viplistBean.isVip()) {
            rvHolder.vip.setText("会员");
        } else {
            rvHolder.vip.setText("仅会员可看");
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
        TextView title, vip, text;

        public RVHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.vip_img);
            title = itemView.findViewById(R.id.vip_title);
            vip = itemView.findViewById(R.id.vip_vip);
            text = itemView.findViewById(R.id.vip_text);
        }
    }
}
