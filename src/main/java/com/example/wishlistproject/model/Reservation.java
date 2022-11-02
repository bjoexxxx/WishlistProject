package com.example.wishlistproject.model;

public class Reservation {

    int wishid;
    String userid;
    boolean isReserved;

    public Reservation(int wishid, String userid, boolean isReserved) {
        this.wishid = wishid;
        this.userid = userid;
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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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
                ", userid='" + userid + '\'' +
                ", isReserved=" + isReserved +
                '}';
    }
}
