package com.example.dhealth_block;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contracts.Testcontract;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;

public class NewTreatmentBegin extends AppCompatActivity {

    Button startbtn;
    EditText diseasename,docname,date,month,year,license,hospital;

    String diseasestr,docstr,datestr,licstr,hosstr,userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_treatment_begin);

        startbtn = findViewById(R.id.startbtn);

        diseasename=findViewById(R.id.DiseaseName);
        docname=findViewById(R.id.Doctorname);
        date=findViewById(R.id.date);
        month=findViewById(R.id.month);
        year=findViewById(R.id.year);
        license=findViewById(R.id.license);
        hospital=findViewById(R.id.hospital);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diseasestr=diseasename.getText().toString();
                docstr=docname.getText().toString();
                datestr=date.getText().toString()  + month.getText().toString() + year.getText().toString();
                licstr=license.getText().toString();
                hosstr=hospital.getText().toString();
                getUID();
//                uploadData();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }

    private void getUID(){
        DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("User").child("Patient");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userid=snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("id").getValue().toString();
                uploadData();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void uploadData(){
        Web3j web3 = Web3j.build(new HttpService("https://rpc-mumbai.matic.today/"));
        try {
            Web3ClientVersion clientVersion = web3.web3ClientVersion().sendAsync().get();
            if(!clientVersion.hasError()){
                Log.i("web3 req", clientVersion.getWeb3ClientVersion());
                BigInteger initialS = BigInteger.valueOf(100000);
                Testcontract testcontract  = Testcontract.load( "0x4fb7f07431Adc149651feF059a99f1326b023341",web3, Credentials.create("fdceb2fd044f75e561763842a772ef70213ac7849b3a0d28907ac7d0919ef3ca"), new DefaultGasProvider());
                Log.i("web3 req","moving to try");
//                try {
//                    Log.i("web3 req","in try");
//
//                    //Log.i("web3 req", testcontract.usingEmit().toString());
                try{
//                    BigInteger bigIntegerStr=new BigInteger(aadharno);
//                    testcontract.createPatient(full,bigIntegerStr,privateKeystr).sendAsync();
                        testcontract.addPatientData(new BigInteger(userid),docstr,hosstr,new BigInteger(licstr),new BigInteger(datestr),diseasestr).sendAsync();

                    // Log.i("value",.name);
                }
                catch(Exception e){
                    Log.i("web3 req", "onCreate: kajshdkjas");
                    e.printStackTrace();
                }
//                    //CompletableFuture<BigInteger> x=testcontract.get().sendAsync();
//
//                    //Log.i("web3 req", String.valueOf(x.get()));
//                    Log.i("cvalue","updated here");
//                    Toast.makeText(getBaseContext(),"updated",Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
            else {
                Toast.makeText(getApplicationContext(),"wrong",Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e) {
            //Show Error
        }
    }
}