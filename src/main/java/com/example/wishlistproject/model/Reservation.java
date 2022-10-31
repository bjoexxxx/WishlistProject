package com.example.wishlistproject.model;

public class Reservation {

    int wishid;
    boolean isReserved;

    public Reservation(int wishid, boolean isReserved) {
        this.wishid = wishid;
        this.isReserved = isReserved;
    }

    public Reservation() {
    }

    public int getWishid() {
        return wishid;
    }

    public void setWishid(int wishid) {
        this.wishid = wishid;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "wishid=" + wishid +
                ", isReserved=" + isReserved +
                '}';
    }
}
