package com.its.pretto.samuele.esame;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ActivityE extends AppCompatActivity {

    SQLiteDatabase vData;
    ContentValues values;
    ListView listViewPeople;
    String result;
    PersonAdapter personAdapter;
    ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e);

        listViewPeople = (ListView) findViewById(R.id.listPersonE);
        vData = new PersonDB(ActivityE.this).getReadableDatabase();
        MAsyncE mAsyncE = new MAsyncE();
        mAsyncE.setListener(ActivityE.this);
        mAsyncE.execute();
    }

    public class MAsyncE extends AsyncTask{

        public void setListener(ActivityE listener){
            this.listener = new WeakReference<ActivityE>(listener);
        }
        WeakReference<ActivityE>listener;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mDialog = new ProgressDialog(listener.get());
            mDialog.setMessage("Attendere prego");
            mDialog.show();
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            mDialog.dismiss();

        }

        @Override
        protected Object doInBackground(Object[] params) {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://tommo.altervista.org/ITS/get.php")
                    .get()
                    .build();

            try {
                Response response = client.newCall(request).execute();
                result = response.body().string();


            } catch (IOException e) {
                e.printStackTrace();
            }
            listener.get().setList(result);

            return null;
        }
    }

    public void setList(final String text){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                JSONArray jsonArray = null;
                try {
                    jsonArray = new JSONArray(text);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ArrayList<Person> listPerson = new ArrayList<Person>();
                for (int i=0; i<jsonArray.length();i++){
                    try {
                        values = new ContentValues();
                        JSONObject object = jsonArray.getJSONObject(i);
                        values.put(PersonTableHelper.NAME,object.getString("name"));
                        values.put(PersonTableHelper.SURNAME,object.getString("surname"));
                        vData.insert(PersonTableHelper.TABLE_NAME,null,values);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Cursor vCursor = vData.query(PersonTableHelper.TABLE_NAME, new String[]{PersonTableHelper._ID,PersonTableHelper.NAME,PersonTableHelper.SURNAME},null,null,null,null,null);
                int vIndexId = vCursor.getColumnIndex(PersonTableHelper._ID);
                int vIndexName = vCursor.getColumnIndex(PersonTableHelper.NAME);
                int vIndexSurname = vCursor.getColumnIndex(PersonTableHelper.SURNAME);
                ArrayList<Person> vPeople = new ArrayList<>();
                while (vCursor.moveToNext()){
                    Person vPerson = new Person();
                    vPerson.set_id(vCursor.getInt(vIndexId));
                    vPerson.setName(vCursor.getString(vIndexName));
                    vPerson.setSurname(vCursor.getString(vIndexSurname));
                    vPeople.add(vPerson);
                }
                vData.close();
                PersonAdapter vAdapter = new PersonAdapter(ActivityE.this,vPeople);
                listViewPeople.setAdapter(vAdapter);
            }
        });
    }
}
