package com.ioprogramming.advancedproblmes.jsontocsv;

class Student {
    public int id;
    public String name;
    public int age;
    public double marks;

    // Default Constructor (Required by Jackson)
    public Student() {
    }

    // Parameterized Constructor
    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
}