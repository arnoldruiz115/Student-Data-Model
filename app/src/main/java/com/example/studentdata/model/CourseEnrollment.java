package com.example.studentdata.model;

public class CourseEnrollment {
    protected String courseID;
    protected String studentGrade;

    public CourseEnrollment(String id, String grade){
        courseID = id;
        studentGrade = grade;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }
}
