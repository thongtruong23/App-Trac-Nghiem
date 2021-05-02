package com.example.multiplechoicetests.question;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.multiplechoicetests.R;

public class QuestionAdapter extends CursorAdapter {
    public QuestionAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_question, parent, false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvQues = (TextView) view.findViewById(R.id.tvSearchQuestion);
        LinearLayout linQues = (LinearLayout)view.findViewById(R.id.linQuestion);
        if (cursor.getPosition()%2==0){
            linQues.setBackgroundColor(Color.parseColor("#FFFAFAFA"));
        }else  linQues.setBackgroundColor(Color.parseColor("#FFFFFF"));


        tvQues.setText(cursor.getString(1));

    }
}