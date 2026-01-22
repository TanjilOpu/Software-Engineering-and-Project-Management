package com.mycompany.registration.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() {
        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Change 'your_password' to your actual MySQL root password
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/registration_db", "root", "tanjilsql");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}