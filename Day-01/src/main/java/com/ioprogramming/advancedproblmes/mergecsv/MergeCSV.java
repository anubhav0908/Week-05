package com.ioprogramming.advancedproblmes.mergecsv;

import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "student4.csv";  // First CSV file
        String file2 = "student5.csv";  // Second CSV file
        String outputFile = "student6.csv";  // Merged output file

        List<Student> students = mergeCSVFiles(file1, file2);

        // Write merged data to a new CSV file
        writeCSV(outputFile, students);
    }

    public static List<Student> mergeCSVFiles(String file1, String file2) {
        Map<Integer, Student> studentMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());

                studentMap.put(id, new Student(id, name, age, 0.0, ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                double marks = Double.parseDouble(data[1].trim());
                String grade = data[2].trim();

                if (studentMap.containsKey(id)) {
                    Student student = studentMap.get(id);
                    student.marks = marks;
                    student.grade = grade;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(studentMap.values());
    }

    public static void writeCSV(String fileName, List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            for (Student student : students) {
                bw.write(student.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

