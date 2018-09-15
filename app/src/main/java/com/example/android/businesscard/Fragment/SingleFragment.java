package com.example.android.businesscard.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.businesscard.Activity.FontActivity;
import com.example.android.businesscard.R;


public class SingleFragment extends Fragment {
    ImageView facrd, scard;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_single, container, false);
        facrd = view.findViewById(R.id.fcard);
        facrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FontActivity.class);
                intent.putExtra("value", "green");
                startActivity(intent);

            }
        });
        scard = view.findViewById(R.id.scard);
        scard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FontActivity.class);
                intent.putExtra("value", "red");
                startActivity(intent);
            }
        });
        return view;
    }

}
