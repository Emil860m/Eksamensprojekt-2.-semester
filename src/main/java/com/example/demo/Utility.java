package com.example.demo;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utility {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://35.195.34.200:3306/ap";
    static Connection con;

    public static void connectDatabase()throws SQLException{
        try {

            //***  Establishing the connection
            con = null;
            Statement s = null;
            Class.forName (JDBC_DRIVER);

            // in the url we have to tell which account and password to use
            con =  DriverManager.getConnection(DATABASE_URL,"root","yzt42rmt");

            //*** now that the connection is established we do the query
            s = con.createStatement();

            ResultSet rs = s.executeQuery("SELECT vendor_name,  vendor_city  from vendors where default_account_number > '500'");

            // if the resultset is not empty, we position to first row and display first field
            if (rs != null)
                while (rs.next()) {
                    //System.out.println("Data from name: " + rs.getString("vendor_name") +
                    //      "        " + rs.getString("vendor_city"));
                    System.out.printf("Data from name: %-34s ",rs.getString("vendor_name"));
                    System.out.printf("%s\n ",rs.getString("vendor_city"));
                }
            s.close();
            con.close();
        }
        /* correct errorhandling takes up a lot of space */
        catch (SQLException sqlex) {
            try{
                System.out.println(sqlex.getMessage());
                con.close();
                System.exit(1);  // terminate program
            }
            catch(SQLException sql){}
        }
        catch (ClassNotFoundException noClass) {
            System.err.println("Driver Class not found");
            System.out.println(noClass.getMessage());
            System.exit(1);  // terminate program
        }
    }



    //metoden går ud fra at der er en arraylist der hedder users, med alle brugerne i.
    //metoden skal rettes til så den tilgår databasen og skal derefter returnere selve objektet
    private static User login(String username, String password) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername())== username.toLowerCase() && users.get(i).getPassword()==password.toLowerCase()) {
                return users.get(i);
            }
        }

    }




}
