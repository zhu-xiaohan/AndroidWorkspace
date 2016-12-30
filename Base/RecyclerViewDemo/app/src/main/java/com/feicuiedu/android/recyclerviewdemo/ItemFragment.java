package com.feicuiedu.android.recyclerviewdemo;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chenyan on 2016/12/25.
 */

public class ItemFragment extends Fragment {

    private String title;

    private onListFragmentInteractionListener listener;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main,container,false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof onListFragmentInteractionListener) {
            //  listener = context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface onListFragmentInteractionListener {
        void onListFragmentInteraction(Object objecgt);
    }
}
