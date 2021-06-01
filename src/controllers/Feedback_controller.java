/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author eammn
 */
public class Feedback_controller {

    private static final Connection con = Data_controller.get_Data_controller().getConnection();

    public String add_feedback(String email, String subject, String message) {
        try {

            PreparedStatement prep = con.prepareStatement("insert into feedback values(?,?,?);");
            prep.setString(1, email);
            prep.setString(2, subject);
            prep.setString(3, message);
            prep.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Faculty_controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "done";
    }
}
