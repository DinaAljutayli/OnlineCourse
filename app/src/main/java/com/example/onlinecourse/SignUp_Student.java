package com.example.onlinecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlinecourse.ui.login.LoginActivity;

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

        SignUp_Button = findViewById(R.id.SignUp_Teacher_Button);

        SignUp_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student s = new Student();

                s.setName(FullName_PlaneText.getText().toString());
                s.setId(Integer.parseInt(StudentID_PlaneText.getText().toString()));
                s.setLevel(Level_TextNumber.getText().toString().trim());
                s.setDepartment(Department_PlaneText.getText().toString().trim());
                s.setPassword(Password_Text.getText().toString().trim());
                s.setUsername(userName_Planetext.getText().toString().trim());

               long val = db.addStudent(s);

                if(val>0) {

                    Toast.makeText(SignUp_Student.this, "Sign Up successfully ! ", Toast.LENGTH_SHORT).show();
                    Intent loginIntent = new Intent(SignUp_Student.this, LoginActivity.class);
                    startActivity(loginIntent);
                }
                else {
                    Toast.makeText(SignUp_Student.this, "Not registered, Please sign up", Toast.LENGTH_SHORT).show();

                }

            }
        });





}
}