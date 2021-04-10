package com.example.dhealth_block;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MedicalHistoryFragment extends Fragment {

    FloatingActionButton newTreatment;
    private String idItem;
    private List<Disease> diseaseList;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
        //private OnFragmentInteractionListener mListener;
    private AdapterRecycler mAdaptador;
    public MedicalHistoryFragment() {

    }

  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        newTreatment =
        View v=inflater.inflate(R.layout.fragment_medical_history, container, false);
        newTreatment = v.findViewById(R.id.fab);
//        inflater.inflate(R.layout.fragment_medical_history, container, false);
        newTreatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), com.example.dhealth_block.NewTreatmentBegin.class));
            }
        });
      RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
      diseaseList=new ArrayList<>();
      mAdaptador = new AdapterRecycler(diseaseList);

      recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
      recyclerView.setLayoutManager(mLayoutManager);
      recyclerView.setItemAnimator(new DefaultItemAnimator());
      recyclerView.addItemDecoration(new DividerItemDecoration(v.getContext(), LinearLayoutManager.VERTICAL));
      recyclerView.setAdapter(mAdaptador);
      diseaseList.add(new Disease("asfgsdf","asdfasdf","dsfkj","asdfnufv","sdfn eur","sdfnunnvie","fesbgiweu"));
      diseaseList.add(new Disease("asfgsdf","asdfasdf","dsfkj","asdfnufv","sdfn eur","sdfnunnvie","fesbgiweu"));
      diseaseList.add(new Disease("asfgsdf","asdfasdf","dsfkj","asdfnufv","sdfn eur","sdfnunnvie","fesbgiweu"));
      diseaseList.add(new Disease("asfgsdf","asdfasdf","dsfkj","asdfnufv","sdfn eur","sdfnunnvie","fesbgiweu"));
      diseaseList.add(new Disease("asfgsdf","asdfasdf","dsfkj","asdfnufv","sdfn eur","sdfnunnvie","fesbgiweu"));
      diseaseList.add(new Disease("asfgsdf","asdfasdf","dsfkj","asdfnufv","sdfn eur","sdfnunnvie","fesbgiweu"));
      diseaseList.add(new Disease("asfgsdf","asdfasdf","dsfkj","asdfnufv","sdfn eur","sdfnunnvie","fesbgiweu"));
      diseaseList.add(new Disease("asfgsdf","asdfasdf","dsfkj","asdfnufv","sdfn eur","sdfnunnvie","fesbgiweu"));
      mAdaptador.notifyDataSetChanged();
      Log.i("onCreateView","Fin");
        return v;
  }

}