package com.example.demo;

import exam.ps.dbConn;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;



public class Utility {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://google/ap?cloudSqlInstance=fiery-nimbus-203407:europe-west1:myinstance&socketFactory=com.google.cloud.sql.mysql.SocketFactory&user=root&password=yzt42rmt&useSSL=false";
    static Connection con;


    public static void main(String [] args) throws SQLException, ClassNotFoundException {
        try {
            loadUserList();
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
            stmt.setString(4,((Student) user).getCity());
            stmt.setString(5,user.getPhoneNr());
            stmt.setString(6,((Student) user).getEducation());
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
            stmt.setString(6,((Mentor) user).getCity());
            stmt.setString(1,user.getPhoneNr());
            stmt.setString(7,((Mentor) user).getEducation());
            stmt.setString(5,user.getLastName());
            stmt.setString(8,((Mentor) user).getExperience());
            stmt.setString(9,((Mentor) user).getSubject());
            stmt.executeUpdate();
        }

    }



    public static void deleteUser(String inputEmail) throws SQLException {
        con = dbConn.getInstance().createConnection();
        PreparedStatement stmtStudent=con.prepareStatement("DELETE FROM Students WHERE email = (?)");
        stmtStudent.setString(1,inputEmail);
        stmtStudent.executeUpdate();
        PreparedStatement stmtMentor=con.prepareStatement("DELETE FROM Mentors WHERE email = (?)");
        stmtMentor.setString(1,inputEmail);
        stmtMentor.executeUpdate();
        PreparedStatement stmtUser = con.prepareStatement("DELETE FROM Users WHERE email = (?)");
        stmtUser.setString(1,inputEmail);
        stmtUser.executeUpdate();
    }

    public static User loadEditUser(String email) throws SQLException {
        con = dbConn.getInstance().createConnection();
        ResultSet rs;
        //Statement s = con.createStatement();
        String selectSQL = "SELECT type FROM Users WHERE email = (?)";
        PreparedStatement stmt=con.prepareStatement(selectSQL);
        stmt.setString(1,email);
        rs = stmt.executeQuery();
        rs.next();
        //System.out.print(rs.getString(1));
        if(rs.getString(1).toLowerCase().equals("student")) {
            PreparedStatement stmtStudent=con.prepareStatement("SELECT * FROM Students WHERE email = (?)");
            stmtStudent.setString(1,email);
            ResultSet rs2 = stmtStudent.executeQuery();
            rs2.next();
                Student k = new Student(rs2.getString("password"),rs2.getString("email"), rs2.getString("telefon"), rs2.getString("fornavn"), rs2.getString("efternavn"), rs2.getString("Students.by"), rs2.getString("Students.uddannelse"));
                //System.out.print(k.getFirstName() + k.getLastName()+ k.getEmail() + k.getPassword() + k.getCity() + k.getEducation()+ k.getPhoneNr());
                return k;
        }
        if(rs.getString(1).toLowerCase().equals("mentor")){
            PreparedStatement stmtStudent=con.prepareStatement("SELECT * FROM Mentors WHERE email = (?)");
            stmtStudent.setString(1,email);
            ResultSet rs2 = stmtStudent.executeQuery();
            rs2.next();
            Mentor m = new Mentor(rs2.getString(3),rs2.getString(2), rs2.getString(1), rs2.getString(4), rs2.getString(5), rs2.getString(6), rs2.getString(7), rs2.getString(8), rs2.getString(9));
            return m;
        }
        return null;
    }

