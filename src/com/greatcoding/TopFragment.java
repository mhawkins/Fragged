package com.greatcoding;

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
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class TopFragment extends Fragment {

    // Views
    private TextView topTitle;

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("TopFrag", "onActivityCreated");

        topTitle.setText("The Top Title was set by onActivityCreated");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle b)
    {
        Log.d("TopFrag", "onCreateView");

        View view = inflater.inflate(R.layout.top_fragment, container, false);

        topTitle = (TextView)view.findViewById(R.id.top_title);

        return view;
    }

    public void setTitle(String title) {
        topTitle.setText(title);
    }
}
