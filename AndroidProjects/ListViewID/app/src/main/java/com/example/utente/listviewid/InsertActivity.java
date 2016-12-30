package com.example.utente.listviewid;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class InsertActivity extends AppCompatActivity {

    EditText eName, eSurname;
    Button bOk;
    SQLiteDatabase vData;
    String iName;
    String iSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        eName = (EditText) findViewById(R.id.editTextName);
        eSurname = (EditText) findViewById(R.id.editTextSurname);
        bOk= (Button) findViewById(R.id.buttonOk);
        vData = new UsersDb(InsertActivity.this).getWritableDatabase();;



        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vIntent = new Intent(InsertActivity.this, MainActivity.class);
                ContentValues vValues= new ContentValues();
                if (eName.length()>0&&eSurname.length()>0){
                    iName = eName.getText().toString();
                    iSurname = eSurname.getText().toString();
                    vValues.put(UserTableHelper.NAME,iName);
                    vValues.put(UserTableHelper.SURNAME,iSurname);
                    vData.insertOrThrow(UserTableHelper.TABLE_NAME, null, vValues);
                    startActivity(vIntent);
                    vData.close();
                    finish();
                }
                else {
                    Toast.makeText(InsertActivity.this,"The name and surname fields are empty!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    }