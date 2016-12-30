package com.its.pretto.samuele.asynctasksample;

import android.app.Activity;
import android.app.ProgressDialog;
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
    ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textResult);
        MyAsyncTask vMyAsync = new MyAsyncTask();
        vMyAsync.setmListener(MainActivity.this);
        vMyAsync.execute();
    }

    public void setResult(final String aResult){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTextView.setText(aResult);
            }
        });
    }

    class MyAsyncTask extends AsyncTask{

        WeakReference<MainActivity> mListener;

        public void setmListener(MainActivity aMainActivity){
            mListener = new WeakReference<MainActivity>(aMainActivity);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mDialog = new ProgressDialog(mListener.get());
            mDialog.setMessage("Sto caricando");
            mDialog.show();
        }

        @Override
        protected Object doInBackground(Object[] params) {

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://tommo.altervista.org/ITS/users.php")
                    .get()
                    .build();

            try {
                Response response = client.newCall(request).execute();
                mListener.get().setResult(response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            mDialog.dismiss();
        }
    }
}


