package com.example.gali_project30;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyAccountStudent extends AppCompatActivity {

    TextView name,pass;
    Student s1;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account_student);

        setup_student();
        printStudentData();
    }

    private void setup_student() {
        SharedPreferences settings = getApplicationContext().getSharedPreferences("userAccount", 0);
        String name = settings.getString("name", "0");
        db = openOrCreateDatabase("schoolDB", MODE_PRIVATE, null);
        Cursor cursor = db.rawQuery("select * from tbl_student where name='"+name+"'", null);

        String tmpName, tmpPass;
        if (cursor.moveToNext()) {
            tmpName = cursor.getString(0);
            tmpPass = cursor.getString(1);
            s1 = new Student(tmpName,tmpPass);
        }
    }

    private void printStudentData(){
        name = findViewById(R.id.student_name);
        pass = findViewById(R.id.student_pass);
        name.setText("name: " + s1.getName());
        pass.setText("password: " + s1.getPass());
    }
}
