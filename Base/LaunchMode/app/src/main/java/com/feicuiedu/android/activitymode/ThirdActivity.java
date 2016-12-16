package com.feicuiedu.android.activitymode;

import android.os.Bundle;
import android.util.Log;

/**
 * Created by feicui on 16-12-16.
 */

public class ThirdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
        Log.d(TAG, "ThirdActivity_onCreate: "+this.toString()+",task_id="+getTaskId());
    }

}
