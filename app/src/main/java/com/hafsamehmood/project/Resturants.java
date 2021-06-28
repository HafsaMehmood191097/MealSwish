package com.hafsamehmood.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.hafsamehmood.project.Adapters.Adapter;
import com.hafsamehmood.project.Models.Model_Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Resturants extends AppCompatActivity implements Adapter.onItemClickListner {

    List<Model_Restaurant> list=new ArrayList<>();
    RecyclerView recyclerview;
    Adapter recyclerAdapter;
    TextView restuarent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturants);
        restuarent=findViewById(R.id.rest_text);

        Typeface font= Typeface.createFromAsset(getAssets(),"font/fonts.ttf");
        restuarent.setTypeface(font);
        list.add(new Model_Restaurant("Gloria Jeans",R.drawable.pic1,R.drawable.star2));
        list.add(new Model_Restaurant("Secret Sky",R.drawable.pic2,R.drawable.star2));
        list.add(new Model_Restaurant("McDonalds",R.drawable.pic4,R.drawable.star2));
        list.add(new Model_Restaurant("Mindanos",R.drawable.pic5,R.drawable.star2));
        list.add(new Model_Restaurant("Cuisine",R.drawable.cuisine,R.drawable.star2));
        list.add(new Model_Restaurant("Subway",R.drawable.pic7,R.drawable.star2));

        recyclerview=findViewById(R.id.RecyclerView);
        recyclerAdapter=new Adapter(list,getApplicationContext());
        recyclerview.setLayoutManager(new GridLayoutManager(this,2));
        recyclerview.setAdapter(recyclerAdapter);
        Adapter.setonItemClickListner(Resturants.this);

    }

    @Override
    public void onclick(int position) {
        final Intent intent;
        switch (position){
            case 0:
                intent =  new Intent(this, GloriaJeans.class);
                break;
            case 1:
                intent =  new Intent(this, SecretSky.class);
                break;

            case 2:
                intent =  new Intent(this, McDonalds.class);
                break;
            case 3:
                intent =  new Intent(this, Mindanos.class);
                break;
            case 4:
                intent =  new Intent(this, Cuisine.class);
                break;

            case 5:
                intent =  new Intent(this, Subway.class);
                break;

            default:
                intent =  new Intent(this, Resturants.class);
                break;
        }
        this.startActivity(intent);

    }
}