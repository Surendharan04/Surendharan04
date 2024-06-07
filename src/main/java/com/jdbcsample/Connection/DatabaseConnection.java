package com.jdbcsample.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.jdbcsample.Controller.Constants;

public class DatabaseConnection {
    private static Connection conn;

    private DatabaseConnection(){};

    public static Connection getConnection(){
        try {
            Class.forName(Constants.DRIVER);
            if (conn == null) {
                conn = DriverManager.getConnection(Constants.URL, Constants.UNAME, Constants.PASS);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
    
}
