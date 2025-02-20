package com.ioprogramming.jsonhandling.handsonpractice.jsontoxml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper for JSON
            ObjectMapper jsonMapper = new ObjectMapper();

            // Read JSON file into a Java object (Map)
            Object jsonData = jsonMapper.readValue(new File("src\\main\\java\\com\\ioprogramming\\jsonhandling\\handsonpractice\\jsontoxml\\data.json"), Object.class);

            // Create XmlMapper for XML conversion
            XmlMapper xmlMapper = new XmlMapper();

            // Convert Java object to XML
            String xmlOutput = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonData);

            // Print XML output
            System.out.println("Converted XML:");
            System.out.println(xmlOutput);

            // Write XML to a file
            xmlMapper.writeValue(new File("src\\main\\java\\com\\ioprogramming\\jsonhandling\\handsonpractice\\jsontoxml\\data.xml"), jsonData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
