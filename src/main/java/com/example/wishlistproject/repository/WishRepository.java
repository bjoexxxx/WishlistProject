package com.example.wishlistproject.repository;

import com.example.wishlistproject.model.Wish;
import com.example.wishlistproject.model.Wishlist;
import com.example.wishlistproject.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;


@Repository
public class WishRepository {


    @Value("${JDBCUrl}")
    private String db_url;

    @Value("${JDBCUsername}")
    private String uid;

    @Value("${JDBCPassword}")
    private String pas;



    private String pstsGetAll = "SELECT * FROM wishlist;";
    private String pstsGetAllWishlists = "SELECT * FROM wishlist;";
    private String pstsGetSpecificWishlist = "SELECT * FROM wish WHERE wishlistid=?;";
    private String pstsCreateWishlist = "insert into `wishlist`(`name`,userid) VALUES(?,?);";
    private String pstsCreateUser = "insert into `user`(first_name,last_name) VALUES(?,?);";
    private String pstsFindUserIDByName = "select * from `user` where first_name=? and last_name=?;";

    private String pstsCreateWish = "INSERT INTO `wish` (`name`,`cost`,`wishlistid`) VALUES (?,?,?);";
    private String pstsUpdateWish = "UPDATE `wish` SET `name` = ?, cost = ? WHERE id = ?;";
    private String pstsSelectWish = "SELECT `name`,cost, wishlistid FROM wish WHERE id = ?;";

    private String pstsDeleteWishList = "DELETE FROM `wishlist` WHERE id=?;";

    private String pstsDeleteWish = "DELETE FROM `wish` WHERE id=?";


    private String pstsDeleteAllWishesFromWishList = "DELETE FROM `wish` WHERE wishlistid=?;";


    public List<Wishlist> getAllWishLists() {


        List<Wishlist> wishlists = new LinkedList<>();
        try {
            Connection conn = DriverManager.getConnection(db_url, uid, pas);
            PreparedStatement psts = conn.prepareStatement(pstsGetAll);
            ResultSet resultSet = psts.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int userid = resultSet.getInt(3);
                wishlists.add(new Wishlist(name, id, userid));
            }
        } catch (SQLException e) {
            System.out.println("Couldn't connect to db");
            e.printStackTrace();
        }
        return wishlists;
    }


    public Object selectWishlist(int wishlistId) {
        List<Wish> wishes = new LinkedList<>();
        try {
            Connection conn = DriverManager.getConnection(db_url,uid,pas);
            PreparedStatement psts = conn.prepareStatement(pstsGetSpecificWishlist);
            psts.setInt(1,wishlistId);
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double price = resultSet.getDouble( 3);
                int wishlistid = resultSet.getInt(4);
                wishes.add(new Wish(id,name,price,wishlistid));
                System.out.println(id+name+price+wishlistid);
            }

        } catch (SQLException e){
            System.out.println("Couldn't connect to db");
            e.printStackTrace();
        }
        return wishes;
    }

    public void createWishlist(Wishlist wishlist) {
        try {
            Connection conn = DriverManager.getConnection(db_url,uid,pas);
            PreparedStatement psts = conn.prepareStatement(pstsCreateWishlist);
            psts.setString(1,wishlist.getName());
            psts.setInt(2,wishlist.getUserId());
            psts.executeUpdate();


        } catch (SQLException e){
            System.out.println("Couldn't connect to db");
            e.printStackTrace();
        }
    }

    public void createUser(User user) {
        try {
            Connection conn = DriverManager.getConnection(db_url,uid,pas);
            PreparedStatement psts = conn.prepareStatement(pstsCreateUser);
            psts.setString(1,user.getFirst_name());
            psts.setString(2,user.getLast_name());
            psts.executeUpdate();
        } catch (SQLException e){
            System.out.println("Couldn't connect to db");
            e.printStackTrace();
        }

    }


    public int findUserIdByName(User user) {
        int userID = 0;
        try {
            Connection conn = DriverManager.getConnection(db_url,uid,pas);
            PreparedStatement psts = conn.prepareStatement(pstsFindUserIDByName);
            psts.setString(1,user.getFirst_name());
            psts.setString(2,user.getLast_name());
            ResultSet resultSet = psts.executeQuery();
            while(resultSet.next()) {
                userID = resultSet.getInt(1);
            }

        } catch (SQLException e){
            System.out.println("Couldn't connect to db");
            e.printStackTrace();
        }
        return userID;
    }

    public void createWish(Wish wish, int wishlistid){

        try {
            Connection conn = DriverManager.getConnection(db_url,uid,pas);
            PreparedStatement psts = conn.prepareStatement(pstsCreateWish);
            psts.setString(1,wish.getName());
            psts.setDouble(2,wish.getPrice());
            psts.setInt(3,wishlistid);
            psts.executeUpdate();
        } catch (SQLException e){
            System.out.println("Couldn't connect to db");
            e.printStackTrace();
        }

    }

    public void deleteWishList(int wishListId){
        // Vi fjerner først alle wishes fra wishlist, før vi kan slette den
        deleteAllWishesFromWishList(wishListId);

        try {
            Connection conn = DriverManager.getConnection(db_url,uid,pas);
            PreparedStatement psts = conn.prepareStatement(pstsDeleteWishList);
            psts.setInt(1, wishListId);
            psts.executeUpdate();
        } catch (SQLException e){
            System.out.println("Couldn't connect to db");
            e.printStackTrace();
        }

    }

    private void deleteAllWishesFromWishList(int wishListId){
        try {
            Connection conn = DriverManager.getConnection(db_url,uid,pas);
            PreparedStatement psts = conn.prepareStatement(pstsDeleteAllWishesFromWishList);
            psts.setInt(1, wishListId);
            psts.executeUpdate();
        } catch (SQLException e){
            System.out.println("Couldn't connect to db");
            e.printStackTrace();
        }

    }
    public void updateWish(Wish wish){
        try {
            Connection conn = DriverManager.getConnection(db_url,uid,pas);
            PreparedStatement psts = conn.prepareStatement(pstsUpdateWish);
            psts.setString(1,wish.getName());
            psts.setDouble(2,wish.getPrice());
            psts.setInt(3,wish.getWishID());
            psts.executeUpdate();
        } catch (SQLException e){
            System.out.println("Couldn't connect to db");
            e.printStackTrace();
        }

    }

    public Wish selectWish(int wishId){

        Wish newWish = new Wish();

            try {
                Connection conn = DriverManager.getConnection(db_url,uid,pas);
                PreparedStatement psts = conn.prepareStatement(pstsSelectWish);
                psts.setInt(1,wishId);
                ResultSet resultSet = psts.executeQuery();

                resultSet.next();
                    String name = resultSet.getString(1);
                    double price = resultSet.getDouble( 2);
                    int wishListId = resultSet.getInt(3);
                    newWish.setName(name);
                    newWish.setPrice(price);
                    newWish.setWishlistID(wishListId);

            } catch (SQLException e){
                System.out.println("Couldn't connect to db");
                e.printStackTrace();
            }
            return newWish;
        }

        private void findWishlistIdFromWish(Wish wish){



        }

    public void deleteWish(int wishId){
        // Vi fjerner først alle wishes fra wishlist, før vi kan slette den
        try {
            Connection conn = DriverManager.getConnection(db_url,uid,pas);
            PreparedStatement psts = conn.prepareStatement(pstsDeleteWish);
            psts.setInt(1, wishId);
            psts.executeUpdate();
        } catch (SQLException e){
            System.out.println("Couldn't connect to db");
            e.printStackTrace();
        }

    }

}
