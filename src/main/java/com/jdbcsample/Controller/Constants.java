package com.jdbcsample.Controller;

import java.util.logging.Logger;

import com.sun.tools.javac.Main;

public class Constants {
    //Query:
    public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS StudentMark (Name VARCHAR(255), Mark INT)";
    public static final String INSERT_QUERY = "INSERT INTO StudentMark (Name, Mark) VALUES (?, ?)";
    public static final String SELECT_QUERY = "SELECT * FROM StudentMark";

    //File Path:
    public static final String FILE_PATH = "JAVA\\dataconversion\\src\\main\\resources\\StudentMarks.xlsx";

    //Database Connection:
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/jdbcsample";
    public static final String UNAME = "root";
    public static final String PASS = "root";

    //Logger:
    public static final Logger MAIN_LOGGER = Logger.getLogger(Main.class.getName());
    public static final Logger DB_LOGGER = Logger.getLogger(DatabaseOperations.class.getName());
}
