package com.its.pretto.samuele.esame14102016;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ActivityB extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        listView = (ListView) findViewById(R.id.list);

        SQLiteDatabase database = new DBHelper(ActivityB.this).getReadableDatabase();
        Cursor cursor = database.query(DBTableHelper.TABLE_NAME, new String[]{DBTableHelper._ID,DBTableHelper.DESCRIPTION},null,null,null,null,
                DBTableHelper._ID);
        DBCursorAdapter adapter = new DBCursorAdapter(ActivityB.this, cursor);
        listView.setAdapter(adapter);
        database.close();

    }
}
