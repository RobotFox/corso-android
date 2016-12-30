package com.example.fulvio.sqllistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Fulvio on 01/04/2016.
 */
public class Adapter extends BaseAdapter { // extend BaseAdapter class
    protected ArrayList<User> mUsers;
    protected Context mContext;

    public Adapter(ArrayList<User> aUsers, Context aContext) {
        mUsers = aUsers;
        mContext = aContext;
    }

    class ViewHolder { // make ViewHolder class to map 1:1 layout's objects
        TextView mId;
        TextView mName;
        TextView mSurname;
    }

    @Override
    public int getCount() {
        return mUsers.size(); // return the objects number
    }

    @Override
    public Object getItem(int aPosition) {
        return mUsers.get(aPosition); // return the object at position aPosition
    }

    @Override
    public long getItemId(int aPosition) {
        return mUsers.get(aPosition).getmId(); // return the object's id at position aPosition
    }

    @Override
    public View getView(int aPosition, View aConvertView, ViewGroup aParent) {
        if (aConvertView == null) {
            LayoutInflater vInflater = LayoutInflater.from(mContext); // recover object of LayoutInflater sort using the context related to the activity
            aConvertView = vInflater.inflate(R.layout.user, null); // layout's inflate, similar to activity's setContentView
            TextView vId = (TextView) aConvertView.findViewById(R.id.txtId);
            TextView vName = (TextView) aConvertView.findViewById(R.id.txtName);
            TextView vSurname = (TextView) aConvertView.findViewById(R.id.txtSurname);
            ViewHolder vHolder = new ViewHolder(); // make ViewHolder object to link the 2 TextViews recovered
            vHolder.mId = vId;
            vHolder.mName = vName;
            vHolder.mSurname = vSurname;
            aConvertView.setTag(vHolder); // set the vHolder object as view's tag, to mustn't generate new everytime
        }

        User vUser = (User) getItem(aPosition); // recover the user at position aPosition
        ViewHolder vViewHolder = (ViewHolder) aConvertView.getTag(); // recover the ViewHolder object using the tag
        vViewHolder.mId.setText(Integer.toString(vUser.getmId())); // set the text into the TextView
        vViewHolder.mName.setText(vUser.getmName());
        vViewHolder.mSurname.setText(vUser.getmSurname());
        return aConvertView;
    }
}
