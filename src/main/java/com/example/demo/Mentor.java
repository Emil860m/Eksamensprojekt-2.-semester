package com.example.demo;

public class Mentor extends User {
    private String city;
    private String experience;
    private String education;
    private String subject;

    public Mentor() {
        }

    public Mentor(String password, String email, String phoneNr, String firstName, String lastName, String city, String education, String experience, String subject) {
        super(password, email, phoneNr, firstName, lastName, city, education, "Mentor");
        this.city = city;
        this.experience = experience;
        this.education = education;
        this.subject = subject;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

