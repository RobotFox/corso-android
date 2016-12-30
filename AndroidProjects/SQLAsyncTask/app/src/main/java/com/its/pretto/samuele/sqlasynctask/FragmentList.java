package com.its.pretto.samuele.sqlasynctask;

import android.app.Activity;
import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Samuele.Pretto on 21/10/2016.
 */

public class FragmentList extends Fragment {

    ArrayList<Item> mItems;

    ListView mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_list,container,false);
        mList = (ListView) mView.findViewById(R.id.list);





        return mView;
    }

    private class MyAsync extends AsyncTask{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mItems = new ArrayList<>();
            SQLiteDatabase vData = new ItemDB(getContext()).getReadableDatabase();
            Cursor vCursor = vData.query(ItemTableHelper.TABLE_NAME,new String[]{ItemTableHelper._ID,ItemTableHelper.DATA,ItemTableHelper.NUM},null,null,null,null,null);
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }

        @Override
        protected Object doInBackground(Object[] params) {

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://tommo.altervista.org/ITS/datalist.php")
                    .get()
                    .build();

            try {
                Response response = client.newCall(request).execute();
                JSONArray vJSONArray = new JSONArray(response.body().string());
                for (int i =0; i<vJSONArray.length();i++){
                    Item vItem = new Item();
                    vItem.setData(vJSONArray.getJSONObject(i).getString("data"));
                    vItem.setNum(vJSONArray.getJSONObject(i).getInt("num"));
                    mItems.add(vItem);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof listener){

        }
    }
}


