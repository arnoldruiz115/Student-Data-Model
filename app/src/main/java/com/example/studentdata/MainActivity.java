package com.example.studentdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
    StudentAdapter sa;
    protected final String TAG = "Summary Screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.student_summary);


        root = findViewById(R.id.List_ViewID);
        sa = new StudentAdapter(this);
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
        ViewGroup vg = findViewById(R.id.student_summary);
        vg.invalidate();

    }

}
