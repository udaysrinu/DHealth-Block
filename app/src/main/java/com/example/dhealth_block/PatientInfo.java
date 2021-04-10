package com.example.dhealth_block;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PatientInfo extends AppCompatActivity {

    Button submitbtn;
    EditText address,fullname,aadhar,privateKey;
    PatientClass patientClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);

     address=findViewById(R.id.addressedttxt);
        fullname=findViewById(R.id.fullnameedtxt);
        aadhar=findViewById(R.id.aadharedttxt);
        privateKey=findViewById(R.id.privateKey);
        submitbtn = findViewById(R.id.submitbtn);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addr=address.getText().toString();
                String full=fullname.getText().toString();
                String aadharno=aadhar.getText().toString();
                String privateKeystr=privateKey.getText().toString();
                patientClass=new PatientClass(full,aadharno,"asdf",addr);
                DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("User");
                ref.child("Patient").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(patientClass);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }
}