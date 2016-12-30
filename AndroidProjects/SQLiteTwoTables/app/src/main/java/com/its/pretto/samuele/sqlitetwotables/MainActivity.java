package com.its.pretto.samuele.sqlitetwotables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String totResult="";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase vDB = new DoubleDB(this).getReadableDatabase();
        Cursor vCursor = vDB.query(Table1Helper.TABLE_NAME,new String[]{Table1Helper._ID,Table1Helper.NAME,Table1Helper.SURNAME,Table1Helper.ID_DESCRIZIONE},null,null,null,null,null);
        while (vCursor.moveToNext()){
            String result = vCursor.getString(vCursor.getColumnIndex(Table1Helper.NAME))+vCursor.getString(vCursor.getColumnIndex(Table1Helper.SURNAME));
            Cursor vCursor2 = vDB.query(Table2Helper.TABLE_NAME, new String[]{Table2Helper.DESCRIPTION},Table2Helper._ID=vCursor.getInt(vCursor.getColumnIndex(Table1Helper.ID_DESCRIZIONE)),null,null,null,null);
            result += vCursor2.getString(vCursor2.getColumnIndex(Table2Helper.DESCRIPTION));
            totResult +=result+"\n";
            vCursor2.close();
        }
        vCursor.close();
        vDB.close();
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(totResult);

    }
}
