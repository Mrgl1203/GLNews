package com.gulei.glnews.module.care.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gulei.glnews.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CareMainFragment extends Fragment {


    public CareMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_care_main, container, false);
    }

}
