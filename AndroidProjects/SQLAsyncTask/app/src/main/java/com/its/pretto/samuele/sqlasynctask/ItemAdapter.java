package com.its.pretto.samuele.sqlasynctask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samuele.Pretto on 21/10/2016.
 */

public class ItemAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<Item> mItems;

    public ItemAdapter(Context mContext, ArrayList<Item> mItems) {
        this.mContext = mContext;
        this.mItems = mItems;
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
        return mItems.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            LayoutInflater vInflater = LayoutInflater.from(mContext);
            convertView =vInflater.inflate(R.layout.item_layout,null);
            ViewHolder vViewHolder = new ViewHolder();
            vViewHolder.mDataView = (TextView) convertView.findViewById(R.id.textViewData);
            vViewHolder.mNumView = (TextView) convertView.findViewById(R.id.textViewNum);
            convertView.setTag(vViewHolder);
        }

        Item vItem = (Item) getItem(position);
        ViewHolder vHolder = (ViewHolder) convertView.getTag();
        vHolder.mDataView.setText(vItem.getData());
        vHolder.mNumView.setText(Integer.toString(vItem.getNum()));
        return convertView;
    }
}

class ViewHolder{
    TextView mDataView;
    TextView mNumView;
}