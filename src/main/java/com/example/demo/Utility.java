package com.example.demo;

import exam.ps.dbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Utility {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://google/ap?cloudSqlInstance=fiery-nimbus-203407:europe-west1:myinstance&socketFactory=com.google.cloud.sql.mysql.SocketFactory&user=root&password=yzt42rmt&useSSL=false";
    static Connection con;


    public static void main(String [] args) throws SQLException, ClassNotFoundException {
        try {
            connectDatabase();
            String i = login("admin@email.com", "12345");
            System.out.print(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void connectDatabase() throws SQLException, ClassNotFoundException {

        //Opretter forbindelse gennem klassen dbConn.
        con = dbConn.getInstance().createConnection();
        Statement s = null;

        //Opretter et statement
        s = con.createStatement();

        //Opretter et resultset med de statements vi skal bruge
        ResultSet rs = s.executeQuery("SELECT email, password FROM ap.Users");
        //Printer resultsettet ud
        while(rs.next()) {
            System.out.println(rs.getString(1)+ rs.getString(2));
        }
    }





    private static String login(String username, String password) throws SQLException {
        con = dbConn.getInstance().createConnection();
        Statement s = null;
        s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT email, password FROM ap.Users");

        //System.out.println(rs.getString(1));
        while(rs.next()){
            System.out.println(rs.getString("email") + " " + rs.getString("password"));
            if(username.toLowerCase().equals(rs.getString("email").toLowerCase()) && password.toLowerCase().equals(rs.getString("password").toLowerCase())){
                return rs.getString("email").toLowerCase();
            }
        }
        return "1";
    }



    public static void saveUser(User user) throws SQLException {
        con = dbConn.getInstance().createConnection();
        Statement s = null;
        s = con.createStatement();
        if (user instanceof Student) {
            s.executeQuery("INSERT INTO Students VALUES (user.getEmail(), user.getPassword, user.getFirstName(), user.getCity(), user.getPhoneNr(), user.getEducation(), user.getLastName())");
            s.executeQuery("INSERT INTO Users VALUES (user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword, user.getPhoneNr(),Student)");
        }
        if (user instanceof Mentor) {
            s.executeQuery("");
            s.executeQuery("INSERT INTO Users VALUES (user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword, user.getPhoneNr(),Mentor)");
        }

    }


}
