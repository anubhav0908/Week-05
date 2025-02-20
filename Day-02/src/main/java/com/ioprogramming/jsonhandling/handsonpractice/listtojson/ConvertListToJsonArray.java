package com.ioprogramming.jsonhandling.handsonpractice.listtojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class ConvertListToJsonArray {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Create list of Student objects
            List<Student> students = new ArrayList<>();
            students.add(new Student("John Doe", "john.doe@example.com", 25));
            students.add(new Student("Alice Smith", "alice.smith@example.com", 23));

            // Convert list to JSON array
            String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);

            // Print JSON array
            System.out.println("JSON Array:\n" + jsonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
