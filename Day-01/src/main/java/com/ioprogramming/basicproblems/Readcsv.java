package com.ioprogramming.basicproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Readcsv {
    public static void main(String[] args) {
        String filePath = "sample.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String header = br.readLine();
           // System.out.println("CSV Header: " + header);

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("ID: " + data[0] + ", Name: " + data[1] +
                        ", Age: " + data[2] + ", Marks: " + data[3]);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
