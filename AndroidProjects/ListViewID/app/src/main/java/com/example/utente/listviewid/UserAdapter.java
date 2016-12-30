package com.example.utente.listviewid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Utente on 31/03/2016.
 */
public class UserAdapter extends BaseAdapter {

    private ArrayList<User> ListUsers;
    private Context mContext;

    public UserAdapter(ArrayList<User> listUsers, Context mContext) {
        ListUsers = listUsers;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return ListUsers.size();
    }

    @Override
    public Object getItem(int i) {
        return ListUsers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return ListUsers.get(i).getID();
    }

    class ViewHolder{
        TextView mID;
        TextView mName;
        TextView mSurname;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater vInflater = LayoutInflater.from(mContext);
            view=vInflater.inflate(R.layout.id_detail,null);
            TextView vID= (TextView) view.findViewById(R.id.textViewID);
            TextView vNome= (TextView) view.findViewById(R.id.textViewName);
            TextView vCognome= (TextView) view.findViewById(R.id.textViewSurname);
            ViewHolder vHolder = new ViewHolder();
            vHolder.mID=vID;
            vHolder.mName=vNome;
            vHolder.mSurname=vCognome;
            view.setTag(vHolder);
        }
        User vUser= (User) getItem(i);
        ViewHolder vViewHolder= (ViewHolder) view.getTag();
        vViewHolder.mID.setText(Integer.toString(vUser.getID()));
        vViewHolder.mName.setText(vUser.getNome());
        vViewHolder.mSurname.setText(vUser.getCognome());
        return view;
    }
}
