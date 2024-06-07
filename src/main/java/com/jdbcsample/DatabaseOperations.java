package com.jdbcsample;

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

public class DatabaseOperations {

    private static Connection con;
    private static PreparedStatement pst;
    
    private static String query = "INSERT INTO Student(Name, Mark) VALUES(?, ?)";
    
    public static void convertDataTable(String path) throws IOException, SQLException{
        FileInputStream fis = new FileInputStream(path);
        try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();

            while(itr.hasNext()){
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
                            intValue = (int)cell.getNumericCellValue();
                            break;

                        default:
                            System.out.print("Unknown");
                            break;
                    }
                }
                dataAction(query, strValue, intValue);
            }
        }
        System.out.println("Records inserted");
    }


    public static void dataAction(String query, String strValue, int intValue) throws SQLException {
        con = DatabaseConnection.getConnection();
        pst = con.prepareStatement(query);
        pst.setString(1, strValue);
        pst.setInt(2, intValue);
        pst.executeUpdate();
    }


    public static void getDBData(String query) throws SQLException{
        con = DatabaseConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            System.out.print("Name: " + rs.getString(2) + " | ");
            System.out.println("Marks: " + rs.getInt(3) + "/100");
            System.out.println();
        }
        st.close();
        rs.close();
    }
}
