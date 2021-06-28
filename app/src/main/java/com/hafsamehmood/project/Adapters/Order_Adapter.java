package com.hafsamehmood.project.Adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hafsamehmood.project.Db_Helper;
import com.hafsamehmood.project.Models.Model_Order;
import com.hafsamehmood.project.OrderActivity;
import com.hafsamehmood.project.PlaceOrder;
import com.hafsamehmood.project.R;

import java.util.List;

public class Order_Adapter extends RecyclerView.Adapter<Order_Adapter.ViewHolder> {
    private List<Model_Order> list;
    Context context;

    public Order_Adapter(List<Model_Order> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Order_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Order_Adapter.ViewHolder holder, int position) {
        int imagefood=list.get(position).getImage_food();
        String FoodName=list.get(position).getFood_name();
        String ordertext=list.get(position).getOrder_text();
        String ordernumber=list.get(position).getOrder_number();
        String orderpricer=list.get(position).getPrice_food();
        String DividerLine=list.get(position).getDividerline();
        holder.setData(imagefood,FoodName,ordertext,ordernumber,orderpricer,DividerLine);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Db_Helper db_helper=new Db_Helper(context);
               new AlertDialog.Builder(context).setTitle("Delete Order").setIcon(R.drawable.ic_baseline_delete_24).setMessage("Are You Sure You Want to Delete Your Order?")
                       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {

                                   db_helper.deleteOrder(getItemId(position));
                                   Toast.makeText(context, "Deleted!", Toast.LENGTH_SHORT).show();

                           }

                       }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();
                   }
               }).show();
                return false;
            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView Image_food;
        private TextView Namefood;
        private TextView Ordertext;
        private TextView Ordernumber;
        private TextView pricefood;
        private TextView Divider_line;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Image_food=itemView.findViewById(R.id.imgview);
            Namefood=itemView.findViewById(R.id.foodname);
            Ordertext=itemView.findViewById(R.id.order_text);
            Ordernumber=itemView.findViewById(R.id.order_number);
            pricefood=itemView.findViewById(R.id.order_price);
            Divider_line=itemView.findViewById(R.id.divider);
        }

        public void setData(int imagefood, String foodName, String ordertext, String ordernumber, String orderpricer, String dividerLine) {
            Image_food.setImageResource(imagefood);
            Namefood.setText(foodName);
            Ordertext.setText(ordertext);
            Ordernumber.setText(ordernumber);
            pricefood.setText(orderpricer);
            Divider_line.setText(dividerLine);

        }
    }
}
