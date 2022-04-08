package com.ifkirne.appsqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbConnexion extends SQLiteOpenHelper {
    public dbConnexion(Context context){
        super(context,"ADMIN",null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String script="CREATE TABLE IF NOT EXISTS admin (id INTEGER PRIMARY KEY, name TEXT)";
        sqLiteDatabase.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ADMIN");
            onCreate(sqLiteDatabase);
    }
}
