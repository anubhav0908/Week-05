package com.ioprogramming.advancedproblmes.readlargecsv;

import java.io.*;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "ss.csv";
        int batchSize = 100;
        int recordCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                recordCount++;
                if (recordCount % batchSize == 0) {
                    System.out.println("Processed " + recordCount + " records...");
                }
            }

            // Final count after completion
            System.out.println("Finished processing. Total records: " + recordCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
