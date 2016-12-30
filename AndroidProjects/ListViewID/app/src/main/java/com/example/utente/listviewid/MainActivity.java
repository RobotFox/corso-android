package com.example.utente.listviewid;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    Button bRefresh,bInsert;
    ArrayList<User> vUsers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listViewListID);
        bRefresh= (Button) findViewById(R.id.buttonRefresh);
        bInsert= (Button) findViewById(R.id.buttonInsert);

        //final ArrayList<User> vUsers = new ArrayList<>();

        SQLiteDatabase vData = new UsersDb(MainActivity.this).getReadableDatabase();

        Cursor vCursor = vData.query(UserTableHelper.TABLE_NAME, new String[]{UserTableHelper._ID, UserTableHelper.NAME, UserTableHelper.SURNAME}, null, null, null, null, null);
        /*if (vCursor.getCount()>0){
            int vNameIndex = vCursor.getColumnIndex(UserTableHelper.NAME);
            int vSurnameIndex = vCursor.getColumnIndex(UserTableHelper.SURNAME);
            int vIdIndex = vCursor.getColumnIndex(UserTableHelper._ID);


            while (vCursor.moveToNext()){
                vUsers.add(new User(vCursor.getString(vSurnameIndex),vCursor.getInt(vIdIndex),vCursor.getString(vNameIndex)));
            }
            vCursor.close();
            vData.close();
        }
        */

        UserCursorAdapter vAdapter= new UserCursorAdapter(MainActivity.this,vCursor);
        mListView.setAdapter(vAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });

        bInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vIntent = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(vIntent);
            }
        });

        bRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent refresh = new Intent(MainActivity.this,MainActivity.class);
                startActivity(refresh);
                finish();
            }
        });

    }
}