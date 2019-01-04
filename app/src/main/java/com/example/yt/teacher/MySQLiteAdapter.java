package com.example.yt.teacher;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class MySQLiteAdapter {
    private Context context;
    private String dBName;
    public MySQLiteAdapter(Context context,String dBName){
        this.context=context;
        this.dBName=dBName;
    }
    private SQLiteDatabase db;
    private void openDatabase(){
        MyHelper myHelper=new MyHelper(context,dBName,null,1);
        db=myHelper.getWritableDatabase();
    }
    private void closeDatabase(){
        db=null;
    }
    public boolean insert (Infor infor){
        openDatabase();
        boolean result=false;
        String name=infor.getName();
        String degree=infor.getDegree();
        String sex=infor.getSex();
        String course=infor.getCourse();
        long num=infor.getNum();
        long phone=infor.getPhone();
        long emile=infor.getEmile();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("num",num);
        values.put("degree",degree);
        values.put("phone",phone);
        values.put("sex",sex);
        values.put("course",course);
        values.put("emile",emile);

        long rawId=db.insert("teacher",null,values);
        if (rawId!=1){
            result=true;
        }
        return result;
    }

}
