package com.example.dhealth_block;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                        startActivity(new Intent(getApplicationContext(), com.example.dhealth_block.LoginActivity.class));
                        finish();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.Frame_Layout,selectedFragment).commit();

                return true;
            }
        });
    }
}