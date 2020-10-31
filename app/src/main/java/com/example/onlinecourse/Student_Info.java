package com.example.onlinecourse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Student_Info extends AppCompatActivity {

    ListView studentInfo_ListView;
    DatabaseHelper db;
    ArrayList<String> listItem;
    ArrayAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__info);

        db = new DatabaseHelper(this);
        listItem = new ArrayList<>();
        studentInfo_ListView = findViewById(R.id.studentInfo_ListView);


        viewData();

        studentInfo_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(Student_Info.this,Student_Details.class);
                intent.putExtra("detail" ,showData().toString());
                startActivity(intent);


            }
        });

    }


    public void viewData()
    {
        Cursor c = db.studentInfo();

        if(c.getCount() == 0)
        {
            Toast.makeText(this, "No students found", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while (c.moveToNext())
            {

                listItem.add(c.getString(0));
            }



            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listItem);
            studentInfo_ListView.setAdapter(adapter);

        }
    }


    public StringBuffer showData()
    {
        final StringBuffer buffer = new StringBuffer();
        Cursor res = db.studentInfo();

        while (res.moveToNext())
        {
            buffer.append("Name: " + res.getString(1)+"\n");
        }
        return buffer;
    }
}