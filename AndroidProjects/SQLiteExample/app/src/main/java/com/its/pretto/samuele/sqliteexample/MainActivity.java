package com.its.pretto.samuele.sqliteexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mListItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListItems = (ListView) findViewById(R.id.list);
        SQLiteDatabase vData = new ItemDB(MainActivity.this).getReadableDatabase();
        Cursor vCursor = vData.query(ItemTableHelper.TABLE_NAME, new String[]{ItemTableHelper._ID, ItemTableHelper.NAME, ItemTableHelper.SURNAME},null,null,null,null,null);
        int vIndexName = vCursor.getColumnIndex(ItemTableHelper.NAME);
        int vIndexSurname = vCursor.getColumnIndex(ItemTableHelper.SURNAME);
        int vIndexId = vCursor.getColumnIndex(ItemTableHelper._ID);
        ArrayList<Item> vItems = new ArrayList<>();
        while (vCursor.moveToNext()){
            Item vItem = new Item();
            vItem.set_id(vCursor.getInt(vIndexId));
            vItem.setName(vCursor.getString(vIndexName));
            vItem.setSurname(vCursor.getString(vIndexSurname));
            vItems.add(vItem);
        }
        vCursor.close();
        vData.close();

        ItemAdapter vAdapter = new ItemAdapter(MainActivity.this,vItems);
        mListItems.setAdapter(vAdapter);
    }
}
