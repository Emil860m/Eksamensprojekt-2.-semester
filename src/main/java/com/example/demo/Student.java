package com.example.demo;

public class Student extends User {
    protected String city;                     // Slettet fornavn og efternavn da jeg tænker vi bare nedarver dem fra User
    protected String education;

    public Student() {}

    public Student(String password, String email, String phoneNr, String firstName, String lastName, String city, String education) {
        super(password, email, phoneNr, firstName, lastName, city, education, "Student");
        this.city = city;
        this.education = education;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }
}



