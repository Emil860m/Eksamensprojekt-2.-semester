package com.example.demo;

import exam.ps.dbConn;

import java.sql.*;
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
            PreparedStatement stmtUser=con.prepareStatement("insert into Users values(?,?,?,?,?,?)");
            stmtUser.setString(1,user.getEmail());//1 specifies the first parameter in the query
            stmtUser.setString(4,user.getPassword());
            stmtUser.setString(2,user.getFirstName());
            stmtUser.setString(5,user.getPhoneNr());
            stmtUser.setString(3,user.getLastName());
            stmtUser.setString(6,"Student");
            stmtUser.executeUpdate();
            PreparedStatement stmt=con.prepareStatement("insert into Students values(?,?,?,?,?,?,?)");
            stmt.setString(1,user.getEmail());//1 specifies the first parameter in the query
            stmt.setString(2,user.getPassword());
            stmt.setString(3,user.getFirstName());
            stmt.setString(4,user.getCity());
            stmt.setString(5,user.getPhoneNr());
            stmt.setString(6,user.getEducation());
            stmt.setString(7,user.getLastName());
            stmt.executeUpdate();
        }
        if (user instanceof Mentor) {
            PreparedStatement stmtUser=con.prepareStatement("insert into Users values(?,?,?,?,?,?)");
            stmtUser.setString(1,user.getEmail());//1 specifies the first parameter in the query
            stmtUser.setString(4,user.getPassword());
            stmtUser.setString(2,user.getFirstName());
            stmtUser.setString(5,user.getPhoneNr());
            stmtUser.setString(3,user.getLastName());
            stmtUser.setString(6,"Mentor");
            stmtUser.executeUpdate();
            PreparedStatement stmt=con.prepareStatement("insert into Mentors values(?,?,?,?,?,?,?,?,?)");
            stmt.setString(2,user.getEmail());//1 specifies the first parameter in the query
            stmt.setString(3,user.getPassword());
            stmt.setString(4,user.getFirstName());
            stmt.setString(6,user.getCity());
            stmt.setString(1,user.getPhoneNr());
            stmt.setString(7,user.getEducation());
            stmt.setString(5,user.getLastName());
            stmt.setString(8,((Mentor) user).getExperience());
            stmt.setString(9,((Mentor) user).getSubject());
            stmt.executeUpdate();
            //s.executeQuery("INSERT INTO Mentors VALUES (user.getPhoneNr(), user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName(),user.getCity(),user.getEducation(), user.getExperience(), user.getSubject())");
            //s.executeQuery("INSERT INTO Users VALUES (user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword, user.getPhoneNr(),Mentor)");
        }

    }


}



