package com.example.yt.teacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InsertActivity extends AppCompatActivity {
    EditText edtTxtName,edtTxtNum,edtTxtCourse,edtTxtSex,edtTxtPhone,edtTxtDegree,edtTxtEmidle;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        intUi();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passDate();
            }

            private void passDate() {
                Intent intent=new Intent(InsertActivity.this,LogActivity.class);
                intent.putExtra("name",edtTxtName.getText().toString().trim());
                intent.putExtra("num",edtTxtNum.getText().toString().trim());
                intent.putExtra("course",edtTxtCourse.getText().toString().trim());
                intent.putExtra("sex",edtTxtSex.getText().toString().trim());
                intent.putExtra("phone",edtTxtPhone.getText().toString().trim());
                intent.putExtra("degree",edtTxtDegree.getText().toString().trim());
                intent.putExtra("e_mile",edtTxtEmidle.getText().toString().trim());
                startActivity(intent);
            }
        });

    }

    private void intUi() {
        edtTxtName=findViewById(R.id.edt_insert_name);
        edtTxtNum=findViewById(R.id.edt_insert_num);
        edtTxtCourse=findViewById(R.id.edt_insert_course);
        edtTxtSex=findViewById(R.id.edt_insert_sex);
        edtTxtPhone=findViewById(R.id.edt_insert_phone);
        edtTxtDegree=findViewById(R.id.edt_insert_degree);
        edtTxtEmidle=findViewById(R.id.edt_insert_e_mile);
        btnSave=findViewById(R.id.btn_insert_save);
    }
}
