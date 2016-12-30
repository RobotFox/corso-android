package com.example.fulvio.sqllistview;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserNew extends AppCompatActivity {
    protected EditText mEditName, mEditSurname;
    protected Button mInsert;
    protected SQLiteDatabase mDataWritable;
    protected String mInputName, mInputSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_new);
        mEditName = (EditText) findViewById(R.id.editTxtName);
        mEditSurname = (EditText) findViewById(R.id.editTxtSurname);
        mInsert = (Button) findViewById(R.id.btnInsert);
        mDataWritable = new UserDB(UserNew.this).getWritableDatabase();

        mInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInputName = mEditName.getText().toString();
                mInputSurname = mEditSurname.getText().toString();
                ContentValues vValues = new ContentValues(); // container for the values to add
                vValues.put(UserTable.NAME, mInputName); // column's name and value
                vValues.put(UserTable.SURNAME, mInputSurname);
                mDataWritable.insertOrThrow(UserTable.TABLE_NAME, null, vValues); // insert using table's name, null (useless object) and values
                Intent vIntent = new Intent(UserNew.this, MainActivity.class);
                startActivity(vIntent);
                Toast.makeText(UserNew.this, "Nuovo utente inserito", Toast.LENGTH_SHORT).show(); // show the text notification
                mDataWritable.close();
                finish();
            }
        });

    }
}
