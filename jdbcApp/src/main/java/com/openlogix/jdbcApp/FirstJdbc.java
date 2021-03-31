package com.openlogix.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class FirstJdbc 
{
    public static void main( String[] args )
    {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/olx_test";

        String username = "root";
        String password = "";
        
        Connection con = null;
        try{
            Class.forName(driver);
            System.out.println("Connection Established");
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            con = DriverManager.getConnection(url, username, password);
 
            // Get a result set containing all data from test_table
             
            Statement statement = con.createStatement();
             
            ResultSet results = statement.executeQuery("SELECT * FROM Users");
             
             
            // For each row of the result set ...
             
            while (results.next()) {
             
             
              // Get the data from the current row using the column index - column data are in the VARCHAR format
             
              String data = results.getString(1);
             
              System.out.println("Fetching data by column index for row " + results.getRow() + " : " + data);
             
             
              // Get the data from the current row using the column name - column data are in the VARCHAR format
             
              data = results.getString("First Name");
             
              System.out.println("Fetching data by column name for row " + results.getRow() + " : " + data);
             
             
        }
        }catch (SQLException e) {
                System.out.println("Could not retrieve data from the database " + e.getMessage()); 
        }

        try{
            System.out.println("Inserting record");
           Statement stmt = con.createStatement();
            String record1 = "INSERT INTO `users` (`First Name`, `Last name`, `SSN`, `DOB`, `Phone num`) VALUES ('Sathwik23','Tm', 40940924, '1897-07-14', '74230940392');";
            stmt.executeUpdate(record1);
            // stmt.executeUpdate(record1);
        
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}


