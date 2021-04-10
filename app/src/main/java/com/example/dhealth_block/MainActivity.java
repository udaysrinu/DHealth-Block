package com.example.dhealth_block;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

//import org.web3j.crypto.Credentials;
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.core.methods.response.TransactionReceipt;
//import org.web3j.protocol.http.HttpService;
//import org.web3j.tx.gas.DefaultGasProvider;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);
//        Web3j web3j = Web3j.build(new HttpService("<your_node_url>"));
//        TransactionReceipt greeting;
//        Testcontract testcontract  = Testcontract.load("your_contract_address", web3j, Credentials.create("your_private_key"), new DefaultGasProvider());

//        try {
//           testcontract.set((BigInteger.TEN)).send();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        web3j.shutdown();

        getSupportFragmentManager().beginTransaction().replace(R.id.Frame_Layout,new ProfileFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()){
                    case R.id.profile:
                        selectedFragment=new ProfileFragment();
                        break;
                    case R.id.medHis:
                        selectedFragment=new MedicalHistoryFragment();
                        break;
                    case R.id.logout:
//                        startActivity(new Intent(getApplicationContext(), com.example.dhealth_block.LoginActivity.class));
                        FirebaseAuth.getInstance().signOut();
                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
//                        finish();
                        break;
                }
                if(selectedFragment!=null)
                getSupportFragmentManager().beginTransaction().replace(R.id.Frame_Layout,selectedFragment).commit();
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.findDoc:
                startActivity(new Intent(getApplicationContext(),FindDoctor.class));
                break;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),"Just Chill",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

}