package com.ioprogramming.advancedproblmes.databasetocsv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.sql.*;

public class DatabaseToCSV {

    // Database connection details
    private static final String DB_URL = "jdbc:mysql:///mycompany";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Anubhav@0908@";

    public static void main(String[] args) {
        String csvFilePath = "src/main/java/com/ioprogramming/advancedproblmes/databasetocsv/employees.csv"; // Output CSV file

        // Fetch records from the database and write to CSV
        fetchAndWriteToCSV(csvFilePath);
    }

    public static void fetchAndWriteToCSV(String filePath) {
        String query = "SELECT id, name, department, salary FROM employees";

        try (
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Employee ID", "Name", "Department", "Salary"))
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                csvPrinter.printRecord(id, name, department, salary);
            }

            System.out.println("CSV report generated successfully: " + filePath);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
