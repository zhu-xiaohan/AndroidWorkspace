package com.feicuiedu.android.servicesdemo;

import android.os.Binder;

/**
 * Created by chenyan on 2016/12/5.
 */
public class MyBinder extends Binder{

    private int count;

    public int getCount() {

        return count;
    }
}
