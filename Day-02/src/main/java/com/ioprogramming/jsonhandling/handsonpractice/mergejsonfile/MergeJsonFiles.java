package com.ioprogramming.jsonhandling.handsonpractice.mergejsonfile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class MergeJsonFiles {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON files as JsonNode
            JsonNode json1 = objectMapper.readTree(new File("src\\main\\java\\com\\ioprogramming\\jsonhandling\\handsonpractice\\mergejsonfile\\file1.json"));
            JsonNode json2 = objectMapper.readTree(new File("src\\main\\java\\com\\ioprogramming\\jsonhandling\\handsonpractice\\mergejsonfile\\file2.json"));

            // Merge both JSON objects
            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) json1);
            mergedJson.setAll((ObjectNode) json2);

            // Print merged JSON
            System.out.println("Merged JSON:");
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));

            // Write merged JSON to a new file
            objectMapper.writeValue(new File("merged.json"), mergedJson);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
