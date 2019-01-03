package com.example.yt.teacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LogActivity extends AppCompatActivity {
    TextView tvname,tvid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        Intent intent=getIntent();
        String id=intent.getStringExtra("id");
        tvid=findViewById(R.id.tv_log_id);
        tvid.setText("编号:"+id);

    }
}
