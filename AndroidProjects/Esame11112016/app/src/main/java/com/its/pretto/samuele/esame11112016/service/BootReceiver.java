package com.its.pretto.samuele.esame11112016.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.its.pretto.samuele.esame11112016.service.ServiceActivity4;

/**
 * Created by Samuele.Pretto on 11/11/2016.
 */

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent vIntent = new Intent(context, ServiceActivity4.class);
        context.startService(vIntent);
    }
}
