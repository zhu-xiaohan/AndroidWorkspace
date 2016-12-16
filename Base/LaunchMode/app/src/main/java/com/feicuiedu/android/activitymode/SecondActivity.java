package com.feicuiedu.android.activitymode;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Log.d(TAG, "SecondActivity_onCreate: "+this.toString()+",task_id="+getTaskId());
    }

}
