package com.example.multiplechoicetests.monhoc;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.multiplechoicetests.R;

import java.util.ArrayList;

public class ExamJavaAdapter extends ArrayAdapter<ExamJava> {
    public ExamJavaAdapter(Context context, ArrayList<ExamJava> exam) {
        super(context, 0, exam);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_gridview, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.tvNumExam);
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.imgIcon);
        ExamJava p = getItem(position);
        if (p!=null){
            tvName.setText(""+p.getName());
            imgIcon.setImageResource(R.drawable.img_java);
        }

        return convertView;
    }
}
