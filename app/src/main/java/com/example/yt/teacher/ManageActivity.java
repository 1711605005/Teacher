package com.example.yt.teacher;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManageActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtTxtCourse,edtTxtName;
    Button btnland;
    TextView tvDisplay;
    MyHelper myHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        edtTxtName=findViewById(R.id.edtTxt_manage_name);
        edtTxtCourse=findViewById(R.id.edtTxt_manage_course);
        btnland=findViewById(R.id.btn_manage_land);
        tvDisplay=findViewById(R.id.tv_manage_display);
        btnland.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       String name=edtTxtName.getText().toString().trim() ;
       String course=String.valueOf(edtTxtCourse.getText().toString().trim());
       MySQLiteAdapter adapter=new MySQLiteAdapter(getApplicationContext(),"database.db");
        List<Infor> list=new ArrayList<>();
        if (!name.equals("")) {
            if (!course.equals("")) {
                list = adapter.queryNumCourse(name, course);
            }
        }
            Iterator<Infor> iterable=list.iterator();
            tvDisplay.setText(null);
            while (iterable.hasNext()){
                Infor infor=iterable.next();
                tvDisplay.append("姓名："+infor.getName()+"\n");
                tvDisplay.append("教师编号："+String.valueOf(infor.getNum())+"\n");
                tvDisplay.append("所教课程："+infor.getCourse()+"\n");
                tvDisplay.append("学历："+infor.getDegree()+"\n");
                tvDisplay.append("性别："+infor.getSex()+"\n");
                tvDisplay.append("电话号码："+String.valueOf(infor.getPhone())+"\n");
                tvDisplay.append("QQ号码："+String.valueOf(infor.getEmile())+"\n");
                tvDisplay.append("\n");
            }

    }
}
