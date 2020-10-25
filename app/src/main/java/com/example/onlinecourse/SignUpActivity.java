package com.example.onlinecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SignUpActivity extends AppCompatActivity {


    DatabaseHelper db;
    EditText FullName_PlainText;
    EditText Department_PlainText;
    EditText Level_TextNumber;
    EditText level_TextNumber;
    EditText userName_Plaintext;
    EditText Password_Text;
    Button SignUp_Button;

    RadioGroup radioGroup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        radioGroup = findViewById(R.id.radioGroup);


    }
}