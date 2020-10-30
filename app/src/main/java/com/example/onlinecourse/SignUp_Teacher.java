package com.example.onlinecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignUp_Teacher extends AppCompatActivity {

    DatabaseHelper db;
    EditText FullName_Teacher_PlaneText , userName_Teacher_PlaneText, Department_Teacher_PlaneText,FaculityID_PlaneText, Password_Teacher_Text,Email_Teacher_PlaneText;
    Button SignUp_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__teacher);

        db = new DatabaseHelper(this);

        FullName_Teacher_PlaneText = findViewById(R.id.FullName_Teacher_PlaneText);
        userName_Teacher_PlaneText = findViewById(R.id.userName_Teacher_PlaneText);
        Department_Teacher_PlaneText = findViewById(R.id.Department_Teacher_PlaneText);
        FaculityID_PlaneText = findViewById(R.id.FaculityID_PlaneText);
        Password_Teacher_Text = findViewById(R.id.Password_Teacher_Text);
        Email_Teacher_PlaneText = findViewById(R.id.Email_Teacher_Planetext);



    }
}