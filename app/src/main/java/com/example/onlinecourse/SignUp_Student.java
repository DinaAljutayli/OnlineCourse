package com.example.onlinecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUp_Student extends AppCompatActivity {
    DatabaseHelper db;
    EditText FullName_PlaneText,userName_Planetext,Level_TextNumber,Department_PlaneText,StudentID_PlaneText,Password_Text;
    Button SignUp_Button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__student);
        db = new DatabaseHelper(this);

        FullName_PlaneText = findViewById(R.id.FullName_PlaneText);
        userName_Planetext = findViewById(R.id.userName_Planetext);
        Level_TextNumber = findViewById(R.id.Level_TextNumber);
        Department_PlaneText = findViewById(R.id.Department_PlaneText);
        StudentID_PlaneText = findViewById(R.id.StudentID_PlaneText);
        Password_Text = findViewById(R.id.Password_Text);

        SignUp_Button = findViewById(R.id.SignUp_Button);

        SignUp_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullName = FullName_PlaneText.getText().toString();
                String id = StudentID_PlaneText.getText().toString().trim();
                String level = Level_TextNumber.getText().toString().trim();
                String department = Department_PlaneText.getText().toString().trim();
                String password = Password_Text.getText().toString().trim();
                String username = userName_Planetext.getText().toString().trim();

                db.addStudent(id,level,department,fullName,password,username);

                Toast.makeText(SignUp_Student.this, "Sign Up successfully ! ",  Toast.LENGTH_SHORT).show();

            }
        });





}
}