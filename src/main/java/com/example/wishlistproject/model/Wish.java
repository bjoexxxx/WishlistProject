package com.example.wishlistproject.model;

public class Wish {

    private String wish_name;
    private double wish_price;

    public Wish(String wish_name, double wish_price) {
        this.wish_name = wish_name;
        this.wish_price = wish_price;
    }

    public Wish() {
    }

    public String getWish_name() {
        return wish_name;
    }

    public void setWish_name(String wish_name) {
        this.wish_name = wish_name;
    }

    public double getWish_price() {
        return wish_price;
    }

    public void setWish_price(double wish_price) {
        this.wish_price = wish_price;
    }

    @Override
    public String toString() {
        return "Wish{" +
                "wish_name='" + wish_name + '\'' +
                ", wish_price=" + wish_price +
                '}';
    }
}
