package com.example.onlinecourse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "StudentTeacher.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_STUDENT = "student";
    private static final String TABLE_TEACHER = "teacher";

    private static final String COL_STUDENT_ID = "student_id";
    private static final String COL_STUDENT_NAME = "full_name";
    private static final String COL_STUDENT_DEPARTMENT = "department";
    private static final String COL_STUDENT_LEVEL ="level";
    private static final String COL_STUDENT_USERNAME ="username";
    private static final String COL_STUDENT_PASSWORD ="password";

    private static final String COL_TEACHER_ID = "teacher_id";
    private static final String COL_TEACHER_NAME = "full_name";
    private static final String COL_TEACHER_DEPARTMENT = "department";
    private static final String COL_TEACHER_EMAIL = "email";
    private static final String COL_TEACHER_USERNAME = "username";
    private static final String COL_TEACHER_PASSWORD = "password";





    SQLiteDatabase db;

    ArrayList<String> list;

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

     final String queryStudent = "CREATE TABLE " + TABLE_STUDENT + " ("+
             COL_STUDENT_ID + " TEXT PRIMARY KEY, "+
             COL_STUDENT_NAME + " TEXT, " +
             COL_STUDENT_PASSWORD + " TEXT, " +
             COL_STUDENT_USERNAME + " TEXT, " +
             COL_STUDENT_DEPARTMENT + " TEXT, " +
             COL_STUDENT_LEVEL + " TEXT);";


     final String queryTeacher = "CREATE TABLE " + TABLE_TEACHER + " (" +
             COL_TEACHER_ID + " TEXT PRIMARY KEY, "+
             COL_TEACHER_NAME + " TEXT, " +
             COL_TEACHER_PASSWORD + " TEXT, "+
             COL_TEACHER_USERNAME + " TEXT, "+
             COL_TEACHER_DEPARTMENT + " TEXT, "+
             COL_TEACHER_EMAIL + " TEXT);";

        db.execSQL(queryStudent);
        db.execSQL(queryTeacher);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEACHER);
        onCreate(db);
    }

    public long addStudent(String id, String level, String department, String name, String password, String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COL_STUDENT_ID,id);
        cv.put(COL_STUDENT_LEVEL,level);
        cv.put(COL_STUDENT_DEPARTMENT,department);
        cv.put(COL_STUDENT_NAME,name);
        cv.put(COL_STUDENT_PASSWORD,password);
        cv.put(COL_STUDENT_USERNAME,username);

        long res = db.insert(TABLE_STUDENT,null,cv);

        return res;


    }




    public long addTeacher(String id, String email, String department, String name, String password, String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COL_TEACHER_ID,id);
        cv.put(COL_TEACHER_EMAIL,email);
        cv.put(COL_TEACHER_DEPARTMENT,department);
        cv.put(COL_TEACHER_NAME,name);
        cv.put(COL_TEACHER_PASSWORD,password);
        cv.put(COL_TEACHER_USERNAME,username);

        long res = db.insert(TABLE_TEACHER,null,cv);

        return res;


    }


    public boolean checkStudent(String username, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String [] columns = {COL_STUDENT_USERNAME};
        String selection = COL_STUDENT_USERNAME + "=?" + " and " + COL_STUDENT_PASSWORD + "=?";
        String [] selectionArgs = {username,password};
        Cursor cursor = db.query(TABLE_STUDENT,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return true;
        else
            return false;

    }


    public boolean checkTeacher(String username, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String [] columns = {COL_TEACHER_USERNAME};
        String selection = COL_TEACHER_USERNAME + "=?" + " and " + COL_TEACHER_PASSWORD + "=?";
        String [] selectionArgs = {username,password};
        Cursor cursor = db.query(TABLE_TEACHER,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return true;
        else
            return false;

    }

    public Cursor studentInfo()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "select * from " + TABLE_STUDENT ;
        Cursor c = db.rawQuery(query,null);

        return c;
    }

}
