package com.example.yt.teacher;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener {
        TextView tvName,tvNum;
        Button btnClear;
        MyHelper myHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        myHelper=new MyHelper(this);
        tvName=findViewById(R.id.tv_delete_name);
        tvNum=findViewById(R.id.tv_delete_num);
        btnClear=findViewById(R.id.btn_delete_clear);

        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name;
        String num;
        SQLiteDatabase db;
        ContentValues values;
        db=myHelper.getWritableDatabase();
        db.delete("information",null,null);
        Toast.makeText(this,"已删除用户",Toast.LENGTH_SHORT).show();
        db.close();
    }
}
