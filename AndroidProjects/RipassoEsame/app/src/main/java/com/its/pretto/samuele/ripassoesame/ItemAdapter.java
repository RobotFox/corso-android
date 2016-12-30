package com.its.pretto.samuele.ripassoesame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Samuele.Pretto on 18/10/2016.
 */

public class ItemAdapter extends BaseAdapter {

    private class ViewHolder{
        TextView textDescription;
    }

    private ArrayList<Item> itemArrayList;
    private Context context;

    public ItemAdapter(Context context, ArrayList<Item> itemArrayList) {
        this.context = context;
        this.itemArrayList = itemArrayList;
    }

    @Override
    public int getCount() {
        return itemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return itemArrayList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView ==null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.cell_layout,null);
            TextView txtView = (TextView) convertView.findViewById(R.id.textViewDescription);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.textDescription = txtView;
            convertView.setTag(viewHolder);
        }
        Item item = (Item) getItem(position);
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.textDescription.setText(item.getDescription());

        return null;
    }
}