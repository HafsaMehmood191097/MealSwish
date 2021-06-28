package com.hafsamehmood.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.hafsamehmood.project.Models.Model_Order;

import java.util.ArrayList;

public class Db_Helper extends SQLiteOpenHelper {

    private static String DATABASE_NAME="OrderRecord.db";
    private static  int DATABASE_VERSION=2;
    public Db_Helper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
           db.execSQL("Create table Orders"+"(Id int primary key,Image int, UserName TEXT,Phone TEXT,Quantity int,FoodName TEXT,FoodPrice TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("Drop table if exists Orders ");
            onCreate(db);
    }

    public boolean InsertOrder(String UserName,int Image,String Phone,int Quantity,String FoodName,String FoodPrice )
    {
        SQLiteDatabase db=getReadableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("UserName",UserName);
        contentValues.put("Image",Image);
        contentValues.put("Phone",Phone);
        contentValues.put("Quantity",Quantity);
        contentValues.put("FoodName",FoodName);
        contentValues.put("FoodPrice",FoodPrice);
        long id=db.insert("Orders",null,contentValues);
        if(id<=0)
        {
           return false;
        }
        else return true;
    }

    public ArrayList<Model_Order> getOrders(){
        ArrayList<Model_Order> list=new ArrayList<>();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from Orders",null);
        if(cursor.moveToNext()) {
        while(cursor.moveToNext()){
            Model_Order model=new Model_Order(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
            list.add(model);
        }
        }
        cursor.close();
        db.close();
        return list;
    }

    public int deleteOrder(long Id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("Orders","Id="+Id,null);
    }
}
