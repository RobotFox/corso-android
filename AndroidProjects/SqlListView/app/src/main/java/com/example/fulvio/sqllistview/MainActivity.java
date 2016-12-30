package com.example.fulvio.sqllistview;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    protected ListView mListView;
    protected Button mNew, mRefresh;
    protected ArrayList<User> mUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);
        mNew = (Button) findViewById(R.id.btnNew);
        mRefresh = (Button) findViewById(R.id.btnRefresh);

        mNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vIntent = new Intent(MainActivity.this, UserNew.class);
                startActivity(vIntent);
            }
        });

        mRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vRefresh = new Intent(MainActivity.this, MainActivity.class);
                startActivity(vRefresh);
                finish();
            }
        });

        SQLiteDatabase vData = new UserDB(MainActivity.this).getReadableDatabase(); // recover a readable database
        Cursor vCursor = vData.query(UserTable.TABLE_NAME, new String[]{UserTable._ID, UserTable.NAME, UserTable.SURNAME}, null, null, null, null, null);
        // make a query over the database. The query returns an object of cursor sort that has all the database's rows
        if (vCursor.getCount() > 0) { // check if a record exists
            int vIdIndex = vCursor.getColumnIndex(UserTable._ID); // from cursor recover all columns index
            int vNameIndex = vCursor.getColumnIndex(UserTable.NAME);
            int vSurnameIndex = vCursor.getColumnIndex(UserTable.SURNAME);
            mUsers = new ArrayList<>(); // make an ArrayList to save the data from database
            while (vCursor.moveToNext()) { // check that the cursor has a row to avoid the outOfBound
                mUsers.add(new User(vCursor.getInt(vIdIndex), vCursor.getString(vNameIndex), vCursor.getString(vSurnameIndex) /* return data from cursor */)); // make a user object to add to the ArrayList
            }
            vCursor.close();
            vData.close();

            Adapter vAdapter = new Adapter(mUsers, this); // make the Adapter's instance
            mListView.setAdapter(vAdapter); // link the adapter to the ListView
        }

    }
}
