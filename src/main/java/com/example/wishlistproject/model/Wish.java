package com.example.wishlistproject.model;

public class Wish {

    private String product_name;
    private double product_price;

    public Wish(String product_name, double product_price) {
        this.product_name = product_name;
        this.product_price = product_price;
    }

    public Wish() {
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    @Override
    public String toString() {
        return "Wish{" +
                "product_name='" + product_name + '\'' +
                ", product_price=" + product_price +
                '}';
    }
}
