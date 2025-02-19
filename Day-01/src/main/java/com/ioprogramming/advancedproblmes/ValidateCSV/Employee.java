package com.ioprogramming.advancedproblmes.ValidateCSV;


import java.util.regex.Pattern;

class Employee {
    String name, email, phone;
    public Employee(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public boolean isValidEmail() {
        String emailRegex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        return Pattern.matches(emailRegex, email);
    }

    public boolean isValidPhone() {
        String phoneRegex = "^\\d{10}$";
        return Pattern.matches(phoneRegex, phone);
    }
}
