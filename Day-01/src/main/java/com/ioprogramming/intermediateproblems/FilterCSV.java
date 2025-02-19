package com.ioprogramming.intermediateproblems;

import java.io.*;
import java.util.*;

public class FilterCSV {
    public static void main(String[] args) {
        String csvFile = "students.csv";
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String header = br.readLine();
            if (header == null) {
                System.out.println("Empty file!");
                return;
            }
            System.out.println("Students who scored more than 80:");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                try {
                    String name = data[0];  // Assuming Name is in the first column
                    int marks = Integer.parseInt(data[1]); // Assuming Marks is in the second column
                    if (marks > 80) {
                        System.out.println(name + " - " + marks);
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Skipping invalid row: " + Arrays.toString(data));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
