package com.its.pretto.samuele.ripassoesame;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityB extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        list = (ListView) findViewById(R.id.list);

        SQLiteDatabase sqLiteDatabase = new ItemDB(ActivityB.this).getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TableHelper.TABLE_NAME,new String[]{TableHelper._ID,TableHelper.DESCRIPTION},null,null,null,null,null,null);
        int indexId = cursor.getColumnIndex(TableHelper._ID);
        int indexDescription = cursor.getColumnIndex(TableHelper.DESCRIPTION);
        ArrayList<Item> items = new ArrayList<Item>();
        while (cursor.moveToNext()){
            Item item = new Item();
            item.setId(cursor.getInt(indexId));
            item.setDescription(cursor.getString(indexDescription));
            items.add(item);
        }
        cursor.close();
        sqLiteDatabase.close();
        ItemAdapter itemAdapter = new ItemAdapter(ActivityB.this,items);
        list.setAdapter(itemAdapter);
    }
}
