package com.example.myprojectgali;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class techersList extends AppCompatActivity {
    List<Teacher> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techers_list);
        list= new ArrayList<Teacher>();
        Teacher t1=new Teacher()

    }

}
