package com.greatcoding;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by IntelliJ IDEA.
 * User: matt
 * Date: 6/17/11
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class DetailActivity extends Activity {
//    BroadcastReceiver broadcastReceiver;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);


//        broadcastReceiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                String letter = intent.getStringExtra("letter");
//                Log.d("Letter", "Letter selected - " + letter);
//
//            }
//        };
//
//
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("FRLetterSelected");
//
//        this.registerReceiver(broadcastReceiver, intentFilter);
    }

    public void onDestroy() {
//        this.unregisterReceiver(broadcastReceiver);
    }

}