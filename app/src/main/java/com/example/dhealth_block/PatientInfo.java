package com.example.dhealth_block;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contracts.Testcontract;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;

public class PatientInfo extends AppCompatActivity {

    Button submitbtn;
    EditText address,fullname,aadhar,privateKey;
    PatientClass patientClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);

        //address=findViewById(R.id.addressedttxt);
        fullname=findViewById(R.id.fullnameedtxt);
        aadhar=findViewById(R.id.aadharedttxt);
       // privateKey=findViewById(R.id.privateKey);
        submitbtn = findViewById(R.id.submitbtn);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //address.setText(R.string.walletaddress);
                String addr= String.valueOf(R.string.walletaddress);
                String full=fullname.getText().toString();
                String aadharno=aadhar.getText().toString();
               // privateKey.setText(R.string.privatekeyAshu);
                String privateKeystr=String.valueOf(R.string.privatekeyAshu);
                patientClass=new PatientClass(full,aadharno,privateKeystr,addr);
                Web3j web3 = Web3j.build(new HttpService("https://rpc-mumbai.matic.today/"));
        try {
            Web3ClientVersion clientVersion = web3.web3ClientVersion().sendAsync().get();
            if(!clientVersion.hasError()){
                Log.i("web3 req", clientVersion.getWeb3ClientVersion());
                BigInteger initialS = BigInteger.valueOf(100000);
                Testcontract testcontract  = Testcontract.load( "0x4855685BA961D546b3ccD74906003Ea4e360032e",web3, Credentials.create("fdceb2fd044f75e561763842a772ef70213ac7849b3a0d28907ac7d0919ef3ca"), new DefaultGasProvider());
                Log.i("web3 req","moving to try");
                try {
                    Log.i("web3 req","in try");

                    //Log.i("web3 req", testcontract.usingEmit().toString());
                    try{
                        BigInteger bigIntegerStr=new BigInteger(aadharno);
                        testcontract.createPatient(full,bigIntegerStr,privateKeystr).sendAsync();
                    }
                    catch(Exception e){
                        Log.i("web3 req", "onCreate: kajshdkjas");
                        e.printStackTrace();
                    }
                    //CompletableFuture<BigInteger> x=testcontract.get().sendAsync();

                    //Log.i("web3 req", String.valueOf(x.get()));
                Log.i("cvalue","updated here");
                Toast.makeText(getBaseContext(),"updated",Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            }
            else {
                Toast.makeText(getApplicationContext(),"wrong",Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e) {
            //Show Error
        }





                DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("User");
                ref.child("Patient").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(patientClass);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }
}