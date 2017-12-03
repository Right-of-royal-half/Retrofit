package com.baiwei.shenxuesong.retrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baiwei.shenxuesong.retrofit.Bean.Bean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 杨杰 on 2017/12/2.
 */

public class Adpter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<Bean.ResultsBean> resultsBeans;

    public Adpter(Context context, List<Bean.ResultsBean> resultsBeans) {
        this.context = context;
        this.resultsBeans = resultsBeans;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         MyViewHolder myViewHolder= (MyViewHolder) holder;
        List<String> images = resultsBeans.get(position).getImages();
        if (images!=null) {
            myViewHolder.sdv.setImageURI(images.get(0));
        }
        myViewHolder.tv.setText(resultsBeans.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return resultsBeans == null ? 0 : resultsBeans.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.sdv)
        SimpleDraweeView sdv;
        @BindView(R.id.tv)
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
