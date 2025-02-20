package com.ioprogramming.jsonhandling.practiceproblem.readjsonfile;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ReadJSONFile {
    public static void main(String[] args) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            Student stu = mapper.readValue(new File("src/main/java/com/ioprogramming/jsonhandling/practiceproblem/readjsonfile/student.json"), Student.class);
            System.out.println("Student Name: " + stu.getName());
            System.out.println("Student email: " + stu.getEmail());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
