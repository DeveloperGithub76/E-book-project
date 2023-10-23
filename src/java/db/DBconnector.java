/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sunil
 */
public class DBconnector {
    
 static Connection con = null;
    static Statement st = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook-app", "root", "root");
            System.out.println("Driver loaded...");
            st = con.createStatement();

        } 
        catch (ClassNotFoundException e)
        {
            System.out.println(e);
        }
        catch (SQLException e) 
        {
            System.out.println(e);
        }
    }

    public static Connection getConnection() {
        return con;
    }

    public static Statement getStatement() {
        return st;
    }

}

