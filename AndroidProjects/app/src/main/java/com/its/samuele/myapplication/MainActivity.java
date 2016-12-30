package com.its.samuele.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.lang.ref.WeakReference;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView);
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.setmListener(MainActivity.this);
        myAsyncTask.execute();
    }

    class MyAsyncTask extends AsyncTask{
        WeakReference<MainActivity> mListener;

        public void setmListener(MainActivity mainActivity){
            mListener = new WeakReference<MainActivity>(mainActivity);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(Object[] params) {
            String aText ="";
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://api.github.com/users/mralexgray/repos")
                    .get()
                    .addHeader("cache-control", "no-cache")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                aText = response.body().string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
            mListener.get().writeTextView(aText);
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }
    }

    public void writeTextView(final String aText){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTextView.setText(aText);
            }
        });
    }




}
