package com.ioprogramming.intermediateproblems;

import java.io.*;
import java.util.*;

public class searchEmployee {
    public static void search(String filePath, String name) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[1].equalsIgnoreCase(name)) {
                    System.out.println("Department: " + values[3] + ", Salary: " + values[2]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String nameToSearch = scanner.nextLine();

        String filePath = "employees.csv";
        search(filePath, nameToSearch);
    }

}
