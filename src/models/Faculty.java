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
public class Faculty extends AbstractFaculty{

    public Faculty(String name, String department, String courses, String areaofexpertise, String professionalInterest) {
        this.name = name;
        this.department = department;
        this.courses = courses;
        this.areaofexpertise = areaofexpertise;
        this.professionalInterest = professionalInterest;
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

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public String get_name() {
        return name;
    }

    @Override
    public String get_department() {
        return department;
    }

    @Override
    public String get_courses() {
        return courses;
    }

    @Override
    public String get_areaofexpertise() {
        return areaofexpertise;
    }

    @Override
    public String get_professionalInterest() {
        return professionalInterest;
    }
}
