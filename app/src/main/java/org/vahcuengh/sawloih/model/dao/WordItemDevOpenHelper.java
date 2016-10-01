package org.vahcuengh.sawloih.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class WordItemDevOpenHelper extends DaoMaster.DevOpenHelper {
    private WordItemDBHelper dbHelper;

    public WordItemDevOpenHelper(Context context, String name) {
        super(context, name);
        dbHelper = new WordItemDBHelper(context);
    }

    public WordItemDevOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
        dbHelper = new WordItemDBHelper(context);
    }

    SQLiteDatabase getDatabase() {
        return dbHelper.getDatabase();
    }
}
