package com.jdbcsample;

import java.sql.ResultSet;

import com.jdbcsample.Controller.Constants;
import com.jdbcsample.Controller.DatabaseOperations;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseOperations.createTable();
            DatabaseOperations.convertDataTable(Constants.FILE_PATH);
            System.out.println();

            // Retrieve and display data from the database
            ResultSet rs = DatabaseOperations.getDBData(Constants.SELECT_QUERY);

            while (rs.next()) {
                System.out.print("Name: " + rs.getString("Name") + " | ");
                System.out.println("Marks: " + rs.getInt("Marks") + "/100");
                System.out.println();
            }
            rs.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
