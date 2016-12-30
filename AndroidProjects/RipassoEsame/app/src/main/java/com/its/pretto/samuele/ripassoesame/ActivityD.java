package com.its.pretto.samuele.ripassoesame;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.lang.ref.WeakReference;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ActivityD extends AppCompatActivity {

    TextView txtResult;
    String result;
    MyAsyncTask myAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        txtResult = (TextView) findViewById(R.id.textViewResult);
        myAsyncTask = new MyAsyncTask();
        myAsyncTask.setmListener(ActivityD.this);
        myAsyncTask.execute();

    }

private class MyAsyncTask extends AsyncTask{

    WeakReference<ActivityD> mListener;

    public void setmListener(ActivityD activity){
        mListener = new WeakReference<ActivityD>(activity);
    }

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
        } catch (IOException e) {
            e.printStackTrace();
        }
        mListener.get().setTxtResult(result);

        return null;
    }
}

    public void setTxtResult(final String text){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                txtResult.setText(text);
            }
        });
    }

}