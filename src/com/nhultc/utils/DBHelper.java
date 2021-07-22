/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhultc.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dell
 */
public class DBHelper implements Serializable{
    public static Connection openConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url= "jdbc:sqlserver://localhost:1433; databaseName= ProductManager; intanceseName=EXPRESS";
            Connection conn= DriverManager.getConnection(url,"sa","05112000");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
