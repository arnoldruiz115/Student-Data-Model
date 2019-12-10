package com.example.studentdata;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.studentdata.adapter.StudentAdapter;
import com.example.studentdata.model.CourseEnrollment;
import com.example.studentdata.model.Student;

import com.example.studentdata.model.StudentDB;

import java.util.ArrayList;

public class AddStudentActivity extends AppCompatActivity {

    final Context ref = this;
    public int added_Courses = 0;
    protected ArrayList<Integer> courseEntryIDs = new ArrayList<>();
    protected ArrayList<Integer> gradeEntryIDs = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        final StudentDB studentDB = new StudentDB(this);
        createAddCourse();



        Button done_Button = findViewById(R.id.done_button);
        done_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ArrayList<Student> currentList = StudentDB.getInstance().getStudents();
                ArrayList<Student> currentList = studentDB.getStudents();


                EditText editF = findViewById(R.id.edit_first);
                EditText editL = findViewById(R.id.edit_last);
                EditText editC = findViewById(R.id.edit_cwid);

                String fName = editF.getText().toString();
                String lName = editL.getText().toString();
                String CWID = editC.getText().toString();


                Student newStudent = new Student(fName, lName, CWID);

                ArrayList<CourseEnrollment> courses = new ArrayList<>();

                //Add courses
                for(int i = 0; i < added_Courses; i++){
                    EditText editCourse = findViewById(courseEntryIDs.get(i));
                    EditText editGrade = findViewById(gradeEntryIDs.get(i));

                    String course = editCourse.getText().toString();
                    String grade = editGrade.getText().toString();

                    CourseEnrollment c = new CourseEnrollment(course, grade, CWID);
                    courses.add(c);
                }

                newStudent.setCourses(courses);
                newStudent.insert(studentDB.studentSQLDB);

                currentList.add(newStudent);
                //StudentDB.getInstance().setStudents(currentList);
                studentDB.setStudents(currentList);

                finish();
            }
        });

        Button addCoursesButton = findViewById(R.id.addCoursesButtonId);
        addCoursesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAddCourse();
            }
        });

    }

    public void createAddCourse(){

        LinearLayout coursesLayout = findViewById(R.id.addCourses_id);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(20, 20 ,20,20);

        LinearLayout newCourse = new LinearLayout(ref);
        newCourse.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout courseID_Entry = new LinearLayout(ref);
        courseID_Entry.setOrientation(LinearLayout.HORIZONTAL);
        courseID_Entry.setLayoutParams(params);

        TextView courseText = new TextView(ref);
        courseText.setText("Course ID");


        EditText courseInput = new EditText(ref);
        int courseInputId = ViewCompat.generateViewId();
        courseEntryIDs.add(courseInputId);
        courseInput.setId(courseInputId);
        courseInput.setWidth(250);

        courseID_Entry.addView(courseText);
        courseID_Entry.addView(courseInput);

        LinearLayout courseGrade_Entry = new LinearLayout(ref);
        courseGrade_Entry.setOrientation(LinearLayout.HORIZONTAL);
        courseGrade_Entry.setLayoutParams(params);

        TextView gradeText = new TextView(ref);
        gradeText.setText("Grade");

        EditText gradeInput = new EditText(ref);
        int gradeEntryId = ViewCompat.generateViewId();
        gradeEntryIDs.add(gradeEntryId);
        gradeInput.setId(gradeEntryId);
        gradeInput.setWidth(150);


        courseGrade_Entry.addView(gradeText);
        courseGrade_Entry.addView(gradeInput);

        newCourse.addView(courseID_Entry);
        newCourse.addView(courseGrade_Entry);

        coursesLayout.addView(newCourse);
        added_Courses+=1;
    }
}
