package com.example.intro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private Context context;
    private List<Model> models;


    public MyAdapter(Context context, List<Model> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.slider_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.slideImg1.setImageResource(models.get(position).getImg1());
        holder.slideImg2.setImageResource(models.get(position).getImg2());

        holder.slideImg1.setAnimation(models.get(position).getAnimation1());
        holder.slideImg2.setAnimation(models.get(position).getAnimation2());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView slideImg1, slideImg2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            slideImg1 = itemView.findViewById(R.id.imageView);
            slideImg2 = itemView.findViewById(R.id.imageView2);
        }
    }
}
