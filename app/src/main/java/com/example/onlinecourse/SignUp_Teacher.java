package com.example.onlinecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlinecourse.ui.login.LoginActivity;

public class SignUp_Teacher extends AppCompatActivity {

    DatabaseHelper db;
    EditText FullName_Teacher_PlaneText , userName_Teacher_PlaneText, Department_Teacher_PlaneText,FaculityID_PlaneText, Password_Teacher_Text,Email_Teacher_PlaneText;
    Button SignUp_Teacher_Button;

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

        SignUp_Teacher_Button = findViewById(R.id.SignUp_Teacher_Button);



        SignUp_Teacher_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = FullName_Teacher_PlaneText.getText().toString();
                String username = userName_Teacher_PlaneText.getText().toString().trim();
                String department = Department_Teacher_PlaneText.getText().toString().trim();
                String id = FaculityID_PlaneText.getText().toString().trim();
                String password = Password_Teacher_Text.getText().toString().trim();
                String email = Email_Teacher_PlaneText.getText().toString().trim();



               long val = db.addTeacher(id,email,department,name,password,username);
               if(val>0) {

                   Toast.makeText(SignUp_Teacher.this, "Sign Up successfully ! ", Toast.LENGTH_SHORT).show();
                   Intent loginIntent = new Intent(SignUp_Teacher.this, LoginActivity.class);
                   startActivity(loginIntent);
               }
               else {
                   Toast.makeText(SignUp_Teacher.this, "Not registered, Please sign up", Toast.LENGTH_SHORT).show();

               }
            }
        });


    }
}