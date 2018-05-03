package com.example.demo;

public class User {
    private String username;
    private String password;
    private String email;
    private int phoneNr;
    private String firstName;
    private String lastName;
    private String city;
    private String experience;
    private String education;

    //mentor and student constructor
    public User(String username, String password, String email, int phoneNr, String firstName, String lastName, String city, String experience, String education) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNr = phoneNr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.experience = experience;
        this.education = education;
    }

    //admin constructor
    public User(String username, String password, String email, int phoneNr) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNr = phoneNr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(int phoneNr) {
        this.phoneNr = phoneNr;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
