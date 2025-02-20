package com.ioprogramming.jsonhandling.practiceproblem.filterjsondata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilterJsonWithJsonNode {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("src\\main\\java\\com\\ioprogramming\\jsonhandling\\practiceproblem\\filterjsondata\\user.json"));

            // Create a list to store filtered users
            List<JsonNode> filteredUsers = new ArrayList<>();

            // Iterate through JSON array
            for (JsonNode user : rootNode) {
                if (user.get("age").asInt() > 25) {
                    filteredUsers.add(user);
                }
            }

            // Convert filtered list to JSON array and print
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredUsers);
            System.out.println("Filtered JSON (Users older than 25):\n" + jsonOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
