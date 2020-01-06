package com.example.gali_project30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewTeacher extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_list);

        final Button addTeacher = findViewById(R.id.bt_add_teacher);
        addTeacher.setOnClickListener(new View.OnClickListener() {
            EditText name = (EditText) findViewById(R.id.add_teacher);
            EditText subject = (EditText) findViewById(R.id.add_subject);
            @Override
            public void onClick(View v) {
                String teacherName = name.getText().toString();
                String subjectName = subject.getText().toString();
                db = openOrCreateDatabase("schoolDB", MODE_PRIVATE, null);
                db.execSQL("insert into tbl_teacher(name, subject)" +
                           "values ('"+ teacherName +"','"+subjectName+"')");

                Intent myIntent = new Intent(getBaseContext(), TeacherListActivity.class);
                startActivity(myIntent);
            }
        });
    }
}


