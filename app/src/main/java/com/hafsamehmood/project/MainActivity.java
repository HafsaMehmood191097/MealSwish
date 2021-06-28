package com.hafsamehmood.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    TextView mealswish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mealswish=findViewById(R.id.mealswish);
        Typeface font= Typeface.createFromAsset(getAssets(),"font/fonts.ttf");
        mealswish.setTypeface(font);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,Resturants.class);
                startActivity(intent);
                finish();
            }
        },4000);
    }
}