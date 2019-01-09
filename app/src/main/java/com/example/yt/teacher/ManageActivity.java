package com.example.yt.teacher;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManageActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtTxtCourse,edtTxtName;
    Button btnLand;
    TextView tvDisplay;
 //   MyHelper myHelper;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        edtTxtName=findViewById(R.id.edtTxt_manage_name);
        edtTxtCourse=findViewById(R.id.edtTxt_manage_course);
        btnLand=findViewById(R.id.btn_manage_land);
        tvDisplay=findViewById(R.id.tv_manage_display);

        btnLand.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String name=edtTxtName.getText().toString().trim();
       String course= String.valueOf(edtTxtCourse.getText().toString().trim());
        MySQLiteAdapter adapter=new MySQLiteAdapter(getApplicationContext(),"database.db");
        List<Infor> list=new ArrayList<>();
        if(!name.equals("")){
            if (!course.equals("")){
                list=adapter.queryNumCourse(name,course);
            }

//
//                 list=adapter.queryByCourse(course);
//        }else{
//            Toast.makeText(context,"请输入教师编号！",Toast.LENGTH_SHORT).show();

       }
        Iterator<Infor> iterator=list.iterator();
        tvDisplay.setText(null);
        while(iterator.hasNext()) {//判断是否有下一条数据
            Infor infor = iterator.next();//获取下一条数据，返回类型为list里的泛类
            tvDisplay.append("姓名：" + infor.getName() + "\n");
            tvDisplay.append("教师编号：" + String.valueOf(infor.getNum() + "\n"));
            tvDisplay.append("所教课程：" + infor.getCourse() + "\n");
            tvDisplay.append("学历：" + infor.getDegree() + "\n");
            tvDisplay.append("性别：" + infor.getSex() + "\n");
            tvDisplay.append("电话号码：" + String.valueOf(infor.getPhone() + "\n"));
            tvDisplay.append("QQ号码：" + String.valueOf(infor.getEmile() + "\n"));
            tvDisplay.append("\n");//读完换行
        }
    }
}





//        String name;
//        String num;
//        SQLiteDatabase db;
//        ContentValues values;
//        db=myHelper.getReadableDatabase();
//        Cursor cursor=db.query("teacher",null,null,null,null,null,null,null);
//        if (cursor.getCount()==0){
//            tvDisplay.setText("");
//            Toast.makeText(this,"没有数据",Toast.LENGTH_SHORT).show();
//        }else {
//            cursor.moveToFirst();
//            tvDisplay.setText(
//                    "姓名："+cursor.getString(1)+"n/"+cursor.getString(2)+
//                    "编号："+cursor.getString(3)+"n/"+cursor.getString(4)+
//                    "所教课程："+cursor.getString(5)+"n/"+cursor.getString(6)+
//                    "性别："+cursor.getString(7)+"n/"+cursor.getString(8)+
//                    "电话号码："+cursor.getString(9)+"n/"+cursor.getString(10)+
//                    "学历："+cursor.getString(11)+"n/"+cursor.getString(12)+
//                    "QQ号码："+cursor.getString(13)+"n/"+cursor.getString(14));
//        }
//        cursor.close();
//        db.close();


//        myHelper=new MyHelper(this,"database.db",null,1);

//        findViewById(R.id.btn_manage_land).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

//            }
//        });
//        btnland.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Long num= Long.valueOf(edtTxtNum.getText().toString().trim());
//                MySQLiteAdapter adapter=new MySQLiteAdapter(getApplicationContext(),"database.db");
//                List<Infor> list=new ArrayList<>();
//                if (!num.equals("")){
//                    list=adapter.queryByNum(num);
//                }
//
//                Iterator<Infor> iterator=list.iterator();
//                tvDisplay.setText(null);
//                while(iterator.hasNext()) {//判断是否有下一条数据
//                    Infor infor = iterator.next();//获取下一条数据，返回类型为list里的泛类
//                    tvDisplay.append("姓名：" + infor.getName() + "\n");
//                    tvDisplay.append("教师编号：" + String.valueOf(infor.getNum() + "\n"));
//                    tvDisplay.append("所教课程：" + infor.getCourse() + "\n");
//                    tvDisplay.append("学历：" + infor.getDegree() + "\n");
//                    tvDisplay.append("性别：" + infor.getSex() + "\n");
//                    tvDisplay.append("电话号码：" + String.valueOf(infor.getPhone() + "\n"));
//                    tvDisplay.append("QQ号码：" + String.valueOf(infor.getEmile() + "\n"));
//                    tvDisplay.append("\n");//读完换行
//                }
//            }
//        });
