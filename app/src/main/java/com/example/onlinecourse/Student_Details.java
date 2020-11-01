package com.example.onlinecourse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;


public class Student_Details extends AppCompatActivity {

    TextView dialog_TextView;
    ArrayList<Student> s;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__details);

        dialog_TextView = findViewById(R.id.dialog_TextView);

        String strID = getIntent().getStringExtra("StudentID");

        db = new DatabaseHelper(this);
        s = db.viewableInfo();

        dialog_TextView.setText("Name: "+s.get(5).getName() + "\n" + "Department: " + s.get(5).getDepartment() + "\n" + "Level: " + s.get(5).getLevel());
       // dialog_TextView.setText(s.getName() + "\n" + s.getDepartment() + "\n" + s.getLevel());
    }
}