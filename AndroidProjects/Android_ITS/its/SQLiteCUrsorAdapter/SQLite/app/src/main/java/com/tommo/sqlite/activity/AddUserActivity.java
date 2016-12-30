package com.tommo.sqlite.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tommo.sqlite.R;
import com.tommo.sqlite.data.UserTableHelper;
import com.tommo.sqlite.data.UsersDb;

public class AddUserActivity extends AppCompatActivity {
    EditText mNameEdit, mSurnameEdit;
    Button mInsert;
    String mName, mSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        mNameEdit = (EditText) findViewById(R.id.editText);
        mSurnameEdit = (EditText) findViewById(R.id.editText2);
        mInsert = (Button) findViewById(R.id.button);
        mInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mName = mNameEdit.getText().toString();
                mSurname = mSurnameEdit.getText().toString();
                if (mName.length() > 0 && mSurname.length() > 0) {//controllo che siano state inserite delle stringhe nei campi di input
                    ContentValues vValues = new ContentValues();//creo un nuovo oggetto di tipo ContentValues che mi servirà per inserire i nuovi valori nella tabella
                    vValues.put(UserTableHelper.NAME, mName);//inserisco name
                    vValues.put(UserTableHelper.SURNAME, mSurname);//inserisco surname
                    SQLiteDatabase vData = new UsersDb(AddUserActivity.this).getWritableDatabase();//mi creo un oggetto database in scrittura
                    vData.insert(UserTableHelper.TABLE_NAME, null, vValues);//faccio l'insert di quello che ho salvato nel ContentValues nella tabella del database
                    vData.close();//chiudo la connessione al database
                    Toast.makeText(AddUserActivity.this, "USER INSERITO", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddUserActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(AddUserActivity.this, "USER NON INSERITO COMPLETA I CAMPI", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
