package com.ioprogramming.advancedproblmes.ValidateCSV;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";  // Update with actual file path
        List<Employee> employees = new ArrayList<>();
        List<String> errors = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 3) {
                    errors.add("Invalid row format: " + line);
                    continue;
                }

                String name = data[0].trim();
                String email = data[1].trim();
                String phone = data[2].trim();

                Employee emp = new Employee(name, email, phone);

                if (!emp.isValidEmail()) {
                    errors.add("Invalid email format: " + email);
                }
                if (!emp.isValidPhone()) {
                    errors.add("Invalid phone number: " + phone);
                }

                employees.add(emp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print validation errors
        if (!errors.isEmpty()) {
            System.out.println("Validation Errors:");
            errors.forEach(System.out::println);
        } else {
            System.out.println("All records are valid.");
        }
    }
}
