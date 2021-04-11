package com.example.dhealth_block;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    TextView fullname,id,aadharno;

    public ProfileFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_profile, container, false);
        fullname=v.findViewById(R.id.fulnametxt);
        id=v.findViewById(R.id.idtxt);
        aadharno=v.findViewById(R.id.aadharnotxt);
        return v;
    }
}