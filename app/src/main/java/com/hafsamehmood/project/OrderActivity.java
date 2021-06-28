package com.hafsamehmood.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hafsamehmood.project.Adapters.McdoladsAdapter;
import com.hafsamehmood.project.Adapters.Order_Adapter;
import com.hafsamehmood.project.Models.Model_Order;
import com.hafsamehmood.project.Models.Modelofallrecipes;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    RecyclerView recyclerview;
    LinearLayoutManager layoutmanager;
    Order_Adapter adapter;
    List<Model_Order> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Db_Helper db_helper=new Db_Helper(this);
        list=db_helper.getOrders();
        recyclerview=findViewById(R.id.recyclerorder);
        layoutmanager=new LinearLayoutManager(this);
        layoutmanager.setOrientation(RecyclerView.VERTICAL);
        recyclerview.setLayoutManager(layoutmanager);
        adapter=new Order_Adapter(list,OrderActivity.this);
        recyclerview.setAdapter(adapter);
        recyclerview.setHasFixedSize(true);
        adapter.notifyDataSetChanged();
    }


}