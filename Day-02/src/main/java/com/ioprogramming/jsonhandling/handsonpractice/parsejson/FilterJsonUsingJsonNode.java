package com.ioprogramming.jsonhandling.handsonpractice.parsejson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilterJsonUsingJsonNode {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootArray = objectMapper.readTree(new File("src/main/java/com/ioprogramming/jsonhandling/handsonpractice/parsejson/students.json"));

            List<JsonNode> filteredList = new ArrayList<>();
            for (JsonNode node : rootArray) {
                if (node.get("age").asInt() > 25) {
                    filteredList.add(node);
                }
            }

            String filteredJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredList);
            System.out.println("Filtered JSON:\n" + filteredJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
