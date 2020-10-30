package com.example.onlinecourse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CourseInformation extends AppCompatActivity {

    RadioGroup languages_RadioGroup;
    Button view_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_information);

        languages_RadioGroup = findViewById(R.id.languages_RadioGroup);
        view_Button = findViewById(R.id.view_Button);

        view_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int checkedId = languages_RadioGroup.getCheckedRadioButtonId();
                findRadioButton(checkedId);


            }
        });
    }

    public void findRadioButton(int checkedId)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this).setTitle("Language information");

        switch (checkedId)
        {
            case R.id.java_RadioButton:
                dialog.setMessage("This is java");
                dialog.setNegativeButton("ok",null);
                dialog.show();
                break;

            case R.id.kotlin_RadioButton:
                dialog.setMessage("This is kotlin");
                dialog.setNegativeButton("ok",null);
                dialog.show();
                break;

            case R.id.android_RadioButton:
                dialog.setMessage("This is android");
                dialog.setNegativeButton("ok",null);
                dialog.show();
                break;

            default:
                Toast.makeText(this, "Please select a language", Toast.LENGTH_SHORT).show();
        }
    }




}