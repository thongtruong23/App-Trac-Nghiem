package com.example.multiplechoicetests.monhoc;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.multiplechoicetests.MainActivity;
import com.example.multiplechoicetests.R;
import com.example.multiplechoicetests.slide.ScreenSlideActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CNPMFragment extends Fragment {
    ExamCNPMAdapter examCNPMAdapter;
    GridView gvExamCNPM;
    ArrayList<ExamCNPM> arr_exam = new ArrayList<ExamCNPM>();


    public CNPMFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Môn Công Nghệ Phần Mềm");
        return inflater.inflate(R.layout.fragment_cnpm, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gvExamCNPM = (GridView) getActivity().findViewById(R.id.gvExamCNPM);
        arr_exam.add(new ExamCNPM("Đề số 1"));
        arr_exam.add(new ExamCNPM("Đề số 2"));
        arr_exam.add(new ExamCNPM("Đề số 3"));
        arr_exam.add(new ExamCNPM("Đề số 4"));
        arr_exam.add(new ExamCNPM("Đề số 5"));
        arr_exam.add(new ExamCNPM("Đề số 6"));

        examCNPMAdapter = new ExamCNPMAdapter(getActivity(), arr_exam);
        gvExamCNPM.setAdapter(examCNPMAdapter);
        gvExamCNPM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(getActivity(), ScreenSlideActivity.class);
                intent.putExtra("num_exam",i+1);
                intent.putExtra("subject", "cnpm");
                intent.putExtra("text", "yes");
                startActivity(intent);
            }
        });
    }
}
