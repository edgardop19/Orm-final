package com.augustosalazar.as_android_importantlibraries;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import eventBus.MessageChangeF1;
import eventBus.MessageChangeF2;
import eventBus.MessageChangeF3;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements View.OnClickListener {


    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    public Fragment1() {

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_fragment1, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

        loadUsers();
        return v;
    }


    public void loadUsers() {
        RuntimeExceptionDao<User, Long> simpleDao = OpenHelperManager.getHelper(getActivity(), DatabaseHelper.class).getSimpleDataDao();
        List<User> list = simpleDao.queryForAll();


        UserAdapter mAdapter = new UserAdapter(list);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Subscribe
    public void onMessageEvent(MessageChangeF1 event){
        Log.d(General.TAG, "F1 onMessageEvent ");
        RuntimeExceptionDao<User, Long> simpleDao = OpenHelperManager.getHelper(getActivity(), DatabaseHelper.class).getSimpleDataDao();
        simpleDao.create(event.userData);
        loadUsers();
    }

    @Override
    public void onClick(View v) {
        EventBus.getDefault().post(new MessageChangeF2("Changing background for Fragment 2"));
    }
}
