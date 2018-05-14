package com.example.demo;

import exam.ps.dbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utility {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://google/ap?cloudSqlInstance=fiery-nimbus-203407:europe-west1:myinstance&socketFactory=com.google.cloud.sql.mysql.SocketFactory&user=root&password=yzt42rmt&useSSL=false";
    static Connection con;


    public static void main(String [] args) throws SQLException, ClassNotFoundException {
        try {
            connectDatabase();
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
        ResultSet rs = s.executeQuery("SELECT email FROM ap.Users");
        //Printer resultsettet ud
        while(rs.next()) {
            System.out.println(rs.getString(1));
        }
      

    }



    //metoden går ud fra at der er en arraylist der hedder users, med alle brugerne i.
    //metoden skal rettes til så den tilgår databasen og skal derefter returnere selve objektet
    /*
    private static User login(String username, String password) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername())== username.toLowerCase() && users.get(i).getPassword()==password.toLowerCase()) {
                return users.get(i);
            }
        }

    }

*/


}
