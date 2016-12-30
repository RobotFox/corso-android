package com.tommo.sqlite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tommo.sqlite.R;
import com.tommo.sqlite.model.User;

import java.util.ArrayList;

/**
 * Created by tommaso on 01/04/16.
 */
public class UserAdapter extends BaseAdapter/*estendo
la classe BaseAdapter ed implemento i suoi metodi astratti*/ {

    private ArrayList<User> mObjects;
    private Context mContext;

    public UserAdapter(Context aContext, ArrayList<User> aObjects) {
        mContext = aContext;
        mObjects = aObjects;
    }


    @Override
    public int getCount() {
        return mObjects.size();//ritorno il numero do oggetti
    }

    @Override
    public Object getItem(int i) {//
        return mObjects.get(i);//ritorno l'oggetto in posizione i
    }

    @Override
    public long getItemId(int i) {
        return mObjects.get(i).getmId();//ritorno l'id dell'oggetto in posizione i
    }

    class ViewHolder {//creo una classe ViewHolder che mappi 1 :1 gli oggetti presenti nel layout
        TextView mName;
        TextView mSurname;
        TextView mId;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater vInflater = LayoutInflater.from(mContext);//recupero l'oggetto di tipo LayoutInflater grazie al context riferito all'activity
            view = vInflater.inflate(R.layout.cell_layout, null);//faccio l'inflate del layout che è come fare il setContentView dell'activity
            TextView vTitolo = (TextView) view.findViewById(R.id.textTitolo);
            TextView vCorpo = (TextView) view.findViewById(R.id.textCorpo);
            TextView vId = (TextView) view.findViewById(R.id.textView);
            ViewHolder vHolder = new ViewHolder();//creo un oggetto di tipo ViewHolder a cui associo le 2 TextView che ho recuperato
            vHolder.mSurname = vCorpo;
            vHolder.mName = vTitolo;
            vHolder.mId = vId;
            view.setTag(vHolder);//setto come tag della view l'oggetto vHolder in modo che non mi serva ricrearlo ogni volta
        }
        User vUser = (User) getItem(i);//tramite il metodo getItem recuperiamo la notizia nella posizione i
        ViewHolder vViewHolder = (ViewHolder) view.getTag();//recuperiamo dalla view tramite getTag il nostro oggetto ViewHolder creato in precedenza
        vViewHolder.mName.setText(vUser.getmName());
        vViewHolder.mSurname.setText(vUser.getmSurname());//setto il testo nelle 2 textview
        vViewHolder.mId.setText(vUser.getmId() + "");
        return view;
    }
}
