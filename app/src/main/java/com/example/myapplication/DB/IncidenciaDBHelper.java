package com.example.myapplication.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.DB.IncidenciaContract.*;
import com.example.myapplication.Incidence;

import androidx.annotation.Nullable;

public class IncidenciaDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "incidencies.db";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + IncidenciaContract.IncidenciaEntry.TABLE_NAME + "(" + IncidenciaContract.IncidenciaEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + IncidenciaContract.IncidenciaEntry.COLUMN_NAME_TITLE + " TEXT ," + IncidenciaEntry.COLUMN2_NAME_TITLE + " TEXT)";


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

    public static void insertIncidencia(SQLiteDatabase db, String name, String urgence){
        //Check the bd is open
        if (db.isOpen()){
            ContentValues values = new ContentValues();

            //Insert the incidence getting all values
            values.put(IncidenciaEntry.COLUMN_NAME_TITLE, name);
            values.put(IncidenciaEntry.COLUMN2_NAME_TITLE, urgence);
            db.insert(IncidenciaEntry.TABLE_NAME, null, values);

            db.close();
        }else{
            Log.d("sql","Database is closed");
        }
    }

    public void deleteIncidence(int idDelete)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + IncidenciaEntry.TABLE_NAME+ " WHERE Id ='"+idDelete+"'");
        db.close();
    }

    public String[] getIncidenceNames(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(IncidenciaEntry.TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        String[] incidences = new String[cursor.getCount()];
        for (int i = 0; i < cursor.getCount(); i++){
            incidences[i] = cursor.getString(1);
            cursor.moveToNext();
        }
        return incidences;
    }

    public String[] getUrgences(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(IncidenciaEntry.TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        String[] urgences = new String[cursor.getCount()];
        for (int i = 0; i < cursor.getCount(); i++){
            urgences[i] = cursor.getString(2);
            cursor.moveToNext();
        }
        return urgences;
    }

    public void deleteIncidenceId(int idDel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + IncidenciaEntry.TABLE_NAME+ " WHERE id ='"+idDel+"'");
        db.close();
    }

    public int getCountRows(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(IncidenciaEntry.TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        return cursor.getCount();
    }
}
