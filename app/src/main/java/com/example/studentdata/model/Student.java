package com.example.studentdata.model;

import java.util.ArrayList;

public class Student {
    protected String firstName;
    protected String lastName;
    protected String CWID;
    protected ArrayList<CourseEnrollment> courses;

    public Student(String fName, String lName, String id){
        firstName = fName;
        lastName = lName;
        CWID = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCWID() {
        return CWID;
    }

    public void setCWID(String CWID) {
        this.CWID = CWID;
    }

    public ArrayList<CourseEnrollment> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<CourseEnrollment> courses) {
        this.courses = courses;
    }
}
