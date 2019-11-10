package com.example.studentdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.studentdata.model.CourseEnrollment;
import com.example.studentdata.model.Student;
import com.example.studentdata.model.StudentDB;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createStudentObjects();

        setContentView(R.layout.student_summary);
        root = findViewById(R.id.student_summary);

        ArrayList<Student> students = StudentDB.getInstance().getStudents();
        for (int i = 0; i < students.size(); i++){
            Student s = students.get(i);
            LayoutInflater inflater = LayoutInflater.from(this);
            View row_view = inflater.inflate(R.layout.student_row, root, false);
            TextView fNameView = row_view.findViewById(R.id.first_name);
            fNameView.setText(s.getFirstName());
            fNameView.setTextSize(16);

            TextView lNameView = row_view.findViewById(R.id.last_name);
            lNameView.setText(s.getLastName());
            lNameView.setTextSize(16);

            root.addView(row_view);
        }

    }

    protected void createStudentObjects(){
        ArrayList<Student> studentList = new ArrayList<>();

        Student s = new Student("James", "Harden", 192845);
        ArrayList<CourseEnrollment> courses = new ArrayList<>();
        courses.add(new CourseEnrollment("CPSC 471", "A"));
        courses.add(new CourseEnrollment("CPSC 411", "A"));
        s.setCourses(courses);
        studentList.add(s);

        s = new Student("Kyle", "Kuzma", 196340);
        courses = new ArrayList<>();
        courses.add(new CourseEnrollment("CPSC 481", "C"));
        courses.add(new CourseEnrollment("CPSC 420", "B"));
        s.setCourses(courses);
        studentList.add(s);

        s = new Student("LeBron", "James", 196340);
        courses = new ArrayList<>();
        courses.add(new CourseEnrollment("CPSC 481", "C"));
        courses.add(new CourseEnrollment("CPSC 420", "B"));
        s.setCourses(courses);
        studentList.add(s);

        s = new Student("Ashy", "Larry", 196340);
        courses = new ArrayList<>();
        courses.add(new CourseEnrollment("CPSC 481", "C"));
        courses.add(new CourseEnrollment("CPSC 420", "B"));
        s.setCourses(courses);
        studentList.add(s);

        StudentDB.getInstance().setStudents(studentList);
    }
}
