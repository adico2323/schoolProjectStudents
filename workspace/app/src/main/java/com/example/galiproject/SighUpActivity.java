package com.example.galiproject;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SighUpActivity extends Activity {

    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sighup);

        final Button bt_sighup_student = findViewById(R.id.bt_sighup_student);
        bt_sighup_student.setOnClickListener(new View.OnClickListener() {
            EditText studentName = findViewById(R.id.et_UserName_sighup);
            EditText studentPass = findViewById(R.id.et_Pass_sighup);


            public void onClick(View v) {
                db = openOrCreateDatabase("schoolDB", MODE_PRIVATE, null);
                db.execSQL("insert into  tbl_student(name, pass)" +
                        "values ('"+studentName.getText().toString()+"','"+studentPass.getText().toString()+"')");

                Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(myIntent);
            }

        });

    }
}
