package com.example.yt.teacher;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity  {
       EditText edtTxtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        edtTxtName=findViewById(R.id.edtTxt_delete_name);
        findViewById(R.id.btn_delete_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNameDialog();
            }
        });
        findViewById(R.id.btn_delete_clearall).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });


    }
    private void showDialog(){
        AlertDialog dialog;
        dialog=new AlertDialog.Builder(this).setTitle("提示")
                .setMessage("确定删除所有教师信息？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MySQLiteAdapter adapter=new MySQLiteAdapter(getApplicationContext(),"database.db");
                        adapter.deleteAll();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                })
                .create();
        dialog.show();
    }
    private void showNameDialog(){
        AlertDialog dialog=new AlertDialog.Builder(this).setTitle("提示")
                .setMessage("确定删除教师信息？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name=edtTxtName.getText().toString().trim();
                        MySQLiteAdapter adapter=new MySQLiteAdapter(getApplicationContext(),"database.db");
                        adapter.deleteByName(name);
                        edtTxtName.setText(null);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .create();
        dialog.show();
    }

}
