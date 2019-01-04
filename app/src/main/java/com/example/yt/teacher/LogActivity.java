package com.example.yt.teacher;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvName,tvNum,tvCourse,tvPhone,tvSex,tvDegree,tvEmile;
    EditText edtTxtName,edtTxtNum,edtTxtCourse,edtTxtPhone,edtTxtSex,edtTxtDegree,edtTxtEmile;
    Button btnUpdate;
    MyHelper myHelper;
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
        edtTxtName=findViewById(R.id.edtTxt_log_name);
        edtTxtNum=findViewById(R.id.edtTxt_log_num);
        edtTxtCourse=findViewById( R.id.edtTxt_log_course);
        edtTxtPhone=findViewById(R.id.edtTxt_log_phone);
        edtTxtSex=findViewById(R.id.edtTxt_log_sex);
        edtTxtDegree=findViewById(R.id.edtTxt_log_degree);
        edtTxtEmile=findViewById(R.id.edtTxt_log_emile);
        btnUpdate=findViewById(R.id.btn_log_update);
        myHelper=new MyHelper(this);
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
        btnUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String name;
        String num;
        String course;
        String phone;
        String sex;
        String degree;
        String e_mile;
        SQLiteDatabase db;
        ContentValues values;
        db=myHelper.getWritableDatabase();
        values=new ContentValues();
        values.put("course",course=edtTxtCourse.getText().toString());
        values.put("phone",phone=edtTxtPhone.getText().toString());
        values.put("sex",sex=edtTxtSex.getText().toString());
        values.put("degree",degree=edtTxtDegree.getText().toString());
        values.put("e_mile",e_mile=edtTxtEmile.getText().toString());
        db.update("information",values,"name=?",new String[]{edtTxtName.getText().toString()});
        Toast.makeText(this,"信息已修改",Toast.LENGTH_SHORT).show();
        db.close();
    }
}
