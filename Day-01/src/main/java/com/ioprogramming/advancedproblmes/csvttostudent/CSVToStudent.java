package com.ioprogramming.advancedproblmes.csvttostudent;
import java.io.*;
import java.util.*;

public class CSVToStudent {
    public static void main(String[] args) {
        String filePath = "students1.csv";  // Ensure the CSV file exists in the project directory
        List<Student1> students = readCSV(filePath);

        // Print students
        for (Student1 student : students) {
            System.out.println(student);
        }
    }

    public static List<Student1> readCSV(String filePath) {
        List<Student1> studentList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header (if exists)

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Ensure data validity
                if (data.length == 3) {
                    String name = data[0].trim();
                    int age = Integer.parseInt(data[1].trim());
                    double grade = Double.parseDouble(data[2].trim());

                    studentList.add(new Student1(name, age, grade));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}

