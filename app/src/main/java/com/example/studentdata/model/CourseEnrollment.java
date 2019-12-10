package com.example.studentdata.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CourseEnrollment extends PersistentObject{
    protected String courseID;
    protected String studentGrade;
    protected String CWID;

    public CourseEnrollment(String id, String grade, String CWID){
        courseID = id;
        studentGrade = grade;
        this.CWID = CWID;
    }

    public CourseEnrollment() {}

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

    @Override
    public void insert(SQLiteDatabase db) {
        ContentValues vals = new ContentValues();
        vals.put("CourseID", courseID);
        vals.put("Grade", studentGrade);
        vals.put("Student", CWID);
        db.insert("Courses",null, vals);
    }

    @Override
    public void createTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Courses (CourseID Text, Grade Text, Student String)");
    }

    @Override
    public void initFrom(SQLiteDatabase db, Cursor cursor) {
        courseID = cursor.getString(cursor.getColumnIndex("CourseID"));
        studentGrade = cursor.getString(cursor.getColumnIndex("Grade"));
        CWID = cursor.getString(cursor.getColumnIndex("Student"));
    }
}
