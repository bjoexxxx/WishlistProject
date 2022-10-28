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



    private String pstsGetAll = "SELECT * FROM wishlist";
    private String pstsAddUser = "INSERT INTO 'user' (first_name,last_name) VALUES (?,?)";
    private String pstsGetAllWishlists = "SELECT * FROM wishlist";
    private String pstsGetSpecificWishlist = "SELECT * FROM wish WHERE wishlistid=?";

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
                System.out.println(id + name + userid);

            }


        } catch (SQLException e) {
            System.out.println("Couldn't connect to db");
            e.printStackTrace();
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
        }
        return wishes;
    }

    public void createWishlist(Wishlist wishlist, int userId) {
        // TODO
    }

    public void createUser(User user) {
        //TODO
    }


    public int findUserIdByName(String userFirstName, String userLastName) {
        return 0; //TODO
    }
}
