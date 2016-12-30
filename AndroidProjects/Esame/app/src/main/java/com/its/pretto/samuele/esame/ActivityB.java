package com.its.pretto.samuele.esame;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityB extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        listView = (ListView) findViewById(R.id.listPerson);
        SQLiteDatabase vData = new PersonDB(ActivityB.this).getReadableDatabase();
        Cursor vCursor = vData.query(PersonTableHelper.TABLE_NAME, new String[]{PersonTableHelper._ID,PersonTableHelper.NAME,PersonTableHelper.SURNAME},null,null,null,null,null);
        int vIndexId = vCursor.getColumnIndex(PersonTableHelper._ID);
        int vIndexName = vCursor.getColumnIndex(PersonTableHelper.NAME);
        int vIndexSurname = vCursor.getColumnIndex(PersonTableHelper.SURNAME);
        ArrayList<Person> vPeople = new ArrayList<>();
        while (vCursor.moveToNext()){
            Person vPerson = new Person();
            vPerson.set_id(vCursor.getInt(vIndexId));
            vPerson.setName(vCursor.getString(vIndexName));
            vPerson.setSurname(vCursor.getString(vIndexSurname));
            vPeople.add(vPerson);
        }
        vCursor.close();
        vData.close();

        PersonAdapter vAdapter = new PersonAdapter(ActivityB.this,vPeople);
        listView.setAdapter(vAdapter);


    }
}
