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

    EditText edtTxtName,edtTxtNum,edtTxtCourse,edtTxtPhone,edtTxtSex,edtTxtDegree,edtTxtEmile;
    Button btnUpdate;
    MyHelper myHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        edtTxtName=findViewById(R.id.edtTxt_log_name);
        edtTxtNum=findViewById(R.id.edtTxt_log_num);
        edtTxtCourse=findViewById( R.id.edtTxt_log_course);
        edtTxtPhone=findViewById(R.id.edtTxt_log_phone);
        edtTxtSex=findViewById(R.id.edtTxt_log_sex);
        edtTxtDegree=findViewById(R.id.edtTxt_log_degree);
        edtTxtEmile=findViewById(R.id.edtTxt_log_emile);
        btnUpdate=findViewById(R.id.btn_log_update);
        myHelper=new MyHelper(this,"database.db",null,1);

        btnUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String name=edtTxtName.getText().toString().trim();
        String degree=edtTxtDegree.getText().toString().trim();
        String sex=edtTxtSex.getText().toString().trim();
        String course=edtTxtCourse.getText().toString().trim();
        String num=edtTxtNum.getText().toString().trim();
        String phone=edtTxtPhone.getText().toString().trim();
        String emile=edtTxtEmile.getText().toString().trim();
        Infor infor=new Infor();
        infor.setName(name);
        infor.setSex(sex);
        infor.setNum(num);
        infor.setDegree(degree);
        infor.setEmile(emile);
        infor.setCourse(course);
        infor.setPhone(phone);
        MySQLiteAdapter adapter=new MySQLiteAdapter(getApplicationContext(),"database.db");
        adapter.update(infor);
        onBackPressed();
    }
}
