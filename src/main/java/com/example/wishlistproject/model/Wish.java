package com.example.wishlistproject.model;

public class Wish {

    private int id;
    private String name;
    private double price;
    private int wishlistID;

    public Wish(int id, String name, double price, int wishlistID) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.wishlistID = wishlistID;
    }

    public Wish() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", wishlistID=" + wishlistID +
                '}';
    }
}
