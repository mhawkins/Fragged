package com.greatcoding;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

public class Main extends FragmentActivity
{
    // Fragments
    private FragmentManager fragmentManager;
    private TopFragment topFragment;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Get a fragment manager
        fragmentManager = this.getSupportFragmentManager();
        //topFragment = (TopFragment)fragmentManager.findFragmentById(R.id.top_fragment);

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
