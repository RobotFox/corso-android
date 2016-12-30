package com.its.pretto.samuele.esame14102016;

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

    TextView txvResult;
    String result;
    MyAsync myAsync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        txvResult = (TextView) findViewById(R.id.textViewRisultato);
        myAsync = new MyAsync();
        myAsync.setListener(ActivityD.this);
        myAsync.execute();

    }

    public class MyAsync extends AsyncTask{
        public void setListener(ActivityD listener){
            this.listener = new WeakReference<ActivityD>(listener);
        }
        WeakReference<ActivityD>listener;

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
            listener.get().setTxt(result);


            return null;
        }
    }

    public void setTxt(final String text){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                txvResult.setText(text);

            }
        });
    }

}
