package com.example.wishlistproject.model;

public class Wishlist {

    private String name;
    private int userId;
    private int id;

    public Wishlist(String name, int id, int userId) {
        this.name = name;
        this.userId = userId;
        this.id = id;
    }

    public Wishlist() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "name='" + name + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
