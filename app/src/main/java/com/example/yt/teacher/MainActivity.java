package com.example.yt.teacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class  MainActivity extends AppCompatActivity {
    Button btnLand;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intUI();
        btnLand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passDate();
            }

            private void passDate() {
                Intent intent=new Intent(MainActivity.this,ManageActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_main_manage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    private void intUI() {
        btnLand=findViewById(R.id.btn_main_land);
    }
}
