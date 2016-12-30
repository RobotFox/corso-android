package com.its.pretto.samuele.sqliteexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Samuele.Pretto on 21/10/2016.
 */

public class ItemAdapter extends BaseAdapter {

    Context mContext;

    ArrayList<Item> mItems;

    public ItemAdapter(Context aContext, ArrayList<Item> aItems){
        mContext = aContext;
        mItems = aItems;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mItems.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            LayoutInflater vInflater = LayoutInflater.from(mContext);
            convertView = vInflater.inflate(R.layout.cell_item,null);
            ViewHolder vViewHolder = new ViewHolder();
            vViewHolder.mNameView = (TextView) convertView.findViewById(R.id.textViewName);
            vViewHolder.mSurnameView = (TextView) convertView.findViewById(R.id.textViewSurname);
            convertView.setTag(vViewHolder);
        }

        Item vItem = (Item) getItem(position);
        ViewHolder vHolder = (ViewHolder) convertView.getTag();
        vHolder.mNameView.setText(vItem.getName());
        vHolder.mSurnameView.setText(vItem.getSurname());
        return convertView;
    }
}

class ViewHolder{
    TextView mNameView;
    TextView mSurnameView;

}
