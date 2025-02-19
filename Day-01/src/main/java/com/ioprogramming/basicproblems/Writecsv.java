package com.ioprogramming.basicproblems;

import java.io.FileWriter;
import java.io.IOException;

public class Writecsv {
    public static void main(String[] args) {
        String filePath = "sample.csv";
        String[] employees = {
                "ID,Name,Department,Salary",
                "1,Alice,HR,50000",
                "2,Bob,IT,60000",
                "3,Charlie,Finance,70000",
                "4,David,Marketing,55000",
                "5,Eve,Engineering,80000"
        };

        // Write to CSV file
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String emp : employees) {
                writer.write(emp + "\n");
            }
            System.out.println("CSV file written successfully!");
        } catch (IOException e) {
            System.out.println("Error writing the file: " + e.getMessage());
        }
    }
}
