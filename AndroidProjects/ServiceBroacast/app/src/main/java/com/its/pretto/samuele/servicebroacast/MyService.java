package com.its.pretto.samuele.servicebroacast;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;
import java.lang.ref.WeakReference;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Samuele.Pretto on 08/11/2016.
 */

public class MyService extends Service implements SafeTimer.ITimer {

    SafeTimer mTimer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public void onTick() {
        Log.d("aaa","onTick()");
        MyServiceTask myServiceTask = new MyServiceTask();
        myServiceTask.setListener(MyService.this);
        myServiceTask.execute();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mTimer = SafeTimer.Create(MyService.this,2000);
        mTimer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mTimer.stop();
        super.onDestroy();
    }

    public class MyServiceTask extends AsyncTask{

        public void setListener(MyService listener){
            this.listener = new WeakReference<MyService>(listener);
        }
        WeakReference<MyService> listener;

        @Override
        protected Object doInBackground(Object[] params) {

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://tommo.altervista.org/ITS/annunci/getall.php")
                    .get()
                    .build();

            try {
                Response response = client.newCall(request).execute();
                listener.get().logResponse(response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

    public void logResponse (String aResponse){
        Log.d("aaa",aResponse);
    }
}
