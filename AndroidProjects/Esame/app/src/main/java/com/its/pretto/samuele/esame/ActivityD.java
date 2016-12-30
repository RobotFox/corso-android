package com.its.pretto.samuele.esame;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ActivityD extends AppCompatActivity {

    String result;
    ListView listView;
    PersonAdapter mPersonAdapter;
    ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        listView = (ListView) findViewById(R.id.list);
        MyAsync myAsync = new MyAsync();
        myAsync.setListener(ActivityD.this);
        myAsync.execute();
    }

    public class MyAsync extends AsyncTask{

            public void setListener(ActivityD listener){
                this.listener = new WeakReference<ActivityD>(listener);
            }
        WeakReference<ActivityD>listener;

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
                        JSONObject object = jsonArray.getJSONObject(i);
                        Person person = new Person();
                        person.setName(object.getString("name"));
                        person.setSurname(object.getString("surname"));
                        listPerson.add(person);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                mPersonAdapter = new PersonAdapter(ActivityD.this,listPerson);
                listView.setAdapter(mPersonAdapter);
            }
        });
    }
}
