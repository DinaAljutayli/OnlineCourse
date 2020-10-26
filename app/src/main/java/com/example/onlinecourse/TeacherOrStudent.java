package com.example.onlinecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.time.Instant;

public class TeacherOrStudent extends AppCompatActivity {

    Button Teacher_Button;
    Button Student_Button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_or_student);

        Teacher_Button = findViewById(R.id.Teacher_Button);
        Student_Button = findViewById(R.id.Student_Button);

        Teacher_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent signUpTeacherIntent = new Intent( TeacherOrStudent.this , SignUp_Teacher.class);
                startActivity(signUpTeacherIntent);

            }
        });

        Student_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent signUpStudentIntent = new Intent( TeacherOrStudent.this , SignUp_Student.class);
                startActivity(signUpStudentIntent);
            }
        });
    }
}