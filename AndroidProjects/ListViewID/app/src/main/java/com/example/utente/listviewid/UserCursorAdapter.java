package com.example.utente.listviewid;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Utente on 05/04/2016.
 */
public class UserCursorAdapter extends CursorAdapter {


    public UserCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    public UserCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.id_detail,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView vID = (TextView) view.findViewById(R.id.textViewID);
        TextView vName = (TextView) view.findViewById(R.id.textViewName);
        TextView vSurname = (TextView) view.findViewById(R.id.textViewSurname);

        vID.setText(cursor.getString(cursor.getColumnIndex(UserTableHelper._ID))+"");
        vName.setText(cursor.getString(cursor.getColumnIndex(UserTableHelper.NAME)));
        vSurname.setText(cursor.getString(cursor.getColumnIndex(UserTableHelper.SURNAME)));

    }
}
