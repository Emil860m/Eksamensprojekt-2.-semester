package com.example.demo;

public class User {
    private String username;
    private String password;
    private String email;
    private int phoneNr;


    public User(){
    }

    public User(String username, String password, String email, int phoneNr, String firstName, String lastName, String city, String experience, String education) {
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


}
