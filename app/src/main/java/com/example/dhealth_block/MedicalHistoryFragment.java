package com.example.dhealth_block;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MedicalHistoryFragment extends Fragment {

    FloatingActionButton newTreatment;

    public MedicalHistoryFragment() {
        // Required empty public constructor
    }

  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        newTreatment =
        View v=inflater.inflate(R.layout.fragment_medical_history, container, false);
        newTreatment = v.findViewById(R.id.layout);
//        inflater.inflate(R.layout.fragment_medical_history, container, false);
        newTreatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), com.example.dhealth_block.NewTreatmentBegin.class));
            }
        });
        return v;
  }
}