package com.example.doctorarea;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.dhealth_block.R;

public class DocprofileInfo extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
//        View view=
        return inflater.inflate(R.layout.doctorprofileinfo, container, false);
    }
}
