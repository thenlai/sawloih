package org.vahcuengh.sawloih.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class WordItemDBManager {
    private final static String DB_NAME = "Word";
    private static WordItemDBManager instance;
    private WordItemDevOpenHelper openHelper;
    private Context context;

    public WordItemDBManager(Context context) {
        this.context = context;
        openHelper = new WordItemDevOpenHelper(context, DB_NAME, null);
    }

    public static WordItemDBManager getInstance(Context context) {
        if(instance == null) {
            synchronized (WordItemDBManager.class) {
                if(instance == null) {
                    instance = new WordItemDBManager(context);
                }
            }
        }
        return instance;
    }

    SQLiteDatabase getReadibleDatabase() {
        return  openHelper.getDatabase();
    }
}