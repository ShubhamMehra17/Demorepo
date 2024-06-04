package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utility {

    private static String url = "jdbc:mysql://localhost:3306/BUSRESERVATIONSYSTEM";
    private static String username = "root";

    private static String password ="Shubham@143";

    public static Connection getConnection() throws SQLException {

       return DriverManager.getConnection(url, username, password);

    }
}
