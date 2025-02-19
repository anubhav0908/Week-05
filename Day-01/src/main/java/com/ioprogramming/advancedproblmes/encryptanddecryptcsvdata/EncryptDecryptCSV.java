package com.ioprogramming.advancedproblmes.encryptanddecryptcsvdata;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.Base64;
import java.util.List;
import java.util.ArrayList;

public class EncryptDecryptCSV {

    // AES encryption algorithm
    private static final String ALGORITHM = "AES";

    // Generate a new AES key
    private static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(128);  // 128-bit AES key
        return keyGenerator.generateKey();
    }

    // Encrypt data using AES
    private static String encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Decrypt data using AES
    private static String decrypt(String encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    // Write encrypted data to CSV file
    public static void writeEncryptedCSV(String filePath, List<String[]> data, SecretKey key) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write header
            writer.write("ID,Name,Department,Email,Phone,Salary");
            writer.newLine();

            // Encrypt and write each record
            for (String[] record : data) {
                String id = record[0];
                String name = record[1];
                String department = record[2];
                String email = encrypt(record[3], key);
                String phone = record[4];
                String salary = encrypt(record[5], key);

                writer.write(String.join(",", id, name, department, email, phone, salary));
                writer.newLine();
            }
        }
    }

    // Read and decrypt data from CSV file
    public static void readDecryptedCSV(String filePath, SecretKey key) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip header

            // Read and decrypt each record
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                String department = data[2];
                String email = decrypt(data[3], key);
                String phone = data[4];
                String salary = decrypt(data[5], key);

                System.out.println(String.join(",", id, name, department, email, phone, salary));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // Generate AES key
        SecretKey key = generateKey();

        // Sample data to write to CSV
        List<String[]> employeeData = new ArrayList<>();
        employeeData.add(new String[]{"101", "Prakash", "SDE", "prakashemail@example.com", "9876543210", "28700"});
        employeeData.add(new String[]{"102", "Deepansh", "IT", "deepansh@example.com", "9876543211", "22000"});
        employeeData.add(new String[]{"103", "Anubhav", "Sweeper", "anubhav@example.com", "1234567890", "30000"});

        // File path to save encrypted CSV
        String filePath = "encrypted_employee.csv";

        // Encrypt and write data to CSV
        writeEncryptedCSV(filePath, employeeData, key);

        // Read and decrypt data from the encrypted CSV
        System.out.println("\nDecrypted Data:");
        readDecryptedCSV(filePath, key);
    }
}
