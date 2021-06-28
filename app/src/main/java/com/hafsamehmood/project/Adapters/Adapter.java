package com.hafsamehmood.project.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hafsamehmood.project.Models.Model_Restaurant;
import com.hafsamehmood.project.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<Model_Restaurant> list;
    public Context context;
    public Adapter(List<Model_Restaurant> list,Context context) {
        this.list = list;
        this.context = context;
    }
    private static onItemClickListner mlistner;
   public interface onItemClickListner{
        public void onclick(int position);
   }
   public static void setonItemClickListner(onItemClickListner listner){
       mlistner=listner;

   }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.restaurant.setImageResource(list.get(position).getImg_rest());
        holder.reviews.setImageResource(list.get(position).getStars());
        holder.name.setText(list.get(position).getName_rest());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView restaurant,reviews;
        CardView cardview;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            restaurant = itemView.findViewById(R.id.iv_rest);
            reviews = itemView.findViewById(R.id.iv_stars);
            cardview = itemView.findViewById(R.id.cardview_rest);
             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if(mlistner !=null) {
                         int position = getAdapterPosition();
                         if(position !=RecyclerView.NO_POSITION) {
                          mlistner.onclick(position);
                         }
                     }
                 }
             });
        }


    }
}
