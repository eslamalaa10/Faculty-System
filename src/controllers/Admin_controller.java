/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.Admin;
import models.Faculty;

/**
 *
 * @author eammn
 */
public class Admin_controller {

    private static final Connection con = Data_controller.get_Connection();

    public String login(String email, String password) {
        ResultSet result;
        Admin f;
        String r=null;
       
        try {
            Statement state;
            state = con.createStatement();
            result = state.executeQuery("select * from admin where email='" + email + "'");
            if(!result.next()){
                r = "not found";
                result.beforeFirst();
            }
            
            f = new Admin(result.getString("name"), result.getString("email"), result.getString("password"));
            
            if (email.equals(f.getEmail()) && password.equals(f.getPassword())) {
                r = "welcom "+f.getName();
            } else {
                r = "not found";
            }
        } catch (SQLException ex) {
            System.out.println("");
        }

        return r;
    }

}
