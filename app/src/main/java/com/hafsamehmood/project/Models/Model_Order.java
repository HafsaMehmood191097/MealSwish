package com.hafsamehmood.project.Models;


public class Model_Order {

    int Image_food;
    String food_name,order_text,order_number,price_food,dividerline;

    public Model_Order(int image_food, String food_name, String order_text, String order_number, String price_food, String dividerline) {
        Image_food = image_food;
        this.food_name = food_name;
        this.order_text = order_text;
        this.order_number = order_number;
        this.price_food = price_food;
        this.dividerline = dividerline;
    }

    public int getImage_food() {
        return Image_food;
    }

    public String getFood_name() {
        return food_name;
    }

    public String getOrder_text() {
        return order_text;
    }

    public String getOrder_number() {
        return order_number;
    }

    public String getPrice_food() {
        return price_food;
    }

    public String getDividerline() {
        return dividerline;
    }

    public void setImage_food(int image_food) {
        Image_food = image_food;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public void setOrder_text(String order_text) {
        this.order_text = order_text;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public void setPrice_food(String price_food) {
        this.price_food = price_food;
    }

    public void setDividerline(String dividerline) {
        this.dividerline = dividerline;
    }
}
