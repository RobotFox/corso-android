package com.its.pretto.samuele.esame11112016.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.its.pretto.samuele.esame11112016.database.ElementAdapter;
import com.its.pretto.samuele.esame11112016.database.ElementDB;
import com.its.pretto.samuele.esame11112016.database.ElementItem;
import com.its.pretto.samuele.esame11112016.database.ElementTableHelper;
import com.its.pretto.samuele.esame11112016.R;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        mListView = (ListView) findViewById(R.id.listView);

        SQLiteDatabase vData = new ElementDB(this).getReadableDatabase();
        Cursor vCursor = vData.query(ElementTableHelper.TABLE_NAME,null,null,null,null,null,null);
        int vIndexId = vCursor.getColumnIndex(ElementTableHelper._ID);
        int vIndexDescription = vCursor.getColumnIndex(ElementTableHelper.DESCRIPTION);
        ArrayList<ElementItem> vElements = new ArrayList<>();
        while (vCursor.moveToNext()){
            ElementItem vElement = new ElementItem();
            vElement.set_id(vCursor.getInt(vIndexId));
            vElement.setDescription(vCursor.getString(vIndexDescription));
            vElements.add(vElement);
        }
        vCursor.close();
        vData.close();
        ElementAdapter vAdapter = new ElementAdapter(this,vElements);
        mListView.setAdapter(vAdapter);
    }
}
