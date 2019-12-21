package com.example.galiproject;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TeacherListActivity extends Activity {

    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_list);

        getTeacherList();
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
