package com.its.pretto.samuele.esame11112016.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.its.pretto.samuele.esame11112016.R;

import java.util.ArrayList;

/**
 * Created by Samuele.Pretto on 11/11/2016.
 */

public class ElementAdapter extends BaseAdapter {


    Context mContext;

    ArrayList<ElementItem> elementItems;

    public ElementAdapter(Context mContext, ArrayList<ElementItem> elementItems) {
        this.mContext = mContext;
        this.elementItems = elementItems;
    }

    @Override
    public int getCount() {
        return elementItems.size();
    }

    @Override
    public Object getItem(int position) {
        return elementItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return elementItems.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater vInflater = LayoutInflater.from(mContext);
            convertView = vInflater.inflate(R.layout.cell_element,null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.mDescription = (TextView) convertView.findViewById(R.id.textViewElement);
            convertView.setTag(viewHolder);
        }
        ElementItem elementItem = (ElementItem) getItem(position);
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.mDescription.setText(elementItem.getDescription());

        return convertView;
    }

    class ViewHolder{
        TextView mDescription;
    }
}
