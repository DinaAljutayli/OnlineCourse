package com.example.onlinecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SignUp_Student extends AppCompatActivity {


    DatabaseHelper db;
    EditText FullName_PlainText;
    EditText Department_PlainText;
    EditText Level_TextNumber;
    EditText level_TextNumber;
    EditText userName_Plaintext;
    EditText Password_Text;
    Button SignUp_Button;

    RadioGroup radioGroup;
    RadioButton Student_RadioButton;
    RadioButton Teacher_RadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__student);

        radioGroup = findViewById(R.id.radioGroup);
        Student_RadioButton = findViewById(R.id.Student_RadioButton);
        Teacher_RadioButton = findViewById(R.id.Teacher_RadioButton);

        Teacher_RadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent TeacherIntent = new Intent(SignUp_Student.this, SignUp_Teacher.class);
                startActivity(TeacherIntent);
            }
        });

    }




}