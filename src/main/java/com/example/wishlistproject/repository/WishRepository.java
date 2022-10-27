package com.example.wishlistproject.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


@Repository
public class WishRepository {


    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String uid;

    @Value("${spring.datasource.password}")
    private String pas;

    public List<Object> getAll() {


        List<Object> list = new LinkedList<>();
        try {
            Connection conn = DriverManager.getConnection(db_url, uid, pas);
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM wish");
            ResultSet resultSet = psts.executeQuery();
            while (resultSet.next()) {
                list.add(new Object());

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return list;

    }


}
