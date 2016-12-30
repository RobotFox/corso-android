package com.its.pretto.samuele.esame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Samuele.Pretto on 25/10/2016.
 */

public class PersonAdapter extends BaseAdapter {

    Context mContext;

    ArrayList<Person> mPeople;

    public PersonAdapter(Context mContext, ArrayList<Person> mPeople) {
        this.mContext = mContext;
        this.mPeople = mPeople;
    }

    @Override
    public int getCount() {
        return mPeople.size();
    }

    @Override
    public Object getItem(int position) {
        return mPeople.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mPeople.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater vInflater = LayoutInflater.from(mContext);
            convertView = vInflater.inflate(R.layout.celld,null);
            ViewHolder vHolder = (ViewHolder) new ViewHolder();
            vHolder.mNameView = (TextView) convertView.findViewById(R.id.textViewName);
            vHolder.mSurnameView = (TextView) convertView.findViewById(R.id.textViewSurname);
            convertView.setTag(vHolder);
        }

        Person person = (Person) getItem(position);
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.mNameView.setText(person.getName());
        viewHolder.mSurnameView.setText(person.getSurname());
        return convertView;
    }

    class ViewHolder{
        TextView mNameView;
        TextView mSurnameView;
    }
}
