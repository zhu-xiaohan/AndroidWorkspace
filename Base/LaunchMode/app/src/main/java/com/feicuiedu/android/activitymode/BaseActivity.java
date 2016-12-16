package com.feicuiedu.android.activitymode;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feicui on 16-12-16.
 */

public abstract class BaseActivity extends AppCompatActivity implements IAction{

    protected static final String TAG = "BaseActivity";

    private static List<Activity> aliveActivty = new ArrayList<>();

    protected void jumpAction(Class<? extends BaseActivity> target) {

        Intent intent = new Intent();
        intent.setClass(this,target);
        startActivity(intent);
    }

    private BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            finish();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate: " + getClass().getSimpleName());

        //aliveActivty.add(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: " + getClass().getSimpleName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: " + getClass().getSimpleName());

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ExitAll");
        registerReceiver(myReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: " + getClass().getSimpleName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: " + getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
        Log.d(TAG, "onDestroy: " + getClass().getSimpleName());

        aliveActivty.remove(this);
    }

    @Override
    public void toFirst(View view) {
        jumpAction(FirstActivity.class);
    }

    @Override
    public void toSecond(View view) {
        jumpAction(SecondActivity.class);
    }

    @Override
    public void toThird(View view) {
        jumpAction(ThirdActivity.class);
    }

    @Override
    public void toForth(View view) {
        jumpAction(ForthActivity.class);
    }

    public void closeAll(View view) {

        Log.d(TAG, "closeAll: " +aliveActivty.size());
        /*IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("activity.close");

        Intent in = new Intent();
        in.setAction("activity.close");

        sendBroadcast(in);*/

        Intent in = new Intent();
        in.setAction("ExitAll");

        sendBroadcast(in);

        /*for (Activity activity:aliveActivty) {
            activity.finish();
        }*/
    }
}
