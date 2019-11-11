package com.example.studentdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.studentdata.adapter.StudentAdapter;
import com.example.studentdata.model.CourseEnrollment;
import com.example.studentdata.model.Student;
import com.example.studentdata.model.StudentDB;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected ListView root;
    protected final String TAG = "Summary Screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.student_summary);

        createStudentObjects();

        root = findViewById(R.id.List_ViewID);
        StudentAdapter sa = new StudentAdapter();
        root.setAdapter(sa);

        Button addStudentButton = findViewById(R.id.add_button_id);
        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddStudentActivity.class);
                v.getContext().startActivity(intent);
                v.invalidate();
            }
        });
    }

    protected void createStudentObjects(){
        ArrayList<Student> studentList = new ArrayList<>();

        Student s = new Student("James", "Harden", 192845);
        ArrayList<CourseEnrollment> courses = new ArrayList<>();
        courses.add(new CourseEnrollment("CPSC 471", "A"));
        courses.add(new CourseEnrollment("CPSC 411", "B"));
        courses.add(new CourseEnrollment("CPSC 412", "A"));
        s.setCourses(courses);
        studentList.add(s);

        s = new Student("Kyle", "Kuzma", 196340);
        courses = new ArrayList<>();
        courses.add(new CourseEnrollment("CPSC 481", "C"));
        courses.add(new CourseEnrollment("CPSC 421", "B"));
        s.setCourses(courses);
        studentList.add(s);

        s = new Student("LeBron", "James", 196340);
        courses = new ArrayList<>();
        courses.add(new CourseEnrollment("CPSC 481", "C"));
        courses.add(new CourseEnrollment("CPSC 420", "B"));
        s.setCourses(courses);
        studentList.add(s);

        StudentDB.getInstance().setStudents(studentList);
    }
}
