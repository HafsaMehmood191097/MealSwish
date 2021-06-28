package com.hafsamehmood.project.Models;

public class Modelofallrecipes {

    private int Image_food;
    private int ImageReviews;
    private int Image_cart;
    private String food_Name;
    private String food_Type;
    private String food_Reviews;
    private String Divider;

    public Modelofallrecipes(int image_food, int imageReviews, int image_cart, String food_Name, String food_Type, String food_Reviews, String divider) {
        Image_food = image_food;
        ImageReviews = imageReviews;
        Image_cart = image_cart;
        this.food_Name = food_Name;
        this.food_Type = food_Type;
        this.food_Reviews = food_Reviews;
        Divider = divider;
    }

    public int getImage_food() {
        return Image_food;
    }

    public int getImageReviews() {
        return ImageReviews;
    }

    public int getImage_cart() {
        return Image_cart;
    }

    public String getFood_Name() {
        return food_Name;
    }

    public String getFood_Type() {
        return food_Type;
    }

    public String getFood_Reviews() {
        return food_Reviews;
    }

    public String getDivider() {
        return Divider;
    }

    public void setImage_food(int image_food) {
        Image_food = image_food;
    }

    public void setImageReviews(int imageReviews) {
        ImageReviews = imageReviews;
    }

    public void setImage_cart(int image_cart) {
        Image_cart = image_cart;
    }

    public void setFood_Name(String food_Name) {
        this.food_Name = food_Name;
    }

    public void setFood_Type(String food_Type) {
        this.food_Type = food_Type;
    }

    public void setFood_Reviews(String food_Reviews) {
        this.food_Reviews = food_Reviews;
    }

    public void setDivider(String divider) {
        Divider = divider;
    }
}
