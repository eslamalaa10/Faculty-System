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
public class Faculty {

    public Faculty(String name, String department, String courses, String areaofexpertise, String professionalInterest) {
        this.name = name;
        this.department = department;
        this.courses = courses;
        this.areaofexpertise = areaofexpertise;
        this.professionalInterest = professionalInterest;
    }
    private String name;
    private String department;
    private String courses;
    private String areaofexpertise;
    private String professionalInterest;


    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getCourses() {
        return courses;
    }

    public String getAreaofexpertise() {
        return areaofexpertise;
    }

    public String getProfessionalInterest() {
        return professionalInterest;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public void setAreaofexpertise(String areaofexpertise) {
        this.areaofexpertise = areaofexpertise;
    }

    public void setProfessionalInterest(String professionalInterest) {
        this.professionalInterest = professionalInterest;
    }
}
