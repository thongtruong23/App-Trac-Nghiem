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
public class WebsiteFragment extends Fragment {
    ExamWebAdapter webAdapter;
    GridView gvExamWeb;
    ArrayList<ExamWeb> arr_exam = new ArrayList<ExamWeb>();


    public WebsiteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Môn Thiết Kế Website");
        return inflater.inflate(R.layout.fragment_websitefragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gvExamWeb = (GridView) getActivity().findViewById(R.id.gvExamWeb);
        arr_exam.add(new ExamWeb("Đề số 1"));
        arr_exam.add(new ExamWeb("Đề số 2"));
        arr_exam.add(new ExamWeb("Đề số 3"));
        arr_exam.add(new ExamWeb("Đề số 4"));
        arr_exam.add(new ExamWeb("Đề số 5"));
        arr_exam.add(new ExamWeb("Đề số 6"));

        webAdapter = new ExamWebAdapter(getActivity(), arr_exam);
        gvExamWeb.setAdapter(webAdapter);
        gvExamWeb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(getActivity(), ScreenSlideActivity.class);
                intent.putExtra("num_exam",i+1);
                intent.putExtra("subject", "web");
                intent.putExtra("text", "yes");
                startActivity(intent);
            }
        });
    }
}
