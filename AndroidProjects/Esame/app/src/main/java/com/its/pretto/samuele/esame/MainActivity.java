package com.its.pretto.samuele.esame;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCamera, btnStorage, btnActivityB, btnActivityC, btnActivityD, btnActivityE;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnCamera = (Button) findViewById(R.id.buttonCamera);

        btnStorage = (Button) findViewById(R.id.buttonStorage);

        btnActivityB = (Button) findViewById(R.id.buttonActivityB);

        btnActivityC = (Button) findViewById(R.id.buttonActivityC);

        btnActivityD = (Button) findViewById(R.id.buttonActivityD);

        btnActivityE = (Button) findViewById(R.id.buttonActivityE);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.M){
                    requestPermissions(new String[]{Manifest.permission.CAMERA},001);
                }
            }
        });

        btnStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},002);
                }
            }
        });

        btnActivityB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,ActivityB.class);
                startActivity(intent);
            }
        });

        btnActivityC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,ActivityC.class);
                startActivity(intent);
            }
        });

        btnActivityD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,ActivityD.class);
                startActivity(intent);
            }
        });

        btnActivityE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,ActivityE.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==001){
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permessi di CAMERA accettati", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Permessi di CAMERA non accettati", Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode==002){
            if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permessi di scrittura STORAGE accettati", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Permissi di scrittura STORAGE non accettati", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
