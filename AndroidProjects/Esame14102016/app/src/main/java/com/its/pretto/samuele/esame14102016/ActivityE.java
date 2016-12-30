package com.its.pretto.samuele.esame14102016;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ActivityE extends AppCompatActivity {

    ListView listE;
    String result;
    AsyncE asyncE;
    String description;
    ContentValues contentValues;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e);
        listE = (ListView) findViewById(R.id.listE);
        asyncE = new AsyncE();
        asyncE.setListener(ActivityE.this);
        asyncE.execute();

    }

    public class AsyncE extends AsyncTask{
        public void setListener(ActivityE listener){
            this.listener = new WeakReference<ActivityE>(listener);
        }
        WeakReference<ActivityE> listener;

        @Override
        protected Object doInBackground(Object[] params) {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://tommo.altervista.org/ITS/items.php")
                    .get()
                    .build();

            try {
                Response response = client.newCall(request).execute();
                result = response.body().string();
                JSONArray jsonArray = new JSONArray(result);
                for (int x=0; x<jsonArray.length();x++){
                    JSONObject object = jsonArray.getJSONObject(x);
                    description = object.getString("description");
                    listener.get().insertDesc(description);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }
    }

    public void insertDesc(final String desc){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                contentValues = new ContentValues();
                contentValues.put(DBTableHelper.DESCRIPTION,desc);
                database = new DBHelper(ActivityE.this).getWritableDatabase();
                database.insert(DBTableHelper.TABLE_NAME, null, contentValues);
                database.close();
                database = new DBHelper(ActivityE.this).getReadableDatabase();
                Cursor cursor = database.query(DBTableHelper.TABLE_NAME, new String[]{DBTableHelper._ID,DBTableHelper.DESCRIPTION},null,null,null,null,
                        DBTableHelper._ID);
                DBCursorAdapter adapter = new DBCursorAdapter(ActivityE.this, cursor);
                listE.setAdapter(adapter);
                database.close();
            }
        });
    }
}
