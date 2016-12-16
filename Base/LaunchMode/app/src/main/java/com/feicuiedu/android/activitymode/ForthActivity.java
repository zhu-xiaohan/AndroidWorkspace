package com.feicuiedu.android.activitymode;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by feicui on 16-12-16.
 */

public class ForthActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forth_layout);
        Log.d(TAG, "ForthActivity_onCreate: "+this.toString()+",task_id="+getTaskId());
    }

}
