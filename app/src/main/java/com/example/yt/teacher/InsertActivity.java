package com.example.yt.teacher;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    EditText edtTxtName,edtTxtNum,edtTxtCourse,edtTxtSex,edtTxtPhone,edtTxtDegree,edtTxtEmile;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        edtTxtName=findViewById(R.id.edt_insert_name);
        edtTxtNum=findViewById(R.id.edt_insert_num);
        edtTxtSex=findViewById(R.id.edt_insert_sex);
        edtTxtPhone=findViewById(R.id.edt_insert_phone);
        edtTxtEmile=findViewById(R.id.edt_insert_emile);
        edtTxtDegree=findViewById(R.id.edt_insert_degree);
        edtTxtCourse=findViewById(R.id.edt_insert_course);
        findViewById(R.id.btn_insert_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edtTxtName.getText().toString().trim();
                String degree=edtTxtDegree.getText().toString().trim();
                String sex=edtTxtSex.getText().toString().trim();
                String course=edtTxtCourse.getText().toString().trim();
                String num=edtTxtNum.getText().toString().trim();
                String phone=edtTxtPhone.getText().toString().trim();
                String emile=edtTxtEmile.getText().toString().trim();
                if (name.length()==0){
                    Toast.makeText(InsertActivity.this,"姓名不能为空！",Toast.LENGTH_SHORT).show();
                }else if (num.length()==0) {
                    Toast.makeText(InsertActivity.this, "教师编号不能为空！", Toast.LENGTH_SHORT).show();
                }else if (course.length()==0) {
                    Toast.makeText(InsertActivity.this, "所教课程不能为空！", Toast.LENGTH_SHORT).show();
                }else if (sex.length()==0) {
                    Toast.makeText(InsertActivity.this, "性别不能为空！", Toast.LENGTH_SHORT).show();
                }else if (phone.length()==0) {
                    Toast.makeText(InsertActivity.this,"电话号码不能为空！", Toast.LENGTH_SHORT).show();
                }else if (degree.length()==0) {
                    Toast.makeText(InsertActivity.this,"学历不能为空！", Toast.LENGTH_SHORT).show();
                }else if (emile.length()==0) {
                    Toast.makeText(InsertActivity.this, "QQ号码不能为空！", Toast.LENGTH_SHORT).show();
                }else {
                    MySQLiteAdapter adapter = new MySQLiteAdapter(getApplicationContext(), "database.db");
                    Infor infor = new Infor();
                    infor.setName(name);
                    infor.setCourse(course);
                    infor.setEmile(emile);
                    infor.setDegree(degree);
                    infor.setNum(num);
                    infor.setPhone(phone);
                    infor.setSex(sex);
                    boolean result = adapter.insert(infor);
                    if (result) {
                        Toast.makeText(getApplicationContext(), "信息添加成功", Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    } else {
                        Toast.makeText(getApplicationContext(), "信息添加失败", Toast.LENGTH_SHORT).show();

                    }
                }
          }
       });


    }
}
