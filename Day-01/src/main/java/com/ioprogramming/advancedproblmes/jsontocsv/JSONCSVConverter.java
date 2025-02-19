package com.ioprogramming.advancedproblmes.jsontocsv;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.*;

public class JSONCSVConverter {

    public static void main(String[] args) throws IOException {
        // File paths
        String jsonFilePath = "src/main/java/com/ioprogramming/advancedproblmes/jsontocsv/student.json";
        String csvFilePath = "src/main/java/com/ioprogramming/advancedproblmes/jsontocsv/student.csv";
        String outputJsonFilePath = "src/main/java/com/ioprogramming/advancedproblmes/jsontocsv/outputjson.json";

        // Convert JSON to CSV
        jsonToCsv(jsonFilePath, csvFilePath);

        // Convert CSV back to JSON
        csvToJson(csvFilePath, outputJsonFilePath);
    }

    // Convert JSON to CSV
    public static void jsonToCsv(String jsonFilePath, String csvFilePath) throws IOException {
        // Read JSON file
        ObjectMapper objectMapper = new ObjectMapper();
        List<Student> students = objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<Student>>() {});

        // Write to CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath));
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("ID", "Name", "Age", "Marks"))) {

            for (Student student : students) {
                csvPrinter.printRecord(student.id, student.name, student.age, student.marks);
            }
            System.out.println("JSON to CSV conversion is successful.");
        }
    }

    // Convert CSV to JSON
    public static void csvToJson(String csvFilePath, String outputJsonFilePath) throws IOException {
        // Read CSV file
        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(reader);

        // Convert CSV data to Student objects
        List<Student> students = new ArrayList<>();
        for (CSVRecord record : records) {
            int id = Integer.parseInt(record.get("ID"));
            String name = record.get("Name");
            int age = Integer.parseInt(record.get("Age"));
            double marks = Double.parseDouble(record.get("Marks"));
            students.add(new Student(id, name, age, marks));  // Correct constructor with 4 parameters
        }

        // Write to JSON file
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(outputJsonFilePath), students);
        System.out.println("CSV to JSON conversion is successful.");
    }
}
