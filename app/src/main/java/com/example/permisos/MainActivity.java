package com.example.permisos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.Manifest;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 200;
    private Button checkPermissions;
    private Button cameraPermission;
    private Button microphonePermission;
    private Button locationPermission;
    private TextView tvCamera;
    private TextView tvLocation;
    private TextView tvMicrophone;

    private String camera = "";
    private String location = "";
    private String microphone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtons();
        checkPermissions.setOnClickListener(this::verificarPermisos);
        cameraPermission.setOnClickListener(this::setCameraPermission);
        locationPermission.setOnClickListener(this::setLocationPermission);
        microphonePermission.setOnClickListener(this::setMicrophonePermission);
    }

    private void verificarPermisos(View view){
        int verifyCameraPermission = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA);
        int verifyLocationPermission = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION);
        int verifyMicrophonePermission = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO);
        if(verifyCameraPermission == 0 ){
            camera = "Enable";
        }else {
            camera = "Disable";
        }
        if(verifyLocationPermission == 0 ){
            location = "Enable";
        }else {
            location = "Disable";
        }
        if(verifyMicrophonePermission == 0 ){
            microphone = "Enable";
        }else {
            microphone = "Disable";
        }

        tvCamera.setText("Camera permission is "+camera);
        tvLocation.setText("Location permission is "+location);
        tvMicrophone.setText("Microphone permission is "+microphone);
        cameraPermission.setEnabled(true);
        locationPermission.setEnabled(true);
        microphonePermission.setEnabled(true);
    }

    public void setCameraPermission(View view){
        if(ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.CAMERA}, REQUEST_CODE);
        }
    }

    public void setLocationPermission(View view){
        if(ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_CODE);
        }
    }

    public void setMicrophonePermission(View view){
        if(ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.RECORD_AUDIO)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.RECORD_AUDIO}, REQUEST_CODE);
        }
    }


    private void initButtons(){
        checkPermissions =findViewById(R.id.btnCheck);
        cameraPermission =findViewById(R.id.btnCamera);
        locationPermission = findViewById(R.id.btnPermisoLocation);
        microphonePermission = findViewById(R.id.btnPermisoMicro);
        tvCamera = findViewById(R.id.tvPermiso1);
        tvLocation = findViewById(R.id.tvPermiso2);
        tvMicrophone = findViewById(R.id.tvPermiso3);
        cameraPermission.setEnabled(false);
        locationPermission.setEnabled(false);
        microphonePermission.setEnabled(false);
    }

}