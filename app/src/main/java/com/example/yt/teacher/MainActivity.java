package com.example.yt.teacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtTxtId,edtTxtPassword;
    Button btnLand,btnRegister,btnLand2;


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
                Intent intent=new Intent(MainActivity.this,LogActivity.class);
                intent.putExtra("id",edtTxtId.getText().toString().trim());
                startActivity(intent);
            }
        });

    }

    private void intUI() {
        edtTxtId=findViewById(R.id.edtTxt_main_id);
        edtTxtPassword=findViewById(R.id.edtTxt_main_password);
        btnLand=findViewById(R.id.btn_main_land);
        btnLand2=findViewById(R.id.btn_main_land2);
        btnRegister=findViewById(R.id.btn_main_register);
    }
}
