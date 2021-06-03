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
public abstract class AbstractFaculty {
    protected String name;
    protected String department;
    protected String courses;
    protected String areaofexpertise;
    protected String professionalInterest;
    public abstract boolean isNil();
    public abstract String get_name();
    public abstract String get_department();
    public abstract String get_courses();
    public abstract String get_areaofexpertise();
    public abstract String get_professionalInterest();
}
