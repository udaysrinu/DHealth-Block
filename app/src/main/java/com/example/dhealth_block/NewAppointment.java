package com.example.dhealth_block;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class NewAppointment extends AppCompatActivity {

    FloatingActionButton newApt;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_appointment);


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

        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));
        appointmentClassList.add(new AppointmentClass("19","01","2021","sdgfbisdfdfb sjdfjs  sdf ks fd","Paracetamol asdfs sdf sdf asdfdf adf ","Very prograssive","Nothing much"));

        Adapter adapter=new Adapter(appointmentClassList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}