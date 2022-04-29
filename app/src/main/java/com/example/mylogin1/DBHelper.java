package com.example.mylogin1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static String DBNAME="login.db";
    public DBHelper(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(username TEXT primary key,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");
    }

    Boolean insertdata(String username,String password){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues values=new ContentValues();

        values.put("username",username);
        values.put("password",password);

        long result = db.insert("users",null,values);

        if(result==-1)
            return true;
        else
            return false;
    }

    Boolean checkuser(String username){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from users where username=?",new String[]{username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    Boolean checkuserpassword(String username,String password){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from users where username=? and password=?",new String[]{username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
