package com.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";
        String csvFile = "/path/to/csv/file.csv";
        String tableName = "mytable";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            // Create table
            String createTableSQL = "CREATE TABLE " + tableName + " (id INT PRIMARY KEY, name VARCHAR(50))";
            PreparedStatement createTableStmt = conn.prepareStatement(createTableSQL);
            createTableStmt.executeUpdate();

            // Insert data from CSV file
            String line;
            String insertSQL = "INSERT INTO " + tableName + " (id, name) VALUES (?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                insertStmt.setInt(1, id);
                insertStmt.setString(2, name);
                insertStmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
