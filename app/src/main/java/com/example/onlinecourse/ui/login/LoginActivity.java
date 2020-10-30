package com.example.onlinecourse.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlinecourse.CourseInformation;
import com.example.onlinecourse.DatabaseHelper;
import com.example.onlinecourse.R;
import com.example.onlinecourse.Student_Info;

public class LoginActivity extends AppCompatActivity {


    DatabaseHelper db;
    EditText username_editext_login;
    EditText password_editext_login;
    TextView signUp_textview;
    Button loginbutton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);


        username_editext_login = findViewById(R.id.username_editext_login);
        password_editext_login = findViewById(R.id.password_editext_login);
        signUp_textview = findViewById(R.id.signUp_textview);
        loginbutton = findViewById(R.id.login_button);



        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username_editext_login.getText().toString().trim();
                String password = password_editext_login.getText().toString().trim();

                boolean res1 = db.checkStudent(user, password);
                boolean res2 = db.checkTeacher(user,password);

                if (res1)
                {
                    Intent courseIntent = new Intent(LoginActivity.this , CourseInformation.class);
                    courseIntent.putExtra("student_username" , user);
                    startActivity(courseIntent);


                } else if(res2)
                {

                    Intent studentInfoIntent = new Intent(LoginActivity.this, Student_Info.class);
                    startActivity(studentInfoIntent);

                }

                else
                    Toast.makeText(LoginActivity.this, "Not register, Please Sign up", Toast.LENGTH_SHORT).show();
            }
        });

        }



    }
