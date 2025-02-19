package com.ioprogramming.intermediateproblems;

import java.io.*;
import java.util.*;

class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " - $" + salary;
    }
}

public class SortCSV {
    public static void main(String[] args) {
        String filePath = "employees2.csv"; // Change this to the actual file path
        List<Employee> employees = new ArrayList<>();

        // Read CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip the header row
                    continue;
                }
                String[] data = line.split(",");
                String name = data[0].trim();
                double salary = Double.parseDouble(data[2].trim());
                employees.add(new Employee(name, salary));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort employees by salary in descending order
        employees.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));
        // Print top 5 highest-paid employees
        System.out.println("Top 5 Highest-Paid Employees:");
        employees.stream().limit(5).forEach(System.out::println);
    }
}
