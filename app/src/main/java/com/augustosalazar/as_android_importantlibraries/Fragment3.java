package com.augustosalazar.as_android_importantlibraries;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.EventLog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Random;

import eventBus.MessageChangeF1;
import eventBus.MessageChangeF2;
import eventBus.MessageChangeF3;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {


    private Button button;
    @Override
    public void onStart() {
        super.onStart();
        Log.d(General.TAG, "F3 On start");
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
        View v = inflater.inflate(R.layout.fragment_fragment3, container, false);
        button = (Button) v.findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setName(Fragment2.instance.getName());
                user.setLastName(Fragment2.instance.getLastName());
                EventBus.getDefault().post(new MessageChangeF2(""));
                EventBus.getDefault().post(new MessageChangeF1(user));
            }
        });
        return v;
    }

    @Subscribe
    public void onMessageEvent(MessageChangeF3 event){
        Log.d(General.TAG, "F3 onMessageEvent " + event.message);

    }

}
