package com.example.studentdata.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Student extends PersistentObject {
    protected String firstName;
    protected String lastName;
    protected String CWID;
    protected ArrayList<CourseEnrollment> courses;

    public Student(String fName, String lName, String id){
        firstName = fName;
        lastName = lName;
        CWID = id;
    }

    public Student(){}

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

    @Override
    public void insert(SQLiteDatabase db) {
        ContentValues vals = new ContentValues();
        vals.put("FirstName", firstName);
        vals.put("LastName", lastName);
        vals.put("CWID", CWID);
        db.insert("Students", null, vals);

        //Insert Courses
        for (int i = 0; i < courses.size(); i++){
            courses.get(i).insert(db);
        }
    }

    @Override
    public void createTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Students (FirstName Text, LastName Text, CWID Text)");
    }

    @Override
    public void initFrom(SQLiteDatabase db, Cursor cursor) {
        firstName = cursor.getString(cursor.getColumnIndex("FirstName"));
        lastName = cursor.getString(cursor.getColumnIndex("LastName"));
        CWID = cursor.getString(cursor.getColumnIndex("CWID"));

        //Get Courses
        courses = new ArrayList<>();
        Cursor c = db.query("Courses", null, "Student=?", new String[]{CWID}, null, null, null);
        if (c.getCount() > 0){
            while (c.moveToNext()){
                CourseEnrollment courseObj = new CourseEnrollment();
                courseObj.initFrom(db, c);
            }
        }
    }
}
