package com.example.utente.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mButton;
    EditText mUsername,mPassword;
    String mUsernameText,mPasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (this.getIntent().getExtras()!=null){
            Bundle vBundle=this.getIntent().getExtras();
            mUsernameText=vBundle.getString("USERNAME");
            mPasswordText=vBundle.getString("PASSWORD");
            Log.d("DATA",mUsernameText+"/"+mPasswordText);
        }
        mButton= (Button)findViewById(R.id.button);
        mUsername=(EditText)findViewById(R.id.editTextuser);
        mPassword=(EditText)findViewById(R.id.editTextpassword);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUsername.getText().toString().equals("tom") && mPassword.getText().toString().equals("tom")) {
                    Toast.makeText(MainActivity.this, "hai inserito i dati giusti", Toast.LENGTH_LONG).show();
                    Log.d("LOG", "ok hai inserito i dati giusti");
                    Intent vIntent = new Intent(MainActivity.this, MainActivityCorrect.class);
                    Bundle vBundle = new Bundle();
                    vBundle.putString("USERNAME", mUsername.getText().toString());
                    vBundle.putString("PASSWORD", mPassword.getText().toString());
                    vIntent.putExtras(vBundle);
                    startActivity(vIntent);
                    finish();
                } else {
                    Log.d("LOG", "ok hai inserito i dati sbagliati");
                }
            }
        });

    }
}
