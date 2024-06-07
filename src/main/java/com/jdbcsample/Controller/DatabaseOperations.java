package com.jdbcsample.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jdbcsample.Connection.DatabaseConnection;

public class DatabaseOperations {

    private static Connection con;
    private static PreparedStatement pst;

    public static void convertDataTable(String path) throws IOException, SQLException {
        FileInputStream fis = new FileInputStream(path);
        try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            //The heading - Skipped
            if (itr.hasNext()) {
                itr.next();
            }

            while (itr.hasNext()) {
                String strValue = "";
                int intValue = 0;

                Row row = itr.next();
                Iterator<Cell> citr = row.iterator();
                while (citr.hasNext()) {
                    Cell cell = citr.next();
                    switch (cell.getCellType()) {
                        case STRING:
                            strValue = cell.getStringCellValue();
                            break;

                        case NUMERIC:
                            intValue = (int) cell.getNumericCellValue();
                            break;

                        default:
                            System.out.print("Unknown");
                            break;
                    }
                }
                dataAction(Constants.INSERT_QUERY, strValue, intValue);
            }
        }
        System.out.println("Records inserted");
    }


    public static void createTable() throws SQLException {
        dataAction(Constants.CREATE_TABLE_QUERY, null, 0);
    }


    public static void dataAction(String query, String strValue, int intValue) throws SQLException {
        con = DatabaseConnection.getConnection();
        pst = con.prepareStatement(query);
        if (strValue != null) {
            pst.setString(1, strValue);
        }
        // else{
        //     pst.setString(1, "");
        // }
        if (intValue != 0) {
            pst.setInt(2, intValue);
        }
        // else{
        //     pst.setInt(2, 0);
        // }
        pst.executeUpdate();
    }


    public static ResultSet getDBData(String query) throws SQLException {
        con = DatabaseConnection.getConnection();
        Statement st = con.createStatement();
        return st.executeQuery(query);
    }
}