/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author huy
 */
public class ConnectionDB {
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=BKAPProject";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "huy12345";
    
    public static Connection openConnection() {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
        }
        return con;
    }
    
    public static void closeConnection(Connection con, CallableStatement callST) {
        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
        if(callST != null) {
            try {
                callST.close();
            } catch (SQLException e) {
            }
        }
    }
}
