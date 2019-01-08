package com.example.yt.teacher;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InquiryActivity extends AppCompatActivity {
    EditText edtTxtName,edtTxtCourse;
    TextView tvDisplay;
    private SQLiteOpenHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry);
        edtTxtName=findViewById(R.id.edtTxt_inquiry_name);
        edtTxtCourse=findViewById(R.id.edtTxt_inquiry_course);
        tvDisplay=findViewById(R.id.tv_inquiry_display);

        findViewById(R.id.btn_inquiry_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySQLiteAdapter adapter=new MySQLiteAdapter(getApplicationContext(),"database.db");
                List<Infor> list=adapter.query();
                Iterator<Infor> iter=list.iterator();//迭代器
                tvDisplay.setText(null);//读取数据前清空上一次的数据
                while(iter.hasNext()){//判断是否有下一条数据
                    Infor infor=iter.next();//获取下一条数据，返回类型为list里的泛类
                    //int id=infor.get_id();//从infor对象中读取值
                    String name=infor.getName();
                    String sex=infor.getSex();
                    String degree=infor.getDegree();
                    String course=infor.getCourse();
                    Long num=infor.getNum();
                    Long emile=infor.getEmile();
                    Long phone=infor.getPhone();
                    // tvDisplay.append(" id:"+String.valueOf(id));//追加
                    tvDisplay.append("姓名："+name);
                    tvDisplay.append("\n");
                    tvDisplay.append("教师编号："+String.valueOf(num));
                    tvDisplay.append("\n");
                    tvDisplay.append("所教课程："+course);
                    tvDisplay.append("\n");
                    tvDisplay.append("学历："+degree);
                    tvDisplay.append("\n");
                    tvDisplay.append("性别："+sex);
                    tvDisplay.append("\n");
                    tvDisplay.append("手机号码："+String.valueOf(phone));
                    tvDisplay.append("\n");
                    tvDisplay.append("QQ号码："+String.valueOf(emile));
                    tvDisplay.append("\n"+"\n");//读完换行

                }

            }
        });

        findViewById(R.id.btn_inquiry_cheak).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edtTxtName.getText().toString().trim();
                String course=edtTxtCourse.getText().toString().trim();
                MySQLiteAdapter adapter=new MySQLiteAdapter(getApplicationContext(),"database.db");
                List<Infor> list=new ArrayList<>();
                if(!name.equals("")){

                        list=adapter.queryName(name);

                }else {
                    if (!course.equals("")){
                        list=adapter.queryByCourse(course);
                    }
                }
                Iterator<Infor> iterator=list.iterator();
                tvDisplay.setText(null);
                while(iterator.hasNext()) {//判断是否有下一条数据
                    Infor infor = iterator.next();//获取下一条数据，返回类型为list里的泛类
                    tvDisplay.append("姓名："+infor.getName()+"\n");
                    tvDisplay.append("教师编号："+String.valueOf(infor.getNum()+"\n"));
                    tvDisplay.append("所教课程："+infor.getCourse()+"\n");
                    tvDisplay.append("学历："+infor.getDegree()+"\n");
                    tvDisplay.append("性别："+infor.getSex()+"\n");
                    tvDisplay.append("电话号码："+String.valueOf(infor.getPhone()+"\n"));
                    tvDisplay.append("QQ号码："+String.valueOf(infor.getEmile()+"\n"));
                    tvDisplay.append("\n");//读完换行
                }
            }
        });

//        findViewById(R.id.btn_inquiry_cheak).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                MySQLiteAdapter adapter=new MySQLiteAdapter(getApplicationContext(),"database.db");
//                List<Infor> list=adapter.query();
//                Iterator<Infor> iter=list.iterator();//迭代器
//                tvDisplay.setText(null);//读取数据前清空上一次的数据
//                while(iter.hasNext()){//判断是否有下一条数据
//                    Infor infor=iter.next();//获取下一条数据，返回类型为list里的泛类
//                    //int id=infor.get_id();//从infor对象中读取值
//                    String name=infor.getName();
//                    String sex=infor.getSex();
//                    String degree=infor.getDegree();
//                    String course=infor.getCourse();
//                    Long num=infor.getNum();
//                    Long emile=infor.getEmile();
//                    Long phone=infor.getPhone();
//                   // tvDisplay.append(" id:"+String.valueOf(id));//追加
//                    tvDisplay.append("姓名："+name);
//                    tvDisplay.append("\n");
//                    tvDisplay.append("教师编号："+String.valueOf(num));
//                    tvDisplay.append("\n");
//                    tvDisplay.append("所教课程："+course);
//                    tvDisplay.append("\n");
//                    tvDisplay.append("学历："+degree);
//                    tvDisplay.append("\n");
//                    tvDisplay.append("性别："+sex);
//                    tvDisplay.append("\n");
//                    tvDisplay.append("手机号码："+String.valueOf(phone));
//                    tvDisplay.append("\n");
//                    tvDisplay.append("QQ号码："+String.valueOf(emile));
//                    tvDisplay.append("\n");//读完换行
//
//                }
//
//
//            }
//        });
    }
}
