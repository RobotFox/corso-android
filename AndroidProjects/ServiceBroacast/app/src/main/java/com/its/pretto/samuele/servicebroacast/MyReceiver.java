package com.its.pretto.samuele.servicebroacast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Samuele.Pretto on 08/11/2016.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("aaa","I'am a Broadcast Receiver!");
        Intent vIntent = new Intent(context, MyService.class);
        context.startService(vIntent);
    }
}
