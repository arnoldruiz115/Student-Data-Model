package com.example.studentdata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.studentdata.model.CourseEnrollment;
import com.example.studentdata.model.Student;
import com.example.studentdata.model.StudentDB;

import java.util.ArrayList;

public class StudentDetail extends AppCompatActivity {

    int studentIndex;
    protected LinearLayout root;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.student_classes);
        root = findViewById(R.id.classes_layout_id);

        studentIndex = getIntent().getIntExtra("StudentIndex", 0);

        TextView fName = findViewById(R.id.first_name_detail);
        TextView lName = findViewById(R.id.last_name_detail);
        TextView CWID = findViewById(R.id.CWID);

        //Get reference to database
        //Student student = StudentDB.getInstance().getStudents().get(studentIndex);
        Student student = new StudentDB(this).getStudents().get(studentIndex);

        fName.setText("First Name: " + student.getFirstName());
        lName.setText("Last Name: " + student.getLastName());
        CWID.setText("CWID: " + student.getCWID());

        ArrayList<CourseEnrollment> ce = new StudentDB(this).retrieveCourses(student.getCWID());


        for (int i = 0; i < ce.size(); i++){
            LayoutInflater inflater = LayoutInflater.from(this);
            View row_view = inflater.inflate(R.layout.class_row, root, false);

            CourseEnrollment c = ce.get(i);
            TextView courseID = row_view.findViewById(R.id.course_id);
            TextView grade = row_view.findViewById(R.id.grade_id);

            courseID.setText(c.getCourseID());
            grade.setText(c.getStudentGrade());

            root.addView(row_view);
        }


    }
}
