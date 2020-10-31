package com.example.onlinecourse;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter_Student extends BaseAdapter {

    Activity act;
    ArrayList<Student> arrayStudent;

    public Adapter_Student(Activity act, ArrayList<Student> arrayStudent)
    {
        this.act=act;
        this.arrayStudent=arrayStudent;

    }
    @Override
    public int getCount() {
        return arrayStudent.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return arrayStudent.get(i).getId();
    }

    private class ViewHolder
    {
       TextView dialog_TextView;
     //   ListView listView;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final ViewHolder viewHolder;
        LayoutInflater inflater = act.getLayoutInflater();

        if(view == null )
        {
            view = inflater.inflate(R.layout.activity_student__details, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.dialog_TextView = view.findViewById(R.id.dialog_TextView);

            //viewHolder.listView = view.findViewById(R.id.studentInfo_ListView);

            // if not shown, create new text view for each element

            viewHolder.dialog_TextView.setText(
                    arrayStudent.get(i).getId() +"\n"+ arrayStudent.get(i).getName() + "\n" + arrayStudent.get(i).getDepartment()
                    + "\n" + arrayStudent.get(i).getLevel());


        }
        // return vid 19 minute 13

        return view;
    }
}
