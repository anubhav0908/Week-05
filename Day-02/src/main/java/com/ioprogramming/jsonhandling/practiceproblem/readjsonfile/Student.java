package com.ioprogramming.jsonhandling.practiceproblem.readjsonfile;

public class Student {
    public String name;
    public String email;

    public Student() {
    }

    Student(String name , String email){
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
