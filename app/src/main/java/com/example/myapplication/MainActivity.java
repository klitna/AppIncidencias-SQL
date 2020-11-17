package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.DB.IncidenciaDBHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

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
        String ok="true";

        Toast.makeText(getApplicationContext(),ok , Toast.LENGTH_SHORT).show();
       /* if(!loggedIn){
            loggedIn=true;
            Intent intentLogin = new Intent(this, LoginActivity.class);
            intentLogin.putExtra("loggedIn", loggedIn);
            this.startActivity(intentLogin);
        }*/
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }
}