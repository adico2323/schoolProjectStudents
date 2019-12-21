package com.example.myprojectgali;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends AppCompatActivity {
    SQLiteDatabase db;
    EditText et_su_UserName, et_su_subject, et_su_Pass1S;
    Button bt_signupS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        db = openOrCreateDatabase("appDB", MODE_PRIVATE, null);
        et_su_UserName = findViewById(R.id.et_su_UserName);
        et_su_subject = findViewById(R.id.et_su_subject);
        bt_signupS = findViewById(R.id.bt_signupS);
        et_su_Pass1S = findViewById(R.id.et_su_Pass1S);
        bt_signupS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_su_UserName.getText().toString();
                String subject = et_su_subject.getText().toString();
                String pass = et_su_Pass1S.getText().toString();
                db.execSQL("insert into teachers values('" + name + "', '" + subject + "', '" + pass + "')");
            }
        });

        List<Teacher> teachers = new ArrayList<>();
        Cursor c = db.rawQuery("select * from teachers", null);
        c.moveToFirst();
        while (c.moveToNext()) {
            teachers.add(new Teacher(c.getString(0), c.getString(1), c.getString(2)));
        }

    }
}
