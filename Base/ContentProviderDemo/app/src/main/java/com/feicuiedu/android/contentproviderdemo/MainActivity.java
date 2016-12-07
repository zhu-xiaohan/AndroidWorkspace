package com.feicuiedu.android.contentproviderdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private final String MP3_PATH = "/mnt/sdcard/Baidu_music/offlinecache/";

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String path = null;
        /*File file = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            file = Environment.getExternalStorageDirectory();
        }
        Log.d(TAG, "onCreate: "+file.getAbsolutePath());*/
        File file = new File(MP3_PATH);
        String[] fileList = file.list();


    }
}
