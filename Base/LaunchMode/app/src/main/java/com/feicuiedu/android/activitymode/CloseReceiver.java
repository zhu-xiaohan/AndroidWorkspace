package com.feicuiedu.android.activitymode;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by feicui on 16-12-16.
 */

public class CloseReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ((Activity)context).finish();
    }
}
