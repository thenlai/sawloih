package org.vahcuengh.sawloih.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class WordItemDBHelper extends SQLiteAssetHelper {
    public static final String DATABASE_NAME = "cuengh.db";
    public static final int DATABASE_VERSION = 2;

    public WordItemDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public SQLiteDatabase getDatabase() {
        SQLiteDatabase db;
        db = getReadableDatabase();
        return db;
    }
}