    public static void editMentor(User user) throws SQLException {
        con = dbConn.getInstance().createConnection();
        PreparedStatement stmt = con.prepareStatement("UPDATE Users SET email = (?), fornavn = (?), efternavn = (?), password = (?), telefon = (?) WHERE email = (?)");
        stmt.setString(1,user.getEmail());
        stmt.setString(2,user.getFirstName());
        stmt.setString(3,user.getLastName());
        stmt.setString(4, user.getPassword());
        stmt.setString(5, user.getPhoneNr());
        stmt.setString(6,user.getEmail());
        stmt.executeUpdate();

        PreparedStatement stmtMentor = con.prepareStatement("UPDATE Mentors SET email = (?), password = (?), fornavn = (?), Mentors.by = (?), Mentors.telefon = (?), Mentors.education = (?), Mentors.efternavn = (?), Mentors.experience = (?), Mentors.subject = (?) WHERE email = (?)");
        stmtMentor.setString(1, user.getEmail());
        stmtMentor.setString(2, user.getPassword());
        stmtMentor.setString(3, user.getFirstName());
        stmtMentor.setString(4, ((Mentor) user).getCity());
        stmtMentor.setString(5, user.getPhoneNr());
        stmtMentor.setString(6, ((Mentor) user).getEducation());
        stmtMentor.setString(7, user.getLastName());
        stmtMentor.setString(8, ((Mentor) user).getExperience());
        stmtMentor.setString(9, ((Mentor) user).getSubject());
        stmtMentor.setString(10,user.getEmail());
        stmtMentor.executeUpdate();
    }

    public static void editStudent(User user) throws SQLException {
        con = dbConn.getInstance().createConnection();
        PreparedStatement stmt = con.prepareStatement("UPDATE Users SET email = (?), fornavn = (?), efternavn = (?), password = (?), telefon = (?) WHERE email = (?)");
        stmt.setString(1,user.getEmail());
        stmt.setString(2,user.getFirstName());
        stmt.setString(3,user.getLastName());
        stmt.setString(4, user.getPassword());
        stmt.setString(5, user.getPhoneNr());
        stmt.setString(6,user.getEmail());
        stmt.executeUpdate();
/*
        PreparedStatement test = con.prepareStatement("SELECT type FROM Users WHERE email = (?)");
        test.setString(1,user.getEmail());
        ResultSet rs = test.executeQuery();
        rs.next();
        if(rs.getString(1).toLowerCase().equals("student")) {*/
            PreparedStatement stmtStudent = con.prepareStatement("UPDATE Students SET email = (?), password = (?), fornavn = (?), Students.by = (?), Students.telefon = (?), Students.uddannelse = (?), efternavn = (?) WHERE email = (?)");
            stmtStudent.setString(1, user.getEmail());
            stmtStudent.setString(2, user.getPassword());
            stmtStudent.setString(3, user.getFirstName());
            stmtStudent.setString(4, ((Student) user).getCity());
            stmtStudent.setString(5, user.getPhoneNr());
            stmtStudent.setString(6, ((Student) user).getEducation());
            stmtStudent.setString(7, user.getLastName());
            stmtStudent.setString(8, user.getEmail());
            stmtStudent.executeUpdate();/*
        }
        if(rs.getString(1).toLowerCase().equals("mentor")) {
            PreparedStatement stmtMentor = con.prepareStatement("UPDATE Mentors SET email = (?), password = (?), fornavn = (?), by = (?), telefon = (?), education = (?), efternavn = (?), experience = (?), Mentors.subject = (?)WHERE email = (?)");
            stmtMentor.setString(1, user.getEmail());
            stmtMentor.setString(2, user.getPassword());
            stmtMentor.setString(3, user.getFirstName());
            stmtMentor.setString(4, ((Mentor) user).getCity());
            stmtMentor.setString(5, user.getPhoneNr());
            stmtMentor.setString(6, ((Mentor) user).getEducation());
            stmtMentor.setString(7, user.getLastName());
            stmtMentor.setString(8, ((Mentor) user).getExperience());
            stmtMentor.setString(9, ((Mentor) user).getSubject());
            stmtMentor.setString(10,user.getEmail());
            stmtMentor.executeUpdate();
        }*/
    }

    public static ArrayList<User> loadUserList() throws SQLException {
        ArrayList<User> uList = new ArrayList();
        con = dbConn.getInstance().createConnection();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT fornavn, efternavn, email, Users.Type, telefon FROM Users");
        while(rs.next()){
            uList.add(new User(rs.getString(3), rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(5)));
        }
        return uList;
    }
}



