package com.example.studentdata.model;

import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB ourInstance = new StudentDB();

    protected ArrayList<Student> students;

    static public StudentDB getInstance(){
        return ourInstance;
    }

    private StudentDB(){
        ArrayList<Student> studentList = new ArrayList<>();

        Student s = new Student("James", "Harden", "192845");
        ArrayList<CourseEnrollment> courses = new ArrayList<>();
        courses.add(new CourseEnrollment("CPSC 471", "A"));
        courses.add(new CourseEnrollment("CPSC 411", "B"));
        courses.add(new CourseEnrollment("CPSC 412", "A"));
        s.setCourses(courses);
        studentList.add(s);

        s = new Student("Kyle", "Kuzma", "196340");
        courses = new ArrayList<>();
        courses.add(new CourseEnrollment("CPSC 481", "C"));
        courses.add(new CourseEnrollment("CPSC 421", "B"));
        s.setCourses(courses);
        studentList.add(s);

        s = new Student("LeBron", "James", "196340");
        courses = new ArrayList<>();
        courses.add(new CourseEnrollment("CPSC 481", "C"));
        courses.add(new CourseEnrollment("CPSC 420", "B"));
        s.setCourses(courses);
        studentList.add(s);
        setStudents(studentList);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
