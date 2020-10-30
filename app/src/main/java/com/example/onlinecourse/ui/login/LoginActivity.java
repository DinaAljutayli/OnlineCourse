package com.example.onlinecourse.ui.login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.onlinecourse.DatabaseHelper;
import com.example.onlinecourse.R;

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

        signUp_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username_editext_login.getText().toString().trim();
                String password = password_editext_login.getText().toString().trim();
             //   Boolean res = db.checkUser(user, password);

              /*  if (res == true) {

                } else {

                }*/
            }

        });
    }
}