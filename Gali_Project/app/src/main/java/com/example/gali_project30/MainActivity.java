package com.example.gali_project30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et_UserName,et_Pass;
    Button bt_login, bt_sighup;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_UserName=findViewById(R.id.et_UserName);
        et_Pass=findViewById(R.id.et_Pass);
        bt_login=findViewById(R.id.bt_login);
        bt_sighup=findViewById(R.id.bt_signup);

        buildTables();
        if(!checkInitTables()) {
            initTables();
        }

        bt_sighup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), SighUpActivity.class);
                startActivity(myIntent);
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                db = openOrCreateDatabase("schoolDB", MODE_PRIVATE, null);
                Cursor cursor = db.rawQuery("select * from tbl_student", null);
                String name = et_UserName.getText().toString();
                String pass = et_Pass.getText().toString();
                boolean isExist = false;

                while(cursor.moveToNext())
                {
                    String tmpName = cursor.getString(0);
                    String tmpPass = cursor.getString(1);

                    if (name.compareTo(tmpName) == 0 && pass.compareTo(tmpPass) == 0)
                        isExist = true;
                }

                if(isExist) {
                    Intent myIntent = new Intent(getBaseContext(), TeacherListActivity.class);
                    startActivity(myIntent);
                } else {
                    Intent myIntent = new Intent(getBaseContext(), SighUpActivity.class);
                    startActivity(myIntent);
                }
            }
        });
    }

    private void buildTables() {
        db = openOrCreateDatabase("schoolDB", MODE_PRIVATE, null);
        db.execSQL("create table if not exists  tbl_student(name text, pass text) ");
        db.execSQL("create table if not exists  tbl_teacher(name text, subject text) ");
    }

    private void initTables() {
        db = openOrCreateDatabase("schoolDB", MODE_PRIVATE, null);
        Student s1 = new Student("albert", "albert");
        String studentPass = "albert";
        Teacher t1 = new Teacher("tami","math");

        db.execSQL("insert into tbl_student values('" + s1.getName() + "' , '" + studentPass +"')");
        db.execSQL("insert into tbl_teacher values('" + t1.getName() + "' , '" + t1.getSubject() +"')");
    }

    private boolean checkInitTables(){
        db = openOrCreateDatabase("schoolDB", MODE_PRIVATE, null);
        boolean tableHasData = false;
        Cursor cursor1 = db.rawQuery("select name from tbl_student", null);
        Cursor cursor2 = db.rawQuery("select name from tbl_teacher", null);

        while (cursor1.moveToNext())
        {
            tableHasData = true;
        }

        while (cursor2.moveToNext())
        {
            tableHasData = true;
        }

        return tableHasData;
    }
}
