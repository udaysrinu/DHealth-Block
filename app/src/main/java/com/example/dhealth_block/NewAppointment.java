package com.example.dhealth_block;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class    NewAppointment extends AppCompatActivity {

    FloatingActionButton newApt;
    TextView disease,doctor;

    private RecyclerView recyclerView;
    Bundle a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_appointment);

        disease=findViewById(R.id.diseasetxt);
        doctor=findViewById(R.id.doctortxt);

        a=getIntent().getExtras();
        doctor.setText(a.getString("doctor"));
        disease.setText(a.getString("disease"));
        newApt = findViewById(R.id.layout);
        newApt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        List<AppointmentClass> appointmentClassList = new ArrayList<>();

        recyclerView=findViewById(R.id.recycler);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

//        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
//        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
//        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
//        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
//        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
//        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
//        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
//        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
//        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
//        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
//        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
//        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
//        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"))
        appointmentClassList.add(new AppointmentClass(a.getString("date"),"High Fever, low bp, swelling in head"));
        Adapter adapter=new Adapter(appointmentClassList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}