package com.example.multiplechoicetests.monhoc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.multiplechoicetests.MainActivity;
import com.example.multiplechoicetests.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThongTinFragment extends Fragment {


    public ThongTinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Thông Tin Ứng Dụng");

        return inflater.inflate(R.layout.fragment_thong_tin, container, false);
    }

}
