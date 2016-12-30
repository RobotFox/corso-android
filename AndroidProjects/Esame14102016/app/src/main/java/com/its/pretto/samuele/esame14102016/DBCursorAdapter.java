package com.its.pretto.samuele.esame14102016;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Samuele.Pretto on 14/10/2016.
 */

public class DBCursorAdapter extends CursorAdapter {

    TextView txvId, txvDescription;


    public DBCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_row,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        txvId = (TextView) view.findViewById(R.id.textViewId);
        txvDescription = (TextView) view.findViewById(R.id.textViewDescription);

        txvId.setText(cursor.getString(cursor.getColumnIndex(DBTableHelper._ID)));
        txvDescription.setText(cursor.getString(cursor.getColumnIndex(DBTableHelper.DESCRIPTION)));
    }
}
