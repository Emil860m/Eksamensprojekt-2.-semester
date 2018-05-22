package com.example.demo;

public class User {
    protected String email; // primary key
    protected String firstName;
    protected String lastName;
    protected String password;
    protected String phoneNr; // foreign key

    protected String type;


    public User(){
    }
    // contruktor der bliver brugt af LoadUserList  ()
    public User(String email, String firstName, String lastName, String type, String phoneNr) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.phoneNr = phoneNr;
    }
    //construktor der bliver brugt af loadEditUser()
    public User(String password, String email, String phoneNr, String firstName, String lastName, String city, String education, String type) {
        this.password = password;                   // Slettet username da vi bare bruger mail der
        this.email = email;                         // Tilføjet fornavn og efternavn her da de går igen i alle klasser
        this.phoneNr = phoneNr;
        this.firstName = firstName;
        this.lastName = lastName;                   // Og derfor bare kan nedarves
        this.type = type;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
