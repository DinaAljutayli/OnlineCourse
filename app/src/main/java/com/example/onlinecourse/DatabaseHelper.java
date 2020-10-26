package com.example.onlinecourse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="TecherStudent.db";
    public static final String TABLE1_NAME = "Student";
    public static final String TABLE2_NAME = "Teacher";
    public static final String TABLE3_NAME = "Course";

    public static final String COLUMN_STUDENT_NAME ="Full_Name";
    public static final String COLUMN_STUDENT_DEPARTMENT ="Department";
    public static final String COLUMN_STUDENT_LEVEL ="Level";
    public static final String COLUMN_STUDENT_ID ="Student_ID";
    public static final String COLUMN_STUDENT_USERNAME ="Username";
    public static final String COLUMN_STUDENT_PASSWORD ="Password";
    public static final String COLUMN_STUDENT_COURSES ="Courses";

    SQLiteDatabase sqLiteDatabase;

    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String CREATE_STUDENT_TABLE = "CREATE TABLE " + TABLE1_NAME + "(Student_ID INTEGER PRIMARY KEY, Department TEXT)";
        sqLiteDatabase.execSQL(CREATE_STUDENT_TABLE);


    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);
        onCreate(sqLiteDatabase);
    }


    public long addUser(String user, String password, String Email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Username",user);
        contentValues.put("Email",Email);
        contentValues.put("password",password);

        long res = db.insert("registeruser",null,contentValues);
        db.close();
        return  res;
    }

  /*  public boolean checkUser(String username, String password ){
        String[] columns = { COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection =   COL_1 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = {username, password };
        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return  true;
        else
            return  false;
    }
*/
    public void openDatabase() {
        sqLiteDatabase = this.getWritableDatabase();
    }


}
