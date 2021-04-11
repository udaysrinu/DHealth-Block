package com.example.dhealth_block;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

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
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;

import java8.util.concurrent.CompletableFuture;

public class ProfileFragment extends Fragment {

    TextView fullname,id,aadharno;
    String userid;
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
        DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("User").child("Patient");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userid=snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("id").getValue().toString();
                PatientData();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return v;
    }
    public void PatientData(){

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
                        BigInteger bigIntegerStr=new BigInteger(userid);
                       CompletableFuture<Tuple4<BigInteger, String, BigInteger, String>> t=testcontract.pMap(bigIntegerStr).sendAsync();
                       Tuple4 tuple=t.get();
                    fullname.setText((CharSequence) tuple.getValue2());
                     id.setText(String.valueOf(tuple.getValue1()));
                   aadharno.setText(String.valueOf( tuple.getValue3()));
                  Log.i("fgsdf", "hello");

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
                Toast.makeText(getContext(),"wrong",Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e) {
            //Show Error
        }
    }
}