package com.hafsamehmood.project.Models;

public class Model_Restaurant {

    String name_rest;
    int img_rest,stars;

    public Model_Restaurant(String name_rest, int img_rest, int stars) {
        this.name_rest = name_rest;
        this.img_rest = img_rest;
        this.stars = stars;
    }

    public void setName_rest(String name_rest) {
        this.name_rest = name_rest;
    }

    public void setImg_rest(int img_rest) {
        this.img_rest = img_rest;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getName_rest() {
        return name_rest;
    }

    public int getImg_rest() {
        return img_rest;
    }

    public int getStars() {
        return stars;
    }
}
