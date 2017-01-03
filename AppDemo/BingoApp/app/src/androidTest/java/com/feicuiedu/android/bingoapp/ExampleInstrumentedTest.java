package com.feicuiedu.android.bingoapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.feicuiedu.android.bingoapp.pojo.User_;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private static final String TAG = "ExampleInstrumentedTest";
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.feicuiedu.android.bingoapp", appContext.getPackageName());
    }

    @Test
    public void addData() {

        Context appContext = InstrumentationRegistry.getTargetContext();

        Bmob.initialize(appContext, "bdafac1d057084aeddfb61efe001d4ae");

        User_ user = new User_();

        user.setName("test1");
        user.setSex(2);
        user.setBirthday(new Date());
        user.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e==null){
                    System.out.println("添加数据成功，返回objectId为："+s);
                }else{

                    System.out.println("创建数据失败：" + e.getMessage());
                }
            }
        });
    }

    @Test
    public void testQuery() {

        Context appContext = InstrumentationRegistry.getTargetContext();

        Bmob.initialize(appContext, "bdafac1d057084aeddfb61efe001d4ae");

        //查找Person表里面id为bmobQuery的数据
        BmobQuery<User_> bmobQuery = new BmobQuery<User_>();
        bmobQuery.getObject("8bddf74a31", new QueryListener<User_>() {
            @Override
            public void done(User_ user_, BmobException e) {
                if(e==null){
                    System.out.println("查询成功，User_："+user_.getName());
                    Log.d(TAG, "done:>>>>>>>");
                }else{
                    System.out.println("查询失败：" + e.getMessage());
                }
            }
        });

    }
}
