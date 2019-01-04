package com.example.yt.teacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LogActivity extends AppCompatActivity {
    TextView tvName,tvNum,tvCourse,tvPhone,tvSex,tvDegree,tvEmile;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
//        Intent intent=getIntent();
//        String num=intent.getStringExtra("num");
//        String name=intent.getStringExtra("name");
//        String course=intent.getStringExtra("course");
//        String phone=intent.getStringExtra("phone");
//        String sex=intent.getStringExtra("sex");
//        String degree=intent.getStringExtra("degree");
//        String e_mile=intent.getStringExtra("e_mile");
//
//        tvName=findViewById(R.id.tv_log_name);
//        tvNum=findViewById(R.id.tv_log_num);
//        tvCourse=findViewById( R.id.tv_log_course);
//        tvPhone=findViewById(R.id.tv_log_phone);
//        tvSex=findViewById(R.id.tv_log_sex);
//        tvDegree=findViewById(R.id.tv_log_degree);
//        tvEmile=findViewById(R.id.tv_log_e_mile);
//        btnUpdate=findViewById(R.id.btn_log_update);
//
//        tvName.setText("姓名："+name);
//        tvNum.setText("编号："+num);
//        tvCourse.setText("所教课程："+course);
//        tvPhone.setText("电话号码："+phone);
//        tvSex.setText("性别："+sex);
//        tvDegree.setText("学历："+degree);
//        tvEmile.setText("邮箱："+e_mile);
//
//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1=new Intent(LogActivity.this,InsertActivity.class);
//                startActivity(intent1);
//
//            }
//        });
    }
}
