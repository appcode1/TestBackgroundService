package com.example.testbackgroundservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button startBackgroundService;
    private Button stopBackgroundService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBackgroundService = (Button)findViewById(R.id.start_background_service);
        stopBackgroundService = (Button)findViewById(R.id.stop_background_service);

        startBackgroundService.setOnClickListener(this);
        stopBackgroundService.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_background_service:
                Intent intent = new Intent(this, LongRunningService.class);
                startService(intent);
                break;
            case R.id.stop_background_service:
                Intent intent2 = new Intent(this, LongRunningService.class);
                stopService(intent2);

                //then stop the alarms with a matching intent
                AlarmManager manager = (AlarmManager)getSystemService(ALARM_SERVICE);
                Intent i = new Intent(this, AlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, i, 0);
                manager.cancel(pendingIntent);
                break;
            default:
                break;
        }
    }
}
