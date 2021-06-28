package com.hafsamehmood.project.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hafsamehmood.project.Models.Modelofallrecipes;
import com.hafsamehmood.project.PlaceOrder;
import com.hafsamehmood.project.R;

import java.util.List;

public class SecretSkyAdapter extends RecyclerView.Adapter<SecretSkyAdapter.ViewHolder> {
    private List<Modelofallrecipes> list_secret;
    Context context;

    public SecretSkyAdapter(List<Modelofallrecipes> list_secret, Context context) {
        this.list_secret = list_secret;
        this.context = context;
    }

    @NonNull
    @Override
    public SecretSkyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_foods,parent,false);
        return new SecretSkyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SecretSkyAdapter.ViewHolder holder, int position) {
        final Modelofallrecipes model=list_secret.get(position);
        holder.Image_food.setImageResource(model.getImage_food());
        holder.ReviewsImage.setImageResource(model.getImageReviews());
        holder.cartImage.setImageResource(model.getImage_cart());
        holder.Namefood.setText(model.getFood_Name());
        holder.foodtype.setText(model.getFood_Type());
        holder.Reviewsfood.setText(model.getFood_Reviews());
        holder.Divider_line.setText(model.getDivider());
        holder.cartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,PlaceOrder.class);
                intent.putExtra("FoodImage",model.getImage_food());
                intent.putExtra("FoodName",model.getFood_Name());
                intent.putExtra("FoodPrice",model.getFood_Type());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_secret.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView Image_food;
        private ImageView ReviewsImage;
        private ImageView cartImage;
        private TextView Namefood;
        private TextView foodtype;
        private TextView Reviewsfood;
        private TextView Divider_line;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Image_food=itemView.findViewById(R.id.imgview);
            Reviewsfood=itemView.findViewById(R.id.num_reviews);
            cartImage=itemView.findViewById(R.id.carticon);
            ReviewsImage=itemView.findViewById(R.id.reviwstrs);
            Divider_line=itemView.findViewById(R.id.divider);
            foodtype=itemView.findViewById(R.id.foodtype);
            Namefood=itemView.findViewById(R.id.foodname);

        }

    }
}
