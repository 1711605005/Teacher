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

public class InsertActivity extends AppCompatActivity {
    EditText edtTxtName,edtTxtNum,edtTxtCourse,edtTxtSex,edtTxtPhone,edtTxtDegree,edtTxtEmile;

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
                Long num=Long.valueOf(edtTxtNum.getText().toString().trim());
                Long phone=Long.valueOf(edtTxtPhone.getText().toString().trim());
                Long emile=Long.valueOf(edtTxtEmile.getText().toString().trim());
                MySQLiteAdapter adapter=new MySQLiteAdapter(getApplicationContext(),"database.db");
                Infor infor=new Infor();
                infor.setName(name);
                infor.setCourse(course);
                infor.setEmile(emile);
                infor.setDegree(degree);
                infor.setNum(num);
                infor.setPhone(phone);
                infor.setSex(sex);
                boolean result=adapter.insert(infor);
                if (result){
                    Toast.makeText(getApplicationContext(),"信息添加成功",Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }else{
                    Toast.makeText(getApplicationContext(),"信息添加失败",Toast.LENGTH_SHORT).show();

                }

          }
       });


    }
}
