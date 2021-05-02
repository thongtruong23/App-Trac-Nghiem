package com.example.multiplechoicetests.slide;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.multiplechoicetests.R;
import com.example.multiplechoicetests.question.Question;
import com.example.multiplechoicetests.score.ScoreController;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;

public class TestDoneActivity extends AppCompatActivity {

    ArrayList<Question> arr_QuesBegin = new ArrayList<Question>();
    int numNoAns = 0;
    int numTrue = 0;
    int numFalse = 0;
    int totalScore = 0;
    ScoreController scoreController;

    TextView tvTrue, tvFalse, tvNotAns, tvTotalScore;
    Button btnSaveScore, btnAgain, btnEixt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_done);

        scoreController = new ScoreController(TestDoneActivity.this);

        Intent intent = getIntent();
        arr_QuesBegin = (ArrayList<Question>) intent.getExtras().getSerializable("arr_Ques");
        begin();
        CheckResult();
        totalScore = numTrue * 10;
        tvNotAns.setText("" + numNoAns);
        tvTrue.setText("" + numTrue);
        tvFalse.setText("" + numFalse);
        tvTotalScore.setText("" + totalScore);

        btnEixt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TestDoneActivity.this);
                builder.setIcon(R.drawable.exit);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát hay không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });

        btnSaveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TestDoneActivity.this);
                LayoutInflater inflater = TestDoneActivity.this.getLayoutInflater();
                View view = inflater.inflate(R.layout.alert_dialog_save_score, null);

                builder.setView(view);
                final EditText edtName = (EditText) view.findViewById(R.id.edtName);
                final EditText edtGhichu = (EditText) view.findViewById(R.id.edtGhichu);
                TextView tvDiem = (TextView) view.findViewById(R.id.tvDiem);
                final int numTotal = numTrue * 10;
                tvDiem.setText(numTotal + "điểm");


                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = edtName.getText().toString();
                        String ghichu = edtGhichu.getText().toString();
                        scoreController.insertScore(name, numTotal, ghichu);
                        Toast.makeText(TestDoneActivity.this, "Lưu điểm thành công", Toast.LENGTH_SHORT).show();
                        finish();
                        dialog.dismiss();


                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       finish();
                    }

                });
                AlertDialog b = builder.create();
                b.show();

            }
        });
        btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refesh();
                finish();
                Intent intent2 = new Intent(TestDoneActivity.this, ScreenSlideActivity.class);
                intent2.putExtra("arr_Ques", arr_QuesBegin);
                intent2.putExtra("text", "no");
                startActivity(intent2);

            }
            public  void refesh(){
                for (int i = 0; i<arr_QuesBegin.size();i++){
                    arr_QuesBegin.get(i).setTraloi("");
                }
            }
        });
    }

    public void begin() {
        tvFalse = (TextView) findViewById(R.id.tvFalse);
        tvTrue = (TextView) findViewById(R.id.tvTrue);
        tvNotAns = (TextView) findViewById(R.id.tvNotAns);
        btnAgain = (Button) findViewById(R.id.btnAgain);
        btnSaveScore = (Button) findViewById(R.id.btnSaveScore);
        tvTotalScore = (TextView) findViewById(R.id.tvTotalPoint);
        btnEixt = (Button) findViewById(R.id.btnExit);
    }

    //phương thức check kết quả
    public void CheckResult() {
        for (int i = 0; i < arr_QuesBegin.size(); i++) {
            if (arr_QuesBegin.get(i).getTraloi().equals("") == true) {
                numNoAns++;
            } else if (arr_QuesBegin.get(i).getResult().equals(arr_QuesBegin.get(i).getTraloi()) == true) {
                numTrue++;
            } else numFalse++;
        }
    }
}
