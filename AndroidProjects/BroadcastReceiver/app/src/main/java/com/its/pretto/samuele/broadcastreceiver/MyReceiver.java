package com.its.pretto.samuele.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Samuele.Pretto on 04/11/2016.
 */

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("aaa","broacast receiver");
        Intent vIntent = new Intent(context,MainActivity.class);
        context.startActivity(vIntent);
    }
}
