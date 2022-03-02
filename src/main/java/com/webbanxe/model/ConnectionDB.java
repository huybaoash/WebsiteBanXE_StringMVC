package com.webbanxe.model;

import java.sql.*;
import java.io.IOException;


public class ConnectionDB {
    private String url = "jdbc:mysql://localhost:3306/";
    private String username = "sa";
    private String password = "sa";
    private String driverName = "com.mysql.jdbc.Driver";
    private String dbName = "qlbanxehoi";
    

    public Connection conn;
    public Statement stmt;
    public ResultSet rs;

    public ConnectionDB() throws ClassNotFoundException, SQLException {
    	try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName(driverName).newInstance();
            conn =	DriverManager.getConnection(url + dbName,username,password);
            if (!conn.isClosed()) {
            	System.out.print("Kết nối database thành công !");
            }
            if (conn == null) System.out.println("Fail connect database");
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
           
            rs = null;
            
        } catch (Exception ex) {
            // handle the error
        	System.out.print("Ko kết nối database được !");
        }
    }

}