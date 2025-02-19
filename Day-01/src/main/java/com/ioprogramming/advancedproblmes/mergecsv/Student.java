package com.ioprogramming.advancedproblmes.mergecsv;


public class Student {
    public int id;
    public String name;
    public int age;
    public double marks;
    String grade;

    public Student(int id, String name, int age, double marks, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}
