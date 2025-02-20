package com.ioprogramming.jsonhandling.handsonpractice.readjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class PrintJsonKeysValues {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file into JsonNode
            JsonNode rootNode = objectMapper.readTree(new File("src\\main\\java\\com\\ioprogramming\\jsonhandling\\handsonpractice\\readjson\\student.json"));

            // Recursively print all keys and values
            printJson(rootNode, "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printJson(JsonNode node, String parentKey) {
        if (node.isObject()) {
            // Iterate over object fields
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                printJson(field.getValue(), parentKey + field.getKey() + ".");
            }
        } else if (node.isArray()) {
            // Iterate over array elements
            int index = 0;
            for (JsonNode arrayElement : node) {
                printJson(arrayElement, parentKey + "[" + index + "].");
                index++;
            }
        } else {
            // Print key-value pair
            System.out.println(parentKey.substring(0, parentKey.length() - 1) + " : " + node.asText());
        }
    }
}
