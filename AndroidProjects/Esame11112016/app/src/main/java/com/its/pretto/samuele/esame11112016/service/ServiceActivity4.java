package com.its.pretto.samuele.esame11112016.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Samuele.Pretto on 11/11/2016.
 */

public class ServiceActivity4 extends Service {
    int i = 0;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.d("service", "Service Log: "+i);
                i++;
                handler.postDelayed(this,1000);
            }
        });
        return super.onStartCommand(intent, flags, startId);
    }
}
