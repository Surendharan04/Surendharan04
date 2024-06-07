package com.jdbcsample.Controller;

public class Constants {
    //Query:
    public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS StudentMark (Name VARCHAR(255), Marks INT)";
    public static final String INSERT_QUERY = "INSERT INTO Studentmark (Name, Marks) VALUES (?, ?)";
    public static final String SELECT_QUERY = "SELECT * FROM Studentmark";

    //File Path:
    public static final String FILE_PATH = "JAVA\\dataconversion\\src\\main\\resources\\StudentMarks.xlsx";

    //Database Connection:
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/jdbcsample";
    public static final String UNAME = "root";
    public static final String PASS = "root";
}
