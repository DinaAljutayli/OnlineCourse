package com.example.onlinecourse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class Student_Details extends AppCompatActivity {

    TextView dialog_TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__details);

        dialog_TextView = findViewById(R.id.dialog_TextView);

        Intent intent = getIntent();

        String val = intent.getStringExtra("detail");

        dialog_TextView.setText(val);
    }
}