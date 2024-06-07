package com.jdbcsample;

import java.sql.ResultSet;
import java.util.logging.Level;

import com.jdbcsample.Controller.Constants;
import com.jdbcsample.Controller.DatabaseOperations;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseOperations.createTable();
            DatabaseOperations.convertDataTable(Constants.FILE_PATH);

            // Retrieve and display data from the database
            ResultSet rs = DatabaseOperations.getDBData(Constants.SELECT_QUERY);

            while (rs.next()) {
                String name = rs.getString("Name");
                int mark = rs.getInt("Mark");
                Constants.MAIN_LOGGER.log(Level.INFO, "Name: {0} | Marks: {1}/100", new Object[] { name, mark });
            }
            rs.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
