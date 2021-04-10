package com.example.dhealth_block;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    Button sendbtn,verifybtn;
    EditText phnumberedttxt,otpedttxt;

    String mverificationId;

    CardView sendotp,verifyotp;

    FirebaseAuth mauth;
    FirebaseDatabase database;
    DatabaseReference ref;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    PhoneAuthProvider.ForceResendingToken mResendToken;

    RadioGroup usertype;
    RadioButton userRBtn;
    int f=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        phnumberedttxt = findViewById(R.id.phoneNumberEdtTxt);
        otpedttxt = findViewById(R.id.otpEditTxt);

        sendbtn = findViewById(R.id.otpSendBtn);
        verifybtn = findViewById(R.id.otpVerifyBtn);

        sendotp = findViewById(R.id.SendOtpSec);
        verifyotp = findViewById(R.id.verifyOtpSec);

        mauth=FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("User");

        usertype = findViewById(R.id.userType);

        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectdId= usertype.getCheckedRadioButtonId();
                userRBtn = findViewById(selectdId);

                if(userRBtn==null){
                    Toast.makeText(getApplicationContext(),"Please Select The User Type",Toast.LENGTH_SHORT).show();
                }
                else {

                    if(selectdId==R.id.patient){
                        f=0;
                    }
                    else{
                        f=1;
                    }

                    verifyotp.setVisibility(View.VISIBLE);
                    sendotp.setVisibility(View.INVISIBLE);
                    String phoneNumber = "+91" + phnumberedttxt.getText().toString();
                    if(phnumberedttxt.getText().toString().length()==10){
                        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(mauth)
                                .setPhoneNumber(phoneNumber)       // Phone number to verify
                                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                .setActivity(com.example.dhealth_block.LoginActivity.this)                 // Activity (for callback binding)
                                .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                                .build();
                        PhoneAuthProvider.verifyPhoneNumber(options);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Please Enter a valid phone number",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        verifybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),PatientInfo.class));

                verifybtn.setEnabled(false);
                String otp=otpedttxt.getText().toString();
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mverificationId, otp);
                signInWithPhoneAuthCredential(credential);
            }
        });


        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {
                signInWithPhoneAuthCredential(credential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {

                if (e instanceof FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                    verifyotp.setVisibility(View.INVISIBLE);
                    sendotp.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Invalid request",Toast.LENGTH_SHORT).show();
                } else if (e instanceof FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                    verifyotp.setVisibility(View.INVISIBLE);
                    sendotp.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Too many logins",Toast.LENGTH_SHORT).show();
                }

                // Show a message and update the UI
            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                mverificationId = verificationId;
                mResendToken = token;
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            patientcheck();
//            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }

    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mauth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            if(f==0){
//                                startActivity(new Intent(getApplicationContext(),PatientInfo.class));
                                patientcheck();
                            }else{
//                                startActivity(new Intent(getApplicationContext(),DoctorInfo.class));
                                doctorcheck();
                            }

//                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                            }
                        }
                    }
                });
    }

    private void patientcheck(){
        DatabaseReference mref=FirebaseDatabase.getInstance().getReference("User");
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.child("Patient").exists() && snapshot.child("Patient").child(FirebaseAuth.getInstance().getCurrentUser().toString()).exists()){
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
                else{
                    startActivity(new Intent(getApplicationContext(),PatientInfo.class));
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void doctorcheck(){
        DatabaseReference mref=FirebaseDatabase.getInstance().getReference("User");
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.child("Doctor").exists() && snapshot.child("Doctor").child(FirebaseAuth.getInstance().getCurrentUser().toString()).exists()){
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
                else{
//                    ref.child("Patient").child(FirebaseAuth.getInstance().getCurrentUser().toString()).setValue("1");
                    startActivity(new Intent(getApplicationContext(),PatientInfo.class));
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}