package com.example.wishlistproject.model;

public class Wishlist {

    private String wishlist_name;
    private int wishlist_userId;
    private int wishlistId;

    public Wishlist(String wishlist_name, int wishlistId, int wishlist_userId) {
        this.wishlist_name = wishlist_name;
        this.wishlist_userId = wishlist_userId;
        this.wishlistId = wishlistId;
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

    public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "wishlist_name='" + wishlist_name + '\'' +
                ", wishlist_userId=" + wishlist_userId +
                ", wishlistId=" + wishlistId +
                '}';
    }
}
