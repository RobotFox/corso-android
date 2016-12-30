package com.its.pretto.samuele.ripassoesame;

import android.Manifest;
import android.annotation.TargetApi;
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

    Button btnCamera, btnStorage, btnActivityB, btnActivityC, btnActivityD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamera = (Button) findViewById(R.id.buttonCamera);
        btnStorage = (Button) findViewById(R.id.buttonStorage);
        btnActivityB = (Button) findViewById(R.id.buttonActivityB);
        btnActivityC = (Button) findViewById(R.id.buttonActivityC);
        btnActivityD = (Button) findViewById(R.id.buttonActivityD);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, 001);
                }
            }
        });

        btnStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 002);
                }
            }
        });

        btnActivityD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ActivityD.class);
                startActivity(intent);
            }
        });

    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 001) {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this, "Permesso CAMERA accettato", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Permesso CAMERA non accettato", Toast.LENGTH_SHORT).show();
            }

        } else if (requestCode == 002) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this, "Permesso STORAGE accettato", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Permesso STORAGE non accettato", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
