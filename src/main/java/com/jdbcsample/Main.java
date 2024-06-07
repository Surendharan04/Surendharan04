package com.jdbcsample;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        String filePath = "JAVA\\dataconversion\\src\\main\\resources\\StudentMarks.xlsx";
        String query = "SELECT * FROM Student";

        DatabaseOperations.convertDataTable(filePath);
        System.out.println();

        DatabaseOperations.getDBData(query);
    }
}

//NOTE: Create a database called 'jdbcsample'
// In the student's table the records will be inserted
// The excel file is attached with the project