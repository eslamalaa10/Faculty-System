/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Feedback;
/**
 *
 * @author eammn
 */
public class Feedback_controller {

    private static final Connection con = Data_controller.get_Connection();

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
    
    public ArrayList<Feedback> view_feedback(){
        ResultSet result;
        Feedback f = null;
        ArrayList<Feedback> Feedbacks = new ArrayList<>();
        try {
            Statement state;
            state = con.createStatement();
            result = state.executeQuery("select * from feedback");
            while (result.next()) {
                f=new Feedback(result.getString("email"),result.getString("subject"), result.getString("message"));
                Feedbacks.add(f);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return Feedbacks;
    }
}
