package com.example.myapplication.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

public class IncidenciaDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "incidencies.db";

    public IncidenciaDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + IncidenciaContract.IncidenciaEntry.TABLE_NAME + "(" + IncidenciaContract.IncidenciaEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + IncidenciaContract.IncidenciaEntry.COLUMN_NAME_TITLE + " TEXT)";

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
