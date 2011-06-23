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

    // Broadcast receiver
    private static BroadcastReceiver broadcastReceiver;

    // Data
    private static String letter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Log.d("MainActivity", "Bundle: " + savedInstanceState);

        // Get a fragment manager
        fragmentManager = this.getSupportFragmentManager();

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                letter = intent.getStringExtra("letter");

                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int orientation = display.getOrientation();
                if(orientation == Surface.ROTATION_0 || orientation == Surface.ROTATION_180) {
                    loadDetail(letter);
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

        Display display = ((WindowManager) this.getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        int orientation = display.getOrientation();
        if(orientation == Surface.ROTATION_90 || orientation == Surface.ROTATION_270) {
            DetailFragment detailFragment = (DetailFragment)fragmentManager.findFragmentById(R.id.details);
            detailFragment.setLetter(letter);
        }
    }

    @Override
    public void onDestroy() {
        this.unregisterReceiver(broadcastReceiver);
        super.onDestroy();
    }

    protected void loadDetail(String letter) {
        Intent detailActivity = new Intent(this, DetailActivity.class);
        detailActivity.putExtra("letter", letter);
        startActivity(detailActivity);
    }


}
