package com.example.studentdata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.studentdata.model.Student;
import com.example.studentdata.model.StudentDB;

import java.util.ArrayList;

public class AddStudentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);




        Button done_Button = findViewById(R.id.done_button);
        done_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Student> currentList = StudentDB.getInstance().getStudents();


                EditText editF = findViewById(R.id.edit_first);
                EditText editL = findViewById(R.id.edit_last);
                EditText editC = findViewById(R.id.edit_cwid);

                String fName = editF.getText().toString();
                String lName = editL.getText().toString();
                String CWID = editC.getText().toString();

                Student newStudent = new Student(fName, lName, Integer.valueOf(CWID));

                currentList.add(newStudent);
                v.invalidate();
            }
        });

    }
}
