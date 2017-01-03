package com.feicuiedu.android.bingoapp.applications;

import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * Created by root on 17-1-3.
 */

public class BingoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
    }
}
