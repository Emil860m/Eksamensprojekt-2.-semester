package exam.ps;

import java.sql.*;

public class dbConn {  // Lavet med inspiration fra Cay og hjælp fra Jonas


    static dbConn instance = new dbConn();
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://35.195.34.200:3306/ap?useSSL=false";
    static Connection con;

    /**
     * we want to use JDBC protocol, mysql DBMS , the local host with
     * the database ap
     */

    public Connection createConnection() {
        con = null;
        try {
            Class.forName(JDBC_DRIVER);
            return con = DriverManager.getConnection(DATABASE_URL, "root", "yzt42rmt");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static dbConn getInstance() {
        return instance;
    }


}
