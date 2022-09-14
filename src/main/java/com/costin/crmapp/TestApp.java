package com.costin.crmapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestApp {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
        String user = "costin";
        String pass = "costin";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection myConnection = DriverManager
                    .getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful...");
            myConnection.close();
            System.out.println("Connection closed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
