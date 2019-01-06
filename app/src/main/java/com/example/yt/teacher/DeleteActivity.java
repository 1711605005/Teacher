package com.example.yt.teacher;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener {
       EditText edtTxtName;
        Button btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        edtTxtName=findViewById(R.id.edtTxt_delete_name);
        btnClear=findViewById(R.id.btn_delete_clear);

        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name=edtTxtName.getText().toString().trim();
        MySQLiteAdapter adapter=new MySQLiteAdapter(getApplicationContext(),"database.db");
        adapter.deleteByName(name);

    }
}
