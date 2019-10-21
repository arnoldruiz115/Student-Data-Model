package com.example.studentdata.model;

import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB ourInstance = new StudentDB();

    protected ArrayList<Student> students;

    static public StudentDB getInstance(){
        return ourInstance;
    }

    private StudentDB(){

    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
