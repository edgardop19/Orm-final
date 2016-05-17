package com.augustosalazar.as_android_importantlibraries;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Random;

import eventBus.MessageChangeF2;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {


    public static Fragment2 instance;

    private EditText mName;
    private EditText mLastName;

    @Override
    public void onStart() {
        super.onStart();
        Log.d(General.TAG, "F2 On start");
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);
        Log.d(General.TAG, "F2 onCreateView");
        mName = (EditText) v.findViewById(R.id.name);
        mLastName = (EditText) v.findViewById(R.id.lastName);
        Fragment2.instance = this;
        return v;
    }

    @Subscribe
    public void onMessageEvent(MessageChangeF2 event){
        Log.d(General.TAG, "F2 onMessageEvent "+event.message);
        mLastName.setText("");
        mName.setText("");
    }

    public String getName() {
        return mName.getText().toString();
    }

    public String getLastName() {
        return mLastName.getText().toString();
    }
}
