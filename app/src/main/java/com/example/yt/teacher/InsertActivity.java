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
                String name,degree,course,sex;
                Long num,phone,emile;
                SQLiteDatabase db;
                ContentValues values;
                switch (v.getId()){
                    case R.id.btn_insert_save:
                        name=edtTxtName.getText().toString();
                        degree=edtTxtDegree.getText().toString();
                        course=edtTxtCourse.getText().toString();
                        sex=edtTxtSex.getText().toString();


                }

            }
        });

    }
}
