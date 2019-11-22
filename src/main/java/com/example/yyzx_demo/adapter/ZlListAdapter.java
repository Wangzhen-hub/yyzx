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
public class ZlListAdapter extends RecyclerView.Adapter<ZlListAdapter.RVHolder> {

    List<GetHomeEntity.DataBean.ZlListBean> list;
    Context context;

    public ZlListAdapter(List<GetHomeEntity.DataBean.ZlListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RVHolder(LayoutInflater.from(context).inflate(R.layout.item_zllist_rv, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder rvHolder, int i) {
        GetHomeEntity.DataBean.ZlListBean zlListBean = list.get(i);
        rvHolder.img.setImageURI(zlListBean.getImage());
        rvHolder.title.setText(zlListBean.getTitle());
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
        TextView title;

        public RVHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.zl_img);
            title = itemView.findViewById(R.id.zl_title);
        }
    }
}
