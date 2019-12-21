package com.example.myprojectgali;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
public class Adapter_teacher extends ArrayAdapter<Teacher> {
    Context context;
    List<Teacher>TeacherList;
    public Adapter_teacher(Context context, List<Teacher>TeacherList)
    {
        super(context,0,TeacherList);
        this.context=context;
        this.TeacherList=TeacherList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      View row_teacher=convertView;
        row_teacher= LayoutInflater.from(context).inflate(R.layout.line_list,parent,false);
      Teacher temp_teacher=TeacherList.get(position);
        TextView name=row_teacher.findViewById(R.id.et_su_UserName);
        TextView subject=row_teacher.findViewById(R.id.et_su_subject);
        name.setText(temp_teacher.getName());
        subject.setText(temp_teacher.getSubject());
        return row_teacher;

    }
}
