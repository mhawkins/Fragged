package com.greatcoding;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by IntelliJ IDEA.
 * User: matt
 * Date: 6/17/11
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class DetailFragment extends Fragment {

    // Receivers
    private static BroadcastReceiver broadcastReceiver;

    //
    private static TextView detailsText;

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("DetailFragment", "onActivityCreated");

        // Receive letter selections
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String letter = intent.getStringExtra("letter");

                StringBuilder youSelected = new StringBuilder();
                youSelected.append("You selected: ");
                youSelected.append(letter);

                detailsText.setText(youSelected.toString());
            }
        };

        // Get our details text view
        detailsText = (TextView)this.getView().findViewById(R.id.details_text);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("FRLetterSelected");
        this.getActivity().registerReceiver(broadcastReceiver, intentFilter);
    }

    public void onDestroy() {
        this.getActivity().unregisterReceiver(broadcastReceiver);
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle b)
    {
        Log.d("DetailFragment", "onCreateView");
        View view = inflater.inflate(R.layout.detail_fragment, container, false);

        return view;
    }
}
