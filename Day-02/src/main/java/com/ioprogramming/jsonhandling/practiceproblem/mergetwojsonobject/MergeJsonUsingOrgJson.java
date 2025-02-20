package com.ioprogramming.jsonhandling.practiceproblem.mergetwojsonobject;

import org.json.JSONObject;

public class MergeJsonUsingOrgJson {
    public static void main(String[] args) {
        // JSON Strings
        String json1 = "{ \"name\": \"John\", \"email\": \"john.doe@example.com\" }";
        String json2 = "{ \"age\": 25, \"city\": \"New York\" }";

        // Convert to JSONObject
        JSONObject obj1 = new JSONObject(json1);
        JSONObject obj2 = new JSONObject(json2);

        // Merge
        for (String key : obj2.keySet()) {
            obj1.put(key, obj2.get(key));
        }

        // Print merged JSON
        System.out.println("Merged JSON: \n" + obj1.toString(4)); // Pretty print with indentation
    }
}
