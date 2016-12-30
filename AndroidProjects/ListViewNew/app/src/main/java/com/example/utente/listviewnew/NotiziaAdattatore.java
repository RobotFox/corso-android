package com.example.utente.listviewnew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Utente on 24/03/2016.
 */
public class NotiziaAdattatore extends BaseAdapter {
    private ArrayList<notizia> mObjects;
    private Context mContetx;

    public NotiziaAdattatore(Context aContetx,ArrayList<notizia> aObject){
        mContetx=aContetx;
        mObjects=aObject;
    }

    @Override
    public int getCount() {
        return mObjects.size();
    }

    @Override
    public Object getItem(int i) {
        return mObjects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mObjects.get(i).getmId();
    }

    class ViewHolder{
        TextView mTitolo;
        TextView mCorpo;
        TextView mImmagine;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater vInflater = LayoutInflater.from(mContetx);
            view=vInflater.inflate(R.layout.celle_layout,null);
            TextView vTitolo= (TextView) view.findViewById(R.id.textViewTitolo);
            TextView vImmagine= (TextView) view.findViewById(R.id.textViewImmagine);
            TextView vCorpo= (TextView) view.findViewById(R.id.textViewCorpo);
            ViewHolder vHolder = new ViewHolder();
            vHolder.mImmagine=vImmagine;
            vHolder.mCorpo=vCorpo;
            vHolder.mTitolo=vTitolo;
            view.setTag(vHolder);
        }
        notizia vNotizia= (notizia) getItem(i);
        ViewHolder vViewHolder= (ViewHolder) view.getTag();
        vViewHolder.mTitolo.setText(vNotizia.getmTitolo());
        vViewHolder.mImmagine.setText(vNotizia.getmCorpo());
        vViewHolder.mCorpo.setText(vNotizia.getmCorpo());
        return view;
    }
}
