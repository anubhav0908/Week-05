package com.ioprogramming.jsonhandling.practiceproblem.listtojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class ConvertListToJson {
    public static void main(String[] args) {
        try {
            // Create a list of Employee objects
            List<Employee> employees = new ArrayList<>();
            employees.add(new Employee(101, "John Doe", "john.doe@techcorp.com", "Engineering"));
            employees.add(new Employee(102, "Alice Smith", "alice.smith@techcorp.com", "Marketing"));
            employees.add(new Employee(103, "Bob Johnson", "bob.johnson@techcorp.com", "Sales"));

            // Convert list to JSON array
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees);

            // Print JSON array
            System.out.println("JSON Array:\n" + jsonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
