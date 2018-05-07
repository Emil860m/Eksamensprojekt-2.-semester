package com.example.demo;

public class User {
    private String email; // primary key
    private String firstName;
    private String lastName;
    private String password;
    private int phoneNr; // foreign key


    public User(){
    }

    public User(String password, String email, int phoneNr, String firstName, String lastName, String city, String experience, String education) {
        this.password = password;                   // Slettet username da vi bare bruger mail der
        this.email = email;                         // Tilføjet fornavn og efternavn her da de går igen i alle klasser
        this.phoneNr = phoneNr;                     // Og derfor bare kan nedarves
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

    public int getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(int phoneNr) {
        this.phoneNr = phoneNr;
    }


}
