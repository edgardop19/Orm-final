package com.augustosalazar.as_android_importantlibraries;



import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(General.TAG, "Activity onCreate");

        // get fragment manager
        FragmentManager fm = getSupportFragmentManager();


        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.HolderFragment1, new Fragment1());
        ft.add(R.id.HolderFragment2, new Fragment2());
        ft.add(R.id.HolderFragment3, new Fragment3());
        ft.commit();


    }
}
