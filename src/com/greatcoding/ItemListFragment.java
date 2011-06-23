package com.greatcoding;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.AndroidCharacter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: matt
 * Date: 6/17/11
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemListFragment extends ListFragment {
    //private ArrayList<String>

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Configuration configuration = getResources().getConfiguration();

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"}  ));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle b)
    {
        Log.d("ItemListFragment", "onCreateView");

        View view = inflater.inflate(R.layout.item_list_fragment, container, false);

        return view;
    }

    public void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String letter = (String)l.getItemAtPosition(position);
        Log.d("ItemListFragment", "Selected letter '" + letter + "'");

        // Broadcast a letter being selected
        Intent letterSelectedIntent = new Intent();
        letterSelectedIntent.putExtra("letter", letter);
        letterSelectedIntent.setAction("FRLetterSelected");
        this.getActivity().sendBroadcast(letterSelectedIntent);
    }

}
