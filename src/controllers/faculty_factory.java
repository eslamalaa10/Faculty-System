/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.util.ArrayList;
import models.*;
/**
 *
 * @author eammn
 */
public class faculty_factory {
    static final Faculty_controller fc = new Faculty_controller();
    static ArrayList<Faculty>faculties =fc.get_all_faculties();
    public static AbstractFaculty get_faculty(String name){
        
        for (Faculty faculty : faculties) {
            if(faculty.get_name().equals(name)){
                return new Faculty(faculty.get_name(),faculty.get_department() ,faculty.get_courses(),faculty.get_areaofexpertise(), faculty.get_professionalInterest());
            }
        }
        return new Null_Faculty();
    }
}
