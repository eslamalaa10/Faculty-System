/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eammn
 */
public class Data_controller {

    private Connection connection;
    private static Data_controller dm = new Data_controller();

    private Data_controller() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:data.db");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Faculty_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Data_controller get_Data_controller() {
        return dm;
    }

    public Connection getConnection() {
        return connection;
    }

    public void CloseConnetion() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Data_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
