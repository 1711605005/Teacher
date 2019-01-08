package com.example.yt.teacher;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MySQLiteAdapter {
    private Context context;
    private String dBName;
    //private SQLiteOpenHelper myHelper;

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
        String num=infor.getNum();
        String phone=infor.getPhone();
        String emile=infor.getEmile();
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
        }else if (name.length()==0){
            Toast.makeText(context,"姓名不能为空！",Toast.LENGTH_SHORT).show();

    }else if (num.length()==0) {
        Toast.makeText(context, "姓名不能为空！", Toast.LENGTH_SHORT).show();

    }else if (course.length()==0) {
        Toast.makeText(context, "姓名不能为空！", Toast.LENGTH_SHORT).show();

    }else if (sex.length()==0) {
        Toast.makeText(context, "姓名不能为空！", Toast.LENGTH_SHORT).show();

    }else if (phone.length()==0) {
        Toast.makeText(context, "姓名不能为空！", Toast.LENGTH_SHORT).show();

    }else if (degree.length()==0) {
        Toast.makeText(context, "姓名不能为空！", Toast.LENGTH_SHORT).show();

    }else if (emile.length()==0) {
        Toast.makeText(context, "姓名不能为空！", Toast.LENGTH_SHORT).show();

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
                String phone=cursor.getString(cursor.getColumnIndex("phone"));//phone列
                String  num=cursor.getString(cursor.getColumnIndex("num"));
                String degree=cursor.getString(cursor.getColumnIndex("degree"));
                String emile=cursor.getString(cursor.getColumnIndex("emile"));
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
    public List<Infor> queryName(String name){
        openDatabase();
        //数据库查询结果cursor-->List<>集合类
        List<Infor> list=new ArrayList<>();
        Cursor cursor=db.query("teacher",null,"name=?",new String[]{name},null,null,null);
        //Cursor->（Infor对象集合多条Infor对象)
        int length=cursor.getCount();
        if(length>0){
            cursor.moveToFirst();
            do{
                //读数据
                //int id=cursor.getInt(cursor.getColumnIndex("_id"));//_id列
                name=cursor.getString(cursor.getColumnIndex("name"));//name列
                String phone=cursor.getString(cursor.getColumnIndex("phone"));//phone列
                String  num=cursor.getString(cursor.getColumnIndex("num"));
                String degree=cursor.getString(cursor.getColumnIndex("degree"));
                String emile=cursor.getString(cursor.getColumnIndex("emile"));
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
        int number=db.delete("teacher","name=?",new String[]{name});
        if (number>0){
            result=true;
            Toast.makeText(context,"删除成功",Toast.LENGTH_SHORT).show();

        }else {
            if (name.equals("")) {
                Toast.makeText(context, "请输入信息！", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "该教师信息已不在数据库中！", Toast.LENGTH_SHORT).show();
            }
        }
        closeDatabase();
        return result;
    }

    public List<Infor> queryNumCourse(String name, String course) {
        openDatabase();
        //数据库查询结果cursor-->List<>集合类
        List<Infor> list=new ArrayList<>();
        Cursor cursor=db.query("teacher",null,"name=? and course=?",new String[]{name,course},null,null,null);
        //Cursor->（Infor对象集合多条Infor对象)
        int length=cursor.getCount();
        if(length>0){
            cursor.moveToFirst();
            do{
                //读数据
                //int id=cursor.getInt(cursor.getColumnIndex("_id"));//_id列
                name=cursor.getString(cursor.getColumnIndex("name"));//name列
                String phone=cursor.getString(cursor.getColumnIndex("phone"));//phone列
                String  num=cursor.getString(cursor.getColumnIndex("num"));
                String degree=cursor.getString(cursor.getColumnIndex("degree"));
                String emile=cursor.getString(cursor.getColumnIndex("emile"));
                course=cursor.getString(cursor.getColumnIndex("course"));
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

    public List<Infor> queryByCourse(String course) {
        openDatabase();
        //数据库查询结果cursor-->List<>集合类
        List<Infor> list=new ArrayList<>();
        Cursor cursor=db.query("teacher",null,"course=?",new String[]{course},null,null,null);
        //Cursor->（Infor对象集合多条Infor对象)
        int length=cursor.getCount();
        if(length>0){
            cursor.moveToFirst();
            do{
                //读数据
                //int id=cursor.getInt(cursor.getColumnIndex("_id"));//_id列
                String name=cursor.getString(cursor.getColumnIndex("name"));//name列
                String phone=cursor.getString(cursor.getColumnIndex("phone"));//phone列
                String  num=cursor.getString(cursor.getColumnIndex("num"));
                String degree=cursor.getString(cursor.getColumnIndex("degree"));
                String emile=cursor.getString(cursor.getColumnIndex("emile"));
                course=cursor.getString(cursor.getColumnIndex("course"));
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


//    public ArrayList<Infor> inquiry(String name){
//    public List<Infor> inquiry(){
//        openDatabase();
//        List<Infor> list=new ArrayList<>();
//        Cursor cursor=db.query("teacher",null,null,null,null,null,null,null);
//        int nameColumnlndex =cursor.getColumnCount();
//        String name=cursor.getString(nameColumnlndex);
//
//
//        closeDatabase();
//        return list;
//    }
//        ArrayList<Infor> list =new ArrayList<Infor>();
//        SQLiteDatabase db=myHelper.getReadableDatabase();
//        Cursor cursor=db.rawQuery("select name,num,course,sex,degree,phone,emile from teacher where name=?",new String[]{name});
//        if (cursor !=null && cursor.getCount()>0){
//            while(cursor.moveToNext()){
//                Infor infor=new Infor();
//                infor.name=cursor.getString(1);
//                infor.num=cursor.getLong(2);
//                infor.course=cursor.getString(3);
//                infor.sex=cursor.getString(4);
//                infor.phone=cursor.getLong(5);
//                infor.degree=cursor.getString(6);
//                infor.emile=cursor.getLong(7);
//                list.add(infor);
//                System.out.println("姓名："+infor.name+"/n"+"教师编号："+infor.num+"/n"+"所教课程："+infor.course+"/n"
//                        +"性别："+infor.sex+"/n"+"手机号码："+infor.phone+"/n"+"学历："+infor.degree+"/n"+"QQ号码："+infor.emile+"/n");
//            }
//            cursor.close();
//        }
//        db.close();
//        return list;
//    }
/*
    public List<Infor> inquiryname(){
        openDatabase();
        List<Infor> list=new ArrayList<>();
       Cursor cursor=db.query("teacher",null,"name=?",null,null,null,null,null);
        int length=cursor.getCount();
        ContentValues values=new ContentValues();
       // values.put("");
        if (length>0){

        }


        closeDatabase();
        return list;

   }
*/


}
