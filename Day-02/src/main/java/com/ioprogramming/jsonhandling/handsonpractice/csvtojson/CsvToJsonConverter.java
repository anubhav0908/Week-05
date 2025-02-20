package com.ioprogramming.jsonhandling.handsonpractice.csvtojson;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.util.List;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        try {
            File csvFile = new File("src\\main\\java\\com\\ioprogramming\\jsonhandling\\handsonpractice\\csvtojson\\data.csv");

            // Create CSV schema
            CsvSchema schema = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();

            // Read CSV data
            MappingIterator<Object> iterator = csvMapper
                    .readerFor(Object.class)
                    .with(schema)
                    .readValues(csvFile);
            List<Object> data = iterator.readAll();

            // Convert to JSON
            ObjectMapper jsonMapper = new ObjectMapper();
            String json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);

            // Print JSON
            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
