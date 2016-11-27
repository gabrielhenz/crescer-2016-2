/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gabriel.henz
 */
public class ConnectionUtils {
    
    private static final String URL = "jdbc:oracle:thin:@10.99.2.45:1521:tema3";
    private static final String USER = "cwi";
    private static final String PASS = "cwi";

   public static Connection getConnection() throws SQLException{
       return DriverManager.getConnection(URL, USER, PASS);
   }
}
