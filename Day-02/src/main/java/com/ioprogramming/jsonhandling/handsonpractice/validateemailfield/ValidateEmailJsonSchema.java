package com.ioprogramming.jsonhandling.handsonpractice.validateemailfield;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.*;

import java.io.File;
import java.util.Set;

public class ValidateEmailJsonSchema {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Load JSON Schema as JsonNode
            JsonNode schemaNode = objectMapper.readTree(new File("src\\main\\java\\com\\ioprogramming\\jsonhandling\\handsonpractice\\validateemailfield\\EmailSchema.json"));

            // Create JSON Schema Factory with draft-07 support
            JsonSchemaFactory schemaFactory = JsonSchemaFactory
                    .builder(JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7))
                    .build();

            JsonSchema schema = schemaFactory.getSchema(schemaNode);

            // Read JSON input
            JsonNode jsonData = objectMapper.readTree(new File("src\\main\\java\\com\\ioprogramming\\jsonhandling\\handsonpractice\\validateemailfield\\email.json"));

            // Validate JSON against Schema
            Set<ValidationMessage> errors = schema.validate(jsonData);

            // Print validation result
            if (errors.isEmpty()) {
                System.out.println("JSON is valid!");
            } else {
                System.out.println("JSON Validation Errors:");
                errors.forEach(error -> System.out.println(error.getMessage()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
