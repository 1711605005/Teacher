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

public class ManageActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtTxtNum,edtTxtName;
    Button btnland;
    TextView tvDisplay;
    MyHelper myHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        edtTxtName=findViewById(R.id.edtTxt_manage_name);
        edtTxtNum=findViewById(R.id.edtTxt_manage_num);
        btnland=findViewById(R.id.btn_manage_land);
        myHelper=new MyHelper(this,"database.db",null,1);

        btnland.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name;
        String num;
        SQLiteDatabase db;
        ContentValues values;
        db=myHelper.getReadableDatabase();
        Cursor cursor=db.query("teacher",null,null,null,null,null,null,null);
        if (cursor.getCount()==0){
            tvDisplay.setText("");
            Toast.makeText(this,"没有数据",Toast.LENGTH_SHORT).show();
        }else {
            cursor.moveToFirst();
            tvDisplay.setText(
                    "姓名："+cursor.getString(1)+"n/"+cursor.getString(2)+
                    "编号："+cursor.getString(3)+"n/"+cursor.getString(4)+
                    "所教课程："+cursor.getString(5)+"n/"+cursor.getString(6)+
                    "性别："+cursor.getString(7)+"n/"+cursor.getString(8)+
                    "电话号码："+cursor.getString(9)+"n/"+cursor.getString(10)+
                    "学历："+cursor.getString(11)+"n/"+cursor.getString(12)+
                    "QQ号码："+cursor.getString(13)+"n/"+cursor.getString(14));
        }
        cursor.close();
        db.close();
    }
}
