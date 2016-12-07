package com.feicuiedu.android.contentproviderdemo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by chenyan on 2016/12/7.
 */

public class MyContentProvider extends ContentProvider {

    private DBHandler dbh = null;
    @Override
    public boolean onCreate() {

        dbh = new DBHandler(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        StringBuilder sbProjection = new StringBuilder();
        if (sbProjection != null && sbProjection.length()>0) {
            for (String strProj : projection) {
                sbProjection.append(strProj).append(",");
            }
            sbProjection.deleteCharAt(sbProjection.length()-1);
        }
        else {
            sbProjection.append(" * ");
        }

        if (selection == null) {
            selection = "";
        }
        else {
            selection = "and " + selection;
        }
        Cursor cursor = dbh.getReadableDatabase().rawQuery(" select " + sbProjection.toString() + " from user_ where 1= 1 " +selection ,selectionArgs);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {

        SQLiteDatabase db =dbh.getWritableDatabase();

        db.execSQL("insert into user_(id,name) values (?,?)",new String[]{values.getAsString("id"),values.getAsString("name")});

        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
