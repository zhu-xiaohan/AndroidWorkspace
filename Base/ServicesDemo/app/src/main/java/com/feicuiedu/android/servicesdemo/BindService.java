package com.feicuiedu.android.servicesdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by chenyan on 2016/12/5.
 */

public class BindService extends Service {

    private static final String TAG = "BindService";
    // private int count;
    private boolean quit;
    
    // 定义onBinder方法所返回的对象
    private MyBinder binder = new MyBinder();
    
    @Override
    public IBinder onBind(Intent intent) {

        Log.d(TAG, "onBind: Service is binded");
        return binder;
    }
    
    // Service 被创建时回调的方法
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: Service is created");
        
        new Thread(){
            @Override
            public void run() {
                while(!quit) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int i = binder.getCount();
                    i ++;

                }
            }
        }.start();
    }
    
    // Service 被断开连接时回调的方法
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: Service is unbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.quit = true;
        Log.d(TAG, "onDestroy: Service is Destroyed");
    }
}
