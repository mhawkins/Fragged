package com.greatcoding;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;

public class Main extends FragmentActivity
{
    // Fragments
    private static FragmentManager fragmentManager;
    private static TopFragment topFragment;

    // Broadcast receiver
    private static BroadcastReceiver broadcastReceiver;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Get a fragment manager
        fragmentManager = this.getSupportFragmentManager();
        //topFragment = (TopFragment)fragmentManager.findFragmentById(R.id.top_fragment);

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String letter = intent.getStringExtra("letter");


                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int orientation = display.getOrientation();
                if(orientation == Surface.ROTATION_0 || orientation == Surface.ROTATION_180) {
                    Intent detailActivity = new Intent(this, DetailActivity.class);
                    startActivity(detailActivity);

                }

            }
        };


        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("FRLetterSelected");

        this.registerReceiver(broadcastReceiver, intentFilter);

    }

    @Override
    protected void onStart() {
        super.onStart();

        // Set the fragment title
        //topFragment.setTitle("Title of top fragment set by main activity!");

        Display display = ((WindowManager) this.getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        int orientation = display.getOrientation();

        Log.d("Main", "Orientation is " + orientation);


    }


}
