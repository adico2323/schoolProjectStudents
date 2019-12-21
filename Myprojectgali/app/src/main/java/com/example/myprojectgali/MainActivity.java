package com.example.myprojectgali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.time.Instant;

public abstract class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText et_UserName,et_Pass;
Button bt_login,bt_signup;
RadioButton rb_Teacher,rb_Student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_UserName=findViewById(R.id.et_UserName);
        et_Pass=findViewById(R.id.et_Pass);
        bt_login=findViewById(R.id.bt_login);
        bt_signup=findViewById(R.id.bt_signupS);
        //rb_Teacher=findViewById(R.id.rb_Teacher);
        //rb_Student=findViewById(R.id.rb_Student);
        bt_signup.setOnClickListener(this);
        bt_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view== bt_signup)
            startActivity(new Intent(this,SignUp.class));
        if (view==bt_login && rb_Student.isChecked())
            startActivity(new Intent(this,techersList.class));
        if (view==bt_login&&rb_Teacher.isChecked())
           startActivity(new Intent(this,techersList.class));
    }
}
