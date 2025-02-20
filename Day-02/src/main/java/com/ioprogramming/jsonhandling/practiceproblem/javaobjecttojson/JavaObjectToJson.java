package com.ioprogramming.jsonhandling.practiceproblem.javaobjecttojson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaObjectToJson {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Car car = new Car("MD123K", "Convertival");
            String value = mapper.writeValueAsString(car);

            System.out.println(value);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
