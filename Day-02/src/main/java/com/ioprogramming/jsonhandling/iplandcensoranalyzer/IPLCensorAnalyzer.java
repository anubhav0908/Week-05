package com.ioprogramming.jsonhandling.iplandcensoranalyzer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        String jsonInputFile = "src\\main\\java\\com\\ioprogramming\\jsonhandling\\iplandcensoranalyzer\\IPLData.json";
        String csvInputFile = "src\\main\\java\\com\\ioprogramming\\jsonhandling\\iplandcensoranalyzer\\IPLData.csv";
        String jsonOutputFile = "src\\main\\java\\com\\ioprogramming\\jsonhandling\\iplandcensoranalyzer\\IPLDataCensored.json";
        String csvOutputFile = "src\\main\\java\\com\\ioprogramming\\jsonhandling\\iplandcensoranalyzer\\IPLDataCensored.csv";

        processJsonFile(jsonInputFile, jsonOutputFile);
        processCsvFile(csvInputFile, csvOutputFile);
    }

    // Process JSON file
    private static void processJsonFile(String inputFile, String outputFile) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(new File(inputFile));

            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    ((ObjectNode) node).put("team1", maskTeamName(node.get("team1").asText()));
                    ((ObjectNode) node).put("team2", maskTeamName(node.get("team2").asText()));
                    ((ObjectNode) node).put("winner", maskTeamName(node.get("winner").asText()));
                    ((ObjectNode) node).put("player_of_match", "REDACTED");
                }
            }
            mapper.writeValue(new File(outputFile), rootNode);
            System.out.println("Censored JSON data written to: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Process CSV file
    private static void processCsvFile(String inputFile, String outputFile) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFile));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile))) {

            List<String> lines = reader.lines().collect(Collectors.toList());
            writer.write(lines.get(0)); // Write header
            writer.newLine();

            for (int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                if (parts.length == 7) {
                    parts[1] = maskTeamName(parts[1]); // team1
                    parts[2] = maskTeamName(parts[2]); // team2
                    parts[5] = maskTeamName(parts[5]); // winner
                    parts[6] = "REDACTED"; // player_of_match
                }
                writer.write(String.join(",", parts));
                writer.newLine();
            }
            System.out.println("Censored CSV data written to: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Censorship function for team names
    private static String maskTeamName(String team) {
        if (team.contains(" ")) {
            return team.substring(0, team.indexOf(" ")) + " ***";
        }
        return team;
    }
}
