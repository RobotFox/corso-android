package com.its.pretto.samuele.esame11112016.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.its.pretto.samuele.esame11112016.R;

public class Activity2 extends AppCompatActivity {

    Button btnCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        btnCamera = (Button) findViewById(R.id.buttonCamera);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    requestPermissions(new String[]{Manifest.permission.CAMERA},007);
                }

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==007){
            if (ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permessi di CAMERA accettatti", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Permessi di CAMERA non accettatti", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
