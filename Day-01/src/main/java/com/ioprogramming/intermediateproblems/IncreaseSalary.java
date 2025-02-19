package com.ioprogramming.intermediateproblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IncreaseSalary {

    public static void increaseSalary() {
        String inputFilePath = "employee.csv";
        String outputFilePath = "updated_employee.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String dept = data[2];
                try {
                    if ("IT".equals(dept)) {
                        int slry = Integer.parseInt(data[3].trim());
                        System.out.println("Original Salary: " + slry);
                        slry = slry + (slry * 10) / 100;
                        System.out.println("Updated Salary: " + slry);

                        // Update salary in the data array
                        data[3] = String.valueOf(slry);  // Update salary value
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing salary: " + e.getMessage());
                }

                // Write the modified line to the new file
                bw.write(String.join(",", data));
                bw.newLine();  // Add a newline after each line
            }
        } catch (IOException e) {
            System.out.println("Error reading or writing the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        increaseSalary();
    }
}