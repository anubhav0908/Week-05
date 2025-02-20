package com.ioprogramming.jsonhandling.practiceproblem.validatejson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import java.io.File;

public class ValidateJsonExample {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            File file = new File("src/main/java/com/ioprogramming/jsonhandling/practiceproblem/validatejson/student.json");
            Student student = objectMapper.readValue(file, Student.class);

            // If valid, print confirmation
            System.out.println("JSON is valid and mapped to Student class: " + student.getName());
        } catch (MismatchedInputException e) {
            System.out.println(" Invalid JSON structure: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
