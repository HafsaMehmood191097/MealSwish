package com.hafsamehmood.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hafsamehmood.project.Adapters.SecretSkyAdapter;
import com.hafsamehmood.project.Models.Modelofallrecipes;

import java.util.ArrayList;
import java.util.List;

public class SecretSky extends AppCompatActivity {
    RecyclerView recyclerview;
    LinearLayoutManager layoutmanager;
    SecretSkyAdapter adapter;
    List<Modelofallrecipes> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret_sky);
        InitiateData();
        InitiateRecyclerView();
    }

    private void InitiateData() {
        list=new ArrayList<>();
        list.add(new Modelofallrecipes(R.drawable.friedchicken,R.drawable.star2,R.drawable.ic_baseline_shopping_cart_24,"Turkish SandWich","Rs 270","Reviews 53","_________________________________________________________________________________________________________________________________________________"));
        list.add(new Modelofallrecipes(R.drawable.tawafry,R.drawable.star4,R.drawable.ic_baseline_shopping_cart_24,"Tawa Fry","Rs 450","Reviews 62","_________________________________________________________________________________________________________________________________________________"));
        list.add(new Modelofallrecipes(R.drawable.friedchicks,R.drawable.star4,R.drawable.ic_baseline_shopping_cart_24,"Madhuvaan","Rs 330","Reviews 55","_________________________________________________________________________________________________________________________________________________"));
        list.add(new Modelofallrecipes(R.drawable.hakkanoodles,R.drawable.star2,R.drawable.ic_baseline_shopping_cart_24,"Hakka Noodles","Rs 450","Reviews 54","_________________________________________________________________________________________________________________________________________________"));
        list.add(new Modelofallrecipes(R.drawable.grossingpizza,R.drawable.star4,R.drawable.ic_baseline_shopping_cart_24,"Grossing Pizza","Rs 550","Reviews 56","_________________________________________________________________________________________________________________________________________________"));
        list.add(new Modelofallrecipes(R.drawable.turkey,R.drawable.star4,R.drawable.ic_baseline_shopping_cart_24,"Grilled Sadwich","Rs 350","Reviews 67","_________________________________________________________________________________________________________________________________________________"));
        list.add(new Modelofallrecipes(R.drawable.ginospizza,R.drawable.star2,R.drawable.ic_baseline_shopping_cart_24,"Ginos Pizza","Rs 650","Reviews 71","_________________________________________________________________________________________________________________________________________________"));
        list.add(new Modelofallrecipes(R.drawable.hakkanoodles,R.drawable.star4,R.drawable.ic_baseline_shopping_cart_24,"Fried Chicks","Rs 570","Reviews 58","_________________________________________________________________________________________________________________________________________________"));
        list.add(new Modelofallrecipes(R.drawable.friedchicken,R.drawable.star4,R.drawable.ic_baseline_shopping_cart_24,"Fried Chicken","Rs 810","Reviews 74","_________________________________________________________________________________________________________________________________________________"));

    }

    private  void InitiateRecyclerView(){
        recyclerview=findViewById(R.id.recyclerviewsecretsky);
        layoutmanager=new LinearLayoutManager(this);
        layoutmanager.setOrientation(RecyclerView.VERTICAL);
        recyclerview.setLayoutManager(layoutmanager);
        adapter=new SecretSkyAdapter(list,SecretSky.this);
        recyclerview.setAdapter(adapter);
        recyclerview.setHasFixedSize(true);
        adapter.notifyDataSetChanged();

    }

}
