package com.feicuiedu.android.activitymode;

import android.os.Bundle;
import android.util.Log;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Log.d(TAG, "FirstActivity_onCreate: "+this.toString()+",task_id="+getTaskId());
    }


}
