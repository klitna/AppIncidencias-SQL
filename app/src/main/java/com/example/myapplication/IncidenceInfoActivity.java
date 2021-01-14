package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.DB.IncidenciaDBHelper;

import java.util.ArrayList;

public class IncidenceInfoActivity extends AppCompatActivity {
    IncidenciaDBHelper dbHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incidence_info);

        dbHelper = new IncidenciaDBHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();
        ArrayList<Incidence> inci =  dbHelper.getAllIncidences(db);
        String name="";
        String date="";
        String urgence = "";
        String id="";

        TextView nameTextView = findViewById(R.id.incidenceInfoTitle);
        TextView dateTextView = findViewById(R.id.dateIncidenceActivity);
        TextView urgenceTextView = findViewById(R.id.urgenceIncidenceActivity);

        final Intent i = getIntent();
        Bundle extra = i.getExtras();
        if (extra != null) {
            name = extra.getString("name");
            date = extra.getString("date");
            urgence = extra.getString("urgence");
        }
        nameTextView.setText(name);
        dateTextView.setText(getString(R.string.date)+": "+ date);
        urgenceTextView.setText(urgence);
    }
}