package com.example.onlinecourse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;





public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "StudentTeacher.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_STUDENT = "student";

    private static final String COL_STUDENT_ID = "student_id";
    private static final String COL_STUDENT_NAME = "full_name";
    private static final String COL_STUDENT_DEPARTMENT = "department";
    private static final String COL_STUDENT_LEVEL ="level";
    private static final String COL_STUDENT_USERNAME ="username";
    private static final String COL_STUDENT_PASSWORD ="password";





    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

     /*   final String CREATE_TODO_TABLE = "CREATE TABLE " + "TODO_TABLE"  + "(" + "ID" + " INTEGER PRIMARY KEY AUTOINCREMENT, " + "TASK" + " TEXT, "
                + "STATUS" + " INTEGER)";
        db.execSQL(CREATE_TODO_TABLE);

        //db.execSQL("CREATE TABLE " + TABLE_STUDENT + "(" + COL_STUDENT_ID +"INTEGER PRIMARY KEY)");*/


        db.execSQL(
                "CREATE TABLE "+ TABLE_STUDENT + " ( "
                +COL_STUDENT_ID +" INTEGER PRIMARY KEY, "
                +COL_STUDENT_DEPARTMENT + "TEXT, "
                +COL_STUDENT_LEVEL + "INTEGER, "
                +COL_STUDENT_NAME + "TEXT, "
                +COL_STUDENT_PASSWORD +"TEXT, "
                +COL_STUDENT_USERNAME +"TEXT)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_STUDENT);
        onCreate(db);
    }

    public void openDatabase(){

        db = this.getWritableDatabase();
    }
}
