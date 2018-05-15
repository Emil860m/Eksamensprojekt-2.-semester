package com.example.demo;

public class Mentor extends User {
    private String city;
    private String experience;
    private String education;
    private String subject;

    public Mentor() {
        }

    public Mentor(String password, String email, String phoneNr, String firstName, String lastName, String city, String experience, String education, String city1, String experience1, String education1, String subject) {
        super(password, email, phoneNr, firstName, lastName, city, experience, education);
        this.city = city1;
        this.experience = experience1;
        this.education = education1;
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

                                    /* Vi kan evt anvende et field "Fag" hvis vi får problemer med 1. normalform
                                    (1 værdi i hvert felt. Eks - Fag: Mat, Erfaring: 10år, Uddannelse: Ingeniør) */