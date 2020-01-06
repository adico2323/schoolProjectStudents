package com.example.gali_project30;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class TeacherListActivity extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_list);

        getTeacherList();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int num = item.getItemId();

        if(num==R.id.act_MyAccount)
        {
            Intent i = new Intent(this,MyAccountStudent.class);
            startActivity(i);
        }

        if(num==R.id.act_AddNewTeacher)
        {
           //add new teacher, como?
        }



        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private void getTeacherList()
    {
        db = openOrCreateDatabase("schoolDB", MODE_PRIVATE, null);
        Cursor cursor = db.rawQuery("select * from tbl_teacher", null);

        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();

        while (cursor.moveToNext()) {
            String teacherName = cursor.getString(0);
            String teacherGrade = cursor.getString(1);
            Teacher tmpProfession = new Teacher(teacherName, teacherGrade);
            teacherList.add(tmpProfession);
        }

        ArrayAdapter adapter;
        adapter = new ArrayAdapter<Teacher>(this,
                R.layout.line_list, teacherList);

        ListView listView = (ListView) findViewById(R.id.teacher_lst);
        listView.setAdapter(adapter);
    }
}
