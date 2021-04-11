package com.example.dhealth_block;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.contracts.Testcontract;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import java8.util.concurrent.CompletableFuture;


public class MedicalHistoryFragment extends Fragment {

    FloatingActionButton newTreatment;
    private String idItem;
    private List<Disease> diseaseList;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
        //private OnFragmentInteractionListener mListener;
    private AdapterRecycler mAdaptador;
    private String userid;
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
        diseaseList.clear();
    // diseaseList.add(new Disease())
      getUID();
      mAdaptador.notifyDataSetChanged();
      Log.i("onCreateView","Fin");
        return v;
  }
    private void getUID(){
        DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("User").child("Patient");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userid=snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("id").getValue().toString();
                getData();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void getData(){
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
                    //testcontract.addPatientData(new BigInteger(userid),docstr,hosstr,new BigInteger(licstr),new BigInteger(datestr),diseasestr).sendAsync();
                        CompletableFuture<Tuple5<List<BigInteger>, List<String>, List<BigInteger>, List<BigInteger>, List<String>>> t=testcontract.getPatientData(new BigInteger(userid)).sendAsync();
                        Tuple5 c=t.get();
                        List<String> list2= (List<String>) c.getValue2();
                        List<BigInteger>list1= (List<BigInteger>) c.getValue1();
                        List<String>list5= (List<String>) c.getValue5();
                        List<BigInteger>list3= (List<BigInteger>) c.getValue3();
                        List<BigInteger>list4= (List<BigInteger>) c.getValue4();
                        for(int i=0;i<((List<BigInteger>) c.getValue1()).size();i++){
                            diseaseList.add(new Disease(list1.get(i),list2.get(i),list3.get(i),list4.get(i),list5.get(i)));

                            Toast.makeText(getContext(),"notify",Toast.LENGTH_LONG).show();
                        }
                        mAdaptador.notifyDataSetChanged();
                        Log.i("task", list2.get(0) );
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