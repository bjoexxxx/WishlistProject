package com.example.wishlistproject.model;

public class Wish {

    private int wishID;
    private String wish_name;
    private double wish_price;
    private int wishlistID;

    public Wish(int wishID, String wish_name, double wish_price, int wishlistID) {
        this.wishID = wishID;
        this.wish_name = wish_name;
        this.wish_price = wish_price;
        this.wishlistID = wishlistID;
    }

    public Wish() {
    }

    public int getWishID() {
        return wishID;
    }

    public void setWishID(int wishID) {
        this.wishID = wishID;
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

    public int getWishlistID() {
        return wishlistID;
    }

    public void setWishlistID(int wishlistID) {
        this.wishlistID = wishlistID;
    }

    @Override
    public String toString() {
        return "Wish{" +
                "wishID=" + wishID +
                ", wish_name='" + wish_name + '\'' +
                ", wish_price=" + wish_price +
                ", wishlistID=" + wishlistID +
                '}';
    }
}
