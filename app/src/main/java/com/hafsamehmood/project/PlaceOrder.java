package com.hafsamehmood.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

import static java.lang.Integer.parseInt;

public class PlaceOrder extends AppCompatActivity {

    ImageView food_img,plus_img,minus_Img,Showshopping;
    TextView food_name,food_quantity,price_tag,Price;
    EditText Name,Phone;
    Button btn_place_order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        food_img=findViewById(R.id.foodView);
        plus_img=findViewById(R.id.add);
        minus_Img=findViewById(R.id.minus);
        food_name=findViewById(R.id.foodname_place);
        food_quantity=findViewById(R.id.quantity);
        price_tag=findViewById(R.id.pricetext_place);
        Price=findViewById(R.id.price_place);
        Name=findViewById(R.id.place_order_name);
        Phone=findViewById(R.id.phone_order);
        btn_place_order=findViewById(R.id.button_placeorder);
        Showshopping=findViewById(R.id.showshopping);
        final int foodimg=getIntent().getIntExtra("FoodImage",0);
        final String foodname=getIntent().getStringExtra("FoodName");
        final String foodPrice=getIntent().getStringExtra("FoodPrice");
        food_img.setImageResource(foodimg);
        food_name.setText(foodname);
        Price.setText(foodPrice);
        final int[] quantity = {Integer.parseInt(food_quantity.getText().toString())};
        Db_Helper db_helper=new Db_Helper(this);
        btn_place_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=Name.getText().toString();
                String phone=Phone.getText().toString();

                boolean inserted=db_helper.InsertOrder(name,foodimg,phone, quantity[0],foodname,foodPrice);
                if(inserted==true){
                    Toast.makeText(PlaceOrder.this, "Saved", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(PlaceOrder.this, "Abrupted", Toast.LENGTH_SHORT).show();
            }
        });
        Showshopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PlaceOrder.this,OrderActivity.class);
                startActivity(intent);
            }
        });
        plus_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity[0]++;
            }
        });
        minus_Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity[0]--;
            }
        });

    }
}
