package com.example.demo;

public class Student extends User {
    private String city;                     // Slettet fornavn og efternavn da jeg tænker vi bare nedarver dem fra User
    private String education;

    public Student(String password, String email, int phoneNr, String firstName, String lastName, String city, String experience, String education, String city1, String education1) {
        super(password, email, phoneNr, firstName, lastName, city, experience, education);
        this.city = city1;
        this.education = education1;
    }
}



