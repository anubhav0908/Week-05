package com.ioprogramming.jsonhandling.handsonpractice.jsonfromdatabase;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;
import java.util.*;
import java.io.File;

public class DatabaseToJsonReport {
    public static void main(String[] args) {
        String url = "jdbc:mysql:///employees";
        String user = "root";
        String password ="Anubhav@0908@";



        List<Map<String, Object>> employees = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {

            // Process result set
            while (rs.next()) {
                Map<String, Object> record = new HashMap<>();
                record.put("id", rs.getInt("id"));
                record.put("name", rs.getString("name"));
                record.put("age", rs.getInt("age"));
                record.put("department", rs.getString("department"));
                record.put("email", rs.getString("email"));
                employees.add(record);
            }

            // Convert List to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees);

            // Write JSON to a file
            objectMapper.writeValue(new File("employees_report.json"), employees);

            // Print JSON
            System.out.println(jsonOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
