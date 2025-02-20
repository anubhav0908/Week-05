package com.ioprogramming.jsonhandling.practiceproblem.validatejson;

public class Student {
    private String name;
    private String email;
    private int age;

    // Default constructor (Required by Jackson)
    public Student() {}

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
