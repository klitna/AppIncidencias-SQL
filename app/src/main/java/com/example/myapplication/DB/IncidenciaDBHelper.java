package com.example.myapplication.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.myapplication.DB.IncidenciaContract.*;
import com.example.myapplication.Incidence;

import androidx.annotation.Nullable;

public class IncidenciaDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "incidencies.db";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + IncidenciaContract.IncidenciaEntry.TABLE_NAME + "(" + IncidenciaContract.IncidenciaEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + IncidenciaContract.IncidenciaEntry.COLUMN_NAME_TITLE + " TEXT)";


    public IncidenciaDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static void insertIncidencia(SQLiteDatabase db, Incidence i){
        //Check the bd is open
        if (db.isOpen()){
            ContentValues values = new ContentValues();

            //Insert the incidence getting all values
            values.put(IncidenciaEntry.COLUMN_NAME_TITLE, i.getName());

            db.insert(IncidenciaEntry.TABLE_NAME, null, values);
            db.close();
        }else{
            Log.d("sql","Database is closed");
        }
    }
}
