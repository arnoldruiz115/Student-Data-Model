package com.example.studentdata.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.util.ArrayList;

public class StudentDB {
    //private static final StudentDB ourInstance = new StudentDB();


    protected ArrayList<Student> students;
    public SQLiteDatabase studentSQLDB;

    /*
    static public StudentDB getInstance(){
        return ourInstance;
    }
    */

    public StudentDB(Context context){
        //ArrayList<Student> studentList = new ArrayList<>();


        File dbFile = context.getDatabasePath("student.db");
        studentSQLDB = SQLiteDatabase.openOrCreateDatabase(dbFile, null);

        new Student().createTable(studentSQLDB);
        new CourseEnrollment().createTable(studentSQLDB);

    }

    public ArrayList<Student> retrieveStudentObjects(){
        students = new ArrayList<>();
        Cursor cursor = studentSQLDB.query("Students", null, null, null, null, null, null);
        if (cursor.getCount() > 0){
            while (cursor.moveToNext()) {
                Student studentObj = new Student();
                studentObj.initFrom(studentSQLDB, cursor);
                students.add(studentObj);
            }
        }
        return students;
    }

    public ArrayList<CourseEnrollment> retrieveCourses(String CWID){
        ArrayList<CourseEnrollment> courses = new ArrayList<>();
        Cursor c = studentSQLDB.query("Courses", null, "Student=?", new String[]{CWID}, null, null, null);
        if (c.getCount() > 0){
            while (c.moveToNext()){
                CourseEnrollment courseObj = new CourseEnrollment();
                courseObj.initFrom(studentSQLDB, c);
                courses.add(courseObj);
            }
        }
        return courses;
    }

    public ArrayList<Student> getStudents() {
        setStudents(retrieveStudentObjects());
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
