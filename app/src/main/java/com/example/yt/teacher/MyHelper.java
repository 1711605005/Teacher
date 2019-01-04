package com.example.yt.teacher;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(Context context, String dBName, SQLiteDatabase.CursorFactory factory, int version){
        super(context,dBName,factory,version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table teacher(_id integer primary key autoincrement,name varchar(20),num integer)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
