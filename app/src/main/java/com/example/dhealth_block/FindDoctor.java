package com.example.dhealth_block;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class FindDoctor extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationProviderClient;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    Double lat,lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        getUserLocation();
    }

    private void getUserLocation(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if(getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if(location!=null){
                            lat=location.getLatitude();
                            lon=location.getLongitude();
                            Toast.makeText(getApplicationContext(),lat.toString()+" "+lon.toString(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
            else{
                requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE_ASK_PERMISSIONS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    getLocation();
                    getUserLocation();
                } else {
                    // Permission Denied
                    Toast.makeText( this,"your message" , Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        }
    }
}