package com.feicuiedu.android.servicesdemo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String strUri = "content://com.feicuiedu.android.contentproviderdemo/MyContentProvider";
        Uri uri = Uri.parse(strUri);

        ContentResolver cr = getContentResolver();

        // Cursor cursor = cr.query(uri,null,"id=? ",new String[]{"1"},null);
        Cursor cursor = cr.query(uri,null,null,null,null);

        while(cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));

            Log.d("query",id+":"+name);
        }

        cursor.close();


    }
}
