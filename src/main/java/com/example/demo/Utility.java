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

        //***  Establishing the connection
        con = dbConn.getInstance().createConnection();
        Statement s = null;
        //Class.forName (JDBC_DRIVER);

        // in the url we have to tell which account and password to use
        //con =  DriverManager.getConnection("jdbc:google:rdbms://fiery-nimbus-203407:europe-west1:myinstance/ap");

        //*** now that the connection is established we do the query
        s = con.createStatement();

        ResultSet rs = s.executeQuery("SELECT email FROM ap.Users");
        while(rs.next()) {
            System.out.println(rs.getString(1));
        }
        // if the resultset is not empty, we position to first row and display first field
           // if (rs != null)
             //   while (rs.next()) {
                    //System.out.println("Data from name: " + rs.getString("vendor_name") +
                    //      "        " + rs.getString("vendor_city"));
               //     System.out.printf("Data from name: %-34s ",rs.getString("Users"));
                 //   System.out.printf("%s\n ",rs.getString("email"));
               // }
            //s.close();
            //con.close();
        /*catch (ClassNotFoundException noClass) {
            System.err.println("Driver Class not found");
            System.out.println(noClass.getMessage());
            System.exit(1);  // terminate program

        }*/

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
