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
import models.Faculty;

/**
 *
 * @author Eslam Alaa
 */
public class Faculty_controller {

    private static final Connection con = Data_controller.get_Data_controller().getConnection();

    public Faculty get_faculty(String name) {
        ResultSet result;
        Faculty f = null;
        try {
            Statement state;
            state = con.createStatement();
            result = state.executeQuery("select * from faculty where name='" + name + "'");
            if (result.next()) {
                f = new Faculty(result.getString("name"), result.getString("department"), result.getString("courses"), result.getString("areaofexpertise"), result.getString("professionalInterest"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //Data_controller.get_Data_controller().CloseConnetion();
        return f;

    }

    public ArrayList<Faculty> get_all_faculties() {
        ResultSet result;
        Faculty f = null;
        ArrayList<Faculty> Faculties = new ArrayList<>();
        try {
            Statement state;
            state = con.createStatement();
            result = state.executeQuery("select * from faculty");
            while (result.next()) {
                Faculties.add(get_faculty(result.getString("name")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return Faculties;
    }

    public String add_faculty(String name, String department, String courses, String areaofexpertise, String professionalInterest) {

        try {

            PreparedStatement prep = con.prepareStatement("insert into faculty values(?,?,?,?,?);");
            prep.setString(1, name);
            prep.setString(2, department);
            prep.setString(3, courses);
            prep.setString(4, areaofexpertise);
            prep.setString(5, professionalInterest);
            prep.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Faculty_controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "done";
    }

    public String edit_faculty(String name, String department, String courses, String areaofexpertise, String professionalInterest) {
//        Faculty result;
        try {
//            if (get_faculty(name) == null) {
//                result = get_faculty(name);
//                if (department.isEmpty()) {
//                    department = result.getDepartment();
//                }
//                if (courses.isEmpty()) {
//                    courses = result.getCourses();
//                }
//                if (areaofexpertise.isEmpty()) {
//                    areaofexpertise = result.getAreaofexpertise();
//                }
//                if (professionalInterest.isEmpty()) {
//                    professionalInterest = result.getProfessionalInterest();
//                }
                PreparedStatement prep = con.prepareStatement("UPDATE faculty "
                        + "SET name = ?, department = ?,courses = ?, areaofexpertise = ?,professionalInterest = ? "
                        + "WHERE name = ?;");
                prep.setString(1, name);
                prep.setString(2, department);
                prep.setString(3, courses);
                prep.setString(4, areaofexpertise);
                prep.setString(5, professionalInterest);
                prep.setString(6, name);
                System.out.println("name:"+ name );
                prep.execute();
//            } else {
//                return "not found";
//            }
        } catch (SQLException ex) {
            return "can not edit";
        }
        return "done";
    }

    public String delete_faculty(String name) {
        try {
            if (get_faculty(name) != null) {

                PreparedStatement prep = con.prepareStatement("DELETE FROM faculty WHERE name = ?;");
                prep.setString(1, name);
                prep.execute();
            } else {
                return "not found";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Faculty_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "done";
    }

}
