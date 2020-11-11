package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.myapplication.DB.IncidenciaDBHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private IncidenciaDBHelper dbHelper;
    private SQLiteDatabase db;

    final ArrayList<Incidence> incidences = new ArrayList<Incidence>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Creation of the dbHelper
        dbHelper = new IncidenciaDBHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }
}