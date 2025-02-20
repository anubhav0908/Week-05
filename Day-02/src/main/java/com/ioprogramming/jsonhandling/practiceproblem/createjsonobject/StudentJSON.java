package com.ioprogramming.jsonhandling.practiceproblem.createjsonobject;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJSON {
    public static void main(String[] args) {
        // Creating a JSON object
        JSONObject student = new JSONObject();
        student.put("name", "John Doe");
        student.put("age", 20);

        // Creating a JSON array for subjects
        JSONArray subjects = new JSONArray();
        subjects.put("Mathematics");
        subjects.put("Computer Science");
        subjects.put("Physics");

        // Adding subjects array to student object
        student.put("subjects", subjects);

        // Printing JSON
        System.out.println(student.toString(4));
    }
}
