package com.example.myprojectgali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    SQLiteDatabase db;
    ImageView intro_img;
    ProgressBar intro_pv;
    int progressStatus=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        intro_img = findViewById(R.id.intro_img);
        intro_pv=findViewById(R.id.intro_pv);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                while (progressStatus<200)
                {
                    progressStatus+=1;
                }
                // This method will be executed once the timer is over
                buildDataBase();
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },
        3000);
    }

    public void buildDataBase() {
        db = openOrCreateDatabase("appDB", MODE_PRIVATE, null);
        db.execSQL("create table if not exists teachers(name text)");
        db.execSQL("create table if not exists students(name text,pass,text)");
        db.execSQL("insert into teachers values('isaac newton', 'infi', 'apple123')");

        String Tname = "albert aistein";
        db.execSQL("insert into teachers values('Tname')");
        String Sname = "albert aistein";
        String Spass = "bigBoy891945";
        db.execSQL("insert into students values('"+Sname+"','"+Spass+"')");
    }
}
