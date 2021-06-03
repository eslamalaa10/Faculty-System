/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author eammn
 */
public class Null_Faculty extends AbstractFaculty{

    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public String get_name() {
        return "Not Available in Faculty Database";
    }

    @Override
    public String get_department() {
        return "Not Available in Faculty Database";
    }

    @Override
    public String get_courses() {
        return "Not Available in Faculty Database";
    }

    @Override
    public String get_areaofexpertise() {
        return "Not Available in Faculty Database";
    }

    @Override
    public String get_professionalInterest() {
        return "Not Available in Faculty Database";
    }
    
}
