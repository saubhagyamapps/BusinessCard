package com.example.android.businesscard.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.businesscard.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DoubleFragment extends Fragment {


    public DoubleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_double, container, false);
        return  view;
    }

}
