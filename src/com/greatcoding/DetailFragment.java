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
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class DetailFragment extends Fragment {

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("DetailFragment", "onActivityCreated");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle b)
    {
        Log.d("DetailFragment", "onCreateView");
        View view = inflater.inflate(R.layout.detail_fragment, container, false);

        return view;
    }
}
