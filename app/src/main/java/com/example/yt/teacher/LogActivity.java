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

    EditText edtTxtName, edtTxtNum, edtTxtCourse, edtTxtPhone, edtTxtSex, edtTxtDegree, edtTxtEmile;
    Button btnUpdate;
    MyHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        edtTxtName = findViewById(R.id.edtTxt_log_name);
        edtTxtNum = findViewById(R.id.edtTxt_log_num);
        edtTxtCourse = findViewById(R.id.edtTxt_log_course);
        edtTxtPhone = findViewById(R.id.edtTxt_log_phone);
        edtTxtSex = findViewById(R.id.edtTxt_log_sex);
        edtTxtDegree = findViewById(R.id.edtTxt_log_degree);
        edtTxtEmile = findViewById(R.id.edtTxt_log_emile);
        btnUpdate = findViewById(R.id.btn_log_update);
        myHelper = new MyHelper(this, "database.db", null, 1);

        btnUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String name = edtTxtName.getText().toString().trim();
        String degree = edtTxtDegree.getText().toString().trim();
        String sex = edtTxtSex.getText().toString().trim();
        String course = edtTxtCourse.getText().toString().trim();
        String num = edtTxtNum.getText().toString().trim();
        String phone = edtTxtPhone.getText().toString().trim();
        String emile = edtTxtEmile.getText().toString().trim();
        if (name.length() == 0) {
            Toast.makeText(LogActivity.this, "姓名不能为空！", Toast.LENGTH_SHORT).show();
        } else if (num.length() == 0) {
            Toast.makeText(LogActivity.this, "教师编号不能为空！", Toast.LENGTH_SHORT).show();
        } else if (course.length() == 0) {
            Toast.makeText(LogActivity.this, "所教课程不能为空！", Toast.LENGTH_SHORT).show();
        } else if (sex.length() == 0) {
            Toast.makeText(LogActivity.this, "性别不能为空！", Toast.LENGTH_SHORT).show();
        } else if (phone.length() == 0) {
            Toast.makeText(LogActivity.this, "电话号码不能为空！", Toast.LENGTH_SHORT).show();
        } else if (degree.length() == 0) {
            Toast.makeText(LogActivity.this, "学历不能为空！", Toast.LENGTH_SHORT).show();
        } else if (emile.length() == 0) {
            Toast.makeText(LogActivity.this, "QQ号码不能为空！", Toast.LENGTH_SHORT).show();
        } else {
            Infor infor = new Infor();
            infor.setName(name);
            infor.setSex(sex);
            infor.setNum(num);
            infor.setDegree(degree);
            infor.setEmile(emile);
            infor.setCourse(course);
            infor.setPhone(phone);
            MySQLiteAdapter adapter = new MySQLiteAdapter(getApplicationContext(), "database.db");
            adapter.update(infor);
            onBackPressed();
        }
    }
}