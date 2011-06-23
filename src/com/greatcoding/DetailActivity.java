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

/**
 * Created by IntelliJ IDEA.
 * User: matt
 * Date: 6/17/11
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class DetailActivity extends FragmentActivity {
//    BroadcastReceiver broadcastReceiver;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        int orientation = display.getOrientation();
        if(orientation == Surface.ROTATION_90 || orientation == Surface.ROTATION_270) {
            finish();
        }

    }

    public void onStart() {
        super.onStart();

        String letter = this.getIntent().getStringExtra("letter");
        if(letter != null) {
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            DetailFragment detailFragment = (DetailFragment)fragmentManager.findFragmentById(R.id.top_fragment);
            detailFragment.setLetter(letter);
        }
    }

    public void onDestroy() {
        super.onDestroy();
//        this.unregisterReceiver(broadcastReceiver);
    }

}