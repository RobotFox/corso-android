package com.tommo.sqlite.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.tommo.sqlite.R;
import com.tommo.sqlite.data.UserTableHelper;

/**
 * Created by tommaso on 05/04/16.
 */
public class UserCursorAdapter extends CursorAdapter {

    public UserCursorAdapter(Context context, Cursor c) {//costruttore a cui passiamo context e cursor e poi chiama il super
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.cell_layout, viewGroup, false);//ritorniamo la view della singola cella
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView vTitolo = (TextView) view.findViewById(R.id.textTitolo);//mappo i 3 campi della singola view
        TextView vCorpo = (TextView) view.findViewById(R.id.textCorpo);
        TextView vId = (TextView) view.findViewById(R.id.textView);
        //tiriamo fuori i dati dal cursor e li mettiamo nella textview
        vTitolo.setText(cursor.getString(cursor.getColumnIndex(UserTableHelper.NAME)));
        vCorpo.setText(cursor.getString(cursor.getColumnIndex(UserTableHelper.SURNAME)));
        vId.setText(cursor.getInt(cursor.getColumnIndex(UserTableHelper._ID)) + "");
    }
}
