package com.example.wishlistproject.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

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



    private String pstsGetAll = "SELECT * FROM wish";
    private String pstsAddUser = "INSERT INTO 'user' (first_name,last_name) VALUES (?,?)";

    public List<Object> getAll() {


        List<Object> list = new LinkedList<>();
        try {
            Connection conn = DriverManager.getConnection(db_url, uid, pas);
            PreparedStatement psts = conn.prepareStatement(pstsGetAll);
            ResultSet resultSet = psts.executeQuery();
            while (resultSet.next()) {
                list.add(new Object());

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return list;

    }


    public Object getAllWishlists() {
        return null; //todo
    }

    public Object findWishesById(int wishlistId) {
        return null; //todo
    }
}
