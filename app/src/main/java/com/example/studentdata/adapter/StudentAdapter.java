package com.example.studentdata.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.studentdata.R;
import com.example.studentdata.StudentDetail;
import com.example.studentdata.model.Student;
import com.example.studentdata.model.StudentDB;



public class StudentAdapter extends BaseAdapter {

    StudentDB studentDB;

    public StudentAdapter(Context context){
        studentDB = new StudentDB(context);
        studentDB.retrieveStudentObjects();
    }

    @Override
    public int getCount() {
        return studentDB.getStudents().size();
    }

    @Override
    public Object getItem(int position) {
        //return StudentDB.getInstance().getStudents().get(position);
        return studentDB.getStudents().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View row_view;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            row_view = inflater.inflate(R.layout.student_row, parent, false);
        }
        else row_view = convertView;

        //final Student student = StudentDB.getInstance().getStudents().get(position);
        Student student = studentDB.getStudents().get(position);

        TextView fName = row_view.findViewById(R.id.first_name);
        fName.setText(student.getFirstName());

        TextView lName = row_view.findViewById(R.id.last_name);
        lName.setText(student.getLastName());

        row_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), StudentDetail.class);
                intent.putExtra("StudentIndex", position);
                v.getContext().startActivity(intent);
            }
        });

        return row_view;
    }

}
