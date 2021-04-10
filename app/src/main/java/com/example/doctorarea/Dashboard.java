package com.example.doctorarea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.dhealth_block.FindDoctor;
import com.example.dhealth_block.LoginActivity;
import com.example.dhealth_block.MedicalHistoryFragment;
import com.example.dhealth_block.ProfileFragment;
import com.example.dhealth_block.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomNavigationView = findViewById(R.id.bottom_nav);
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
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
//                        finish();
                        break;
                }
                if(selectedFragment!=null)
                    getSupportFragmentManager().beginTransaction().replace(R.id.Frame_Layout,selectedFragment).commit();
                return true;
            }
        });
    }

}