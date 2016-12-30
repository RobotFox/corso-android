package com.example.utente.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Utente on 17/03/2016.
 */
public class NotiziaAdapter extends BaseAdapter {

    private ArrayList<notizia> mObjects;
    private Context mContetx;

    public NotiziaAdapter(Context aContetx,ArrayList<notizia> aObject){
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
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater vInflater = LayoutInflater.from(mContetx);
            view=vInflater.inflate(R.layout.cell_layout,null);
            TextView vTitolo= (TextView) view.findViewById(R.id.textTitolo);
            TextView vCorpo= (TextView) view.findViewById(R.id.textCorpo);
            ViewHolder vHolder = new ViewHolder();
            vHolder.mCorpo=vCorpo;
            vHolder.mTitolo=vTitolo;
            view.setTag(vHolder);
        }
        notizia vNotizia= (notizia) getItem(i);
        ViewHolder vViewHolder= (ViewHolder) view.getTag();
        vViewHolder.mTitolo.setText(vNotizia.getmTitolo());
        vViewHolder.mCorpo.setText(vNotizia.getmCorpo());
        return view;
    }
}
