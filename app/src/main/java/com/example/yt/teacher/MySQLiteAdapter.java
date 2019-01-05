package com.example.yt.teacher;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
        closeDatabase();
        return result;
    }
    public boolean update(Infor infor){
        boolean result=false;
        openDatabase();
        ContentValues values=new ContentValues();
        values.put("num",infor.getNum());
        values.put("sex",infor.getSex());
        values.put("degree",infor.getDegree());
        values.put("course",infor.getCourse());
        values.put("emile",infor.getEmile());
        values.put("phone",infor.getPhone());
        int number=db.update("teacher",values,"name=?",new String[]{infor.getName()});
        if (number>0){
            result=true;
            Toast.makeText(context,"修改成功",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(context,"修改失败",Toast.LENGTH_SHORT).show();
        }


        closeDatabase();
        return result;
    }
    public List<Infor> query(){
        openDatabase();
        //数据库查询结果cursor-->List<>集合类
        List<Infor> list=new ArrayList<>();
        Cursor cursor=db.query("teacher",null,null,null,null,null,null);
        //Cursor->（Infor对象集合多条Infor对象)
        int length=cursor.getCount();
        if(length>0){
            cursor.moveToFirst();
            do{
                //读数据
                //int id=cursor.getInt(cursor.getColumnIndex("_id"));//_id列
                String name=cursor.getString(cursor.getColumnIndex("name"));//name列
                Long phone=cursor.getLong(cursor.getColumnIndex("phone"));//phone列
                Long num=cursor.getLong(cursor.getColumnIndex("num"));
                String degree=cursor.getString(cursor.getColumnIndex("degree"));
                Long emile=cursor.getLong(cursor.getColumnIndex("emile"));
                String course=cursor.getString(cursor.getColumnIndex("course"));
                String sex=cursor.getString(cursor.getColumnIndex("sex"));
                Infor infor=new Infor();
              //  infor.set_id(id);
                infor.setName(name);
                infor.setPhone(phone);
                infor.setCourse(course);
                infor.setEmile(emile);
                infor.setDegree(degree);
                infor.setSex(sex);
                infor.setNum(num);
                list.add(infor);


            }while(cursor.moveToNext());
        }
        closeDatabase();
        return list;
    }

    //删除  功能：根据姓名删除记录  输入：姓名  输出：boolean
    public boolean deleteByName(String name){
        openDatabase();
        boolean result=false;
        int num=db.delete("teacher","name=?",new String[]{name});
        if (num>0){
            result=true;
            Toast.makeText(context,"删除成功",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(context,"删除失败",Toast.LENGTH_SHORT).show();
        }
        closeDatabase();
        return result;
    }

}
