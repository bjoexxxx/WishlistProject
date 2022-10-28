package com.example.wishlistproject.model;

public class Wishlist {

    private String wishlist_name;
    private int wishlist_userId;

    public Wishlist(String wishlist_name, int wishlist_userId) {
        this.wishlist_name = wishlist_name;
        this.wishlist_userId = wishlist_userId;
    }

    public Wishlist() {
    }

    public String getWishlist_name() {
        return wishlist_name;
    }

    public void setWishlist_name(String wishlist_name) {
        this.wishlist_name = wishlist_name;
    }

    public int getWishlist_userId() {
        return wishlist_userId;
    }

    public void setWishlist_userId(int wishlist_userId) {
        this.wishlist_userId = wishlist_userId;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "wishlist_name='" + wishlist_name + '\'' +
                ", wishlist_userId=" + wishlist_userId +
                '}';
    }
}
