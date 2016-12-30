package com.feicuiedu.android.recyclerviewdemo;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

/**
 * Created by chenyan on 2016/12/25.
 */

public class MyIntentService extends IntentService {

    private static final String ACTION_FOO="";
    private static final String EXTRA_PARAM1="";
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService(String name) {
        super(name);
    }

    public void startActionFoo(Context context,String param1) {
        Intent intent = new Intent(context,MyIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1,param1);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent == null) {
            final String action = intent.getAction();
            if(ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                handleActionFoo(param1);
            }
        }
    }

    private void handleActionFoo(String param1){

    }
}
