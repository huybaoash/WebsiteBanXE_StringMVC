package com.webbanxe.model;

import java.sql.*;
import java.io.IOException;


public class ConnectionDB {
    private String url = "jdbc:mysql://localhost:3306/";
    private String username = "sa";
    private String password = "sa";
    private String driverName = "com.mysql.jdbc.Driver";
    private String dbName = "qlsach";
    

    public Connection conn = null;
    public Statement stmt;
    public ResultSet rs;

    public ConnectionDB() throws ClassNotFoundException, SQLException {
    	try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName(driverName).newInstance();
            conn =	DriverManager.getConnection(url + dbName,username,password);
            if (!conn.isClosed()) {
            	System.out.print("Kết nối db được !");
            }
        } catch (Exception ex) {
            // handle the error
        	System.out.print("Ko kết nối db được !");
        }
    }

}