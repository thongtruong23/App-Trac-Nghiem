package com.example.multiplechoicetests.score;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.multiplechoicetests.question.DBHelper;
import com.example.multiplechoicetests.question.Question;

import java.util.ArrayList;

public class ScoreController {
    private DBHelper dbHelper;

    public ScoreController(Context context) {
        dbHelper = new DBHelper(context);
    }
    public void insertScore(String name, int score, String ghichu){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("score", score);
        values.put("ghichu", ghichu);
        db.insert("tbscore", null, values);
        db.close();
    }
//lấy ra ds điểm
    public Cursor getScore() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("tbscore",//tên bảng
                null, //danh sách cột cần lấy
                null, // điều kiện where
                null,// đối số điều kiện where
                null,//Biểu thức groupby
                null,//biểu thức having
                "_id DESC",//biểu thức orderby
                null
        );
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
}


