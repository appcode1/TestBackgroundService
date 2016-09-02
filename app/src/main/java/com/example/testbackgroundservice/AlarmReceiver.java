package com.example.testbackgroundservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by mobileteamuser on 2016-09-01.
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("AlarmReceiver", "onReceive()");
        Intent i = new Intent(context, LongRunningService.class);
        context.startService(i);
    }
}
