package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
        final ArrayList<Incidence> inci =  dbHelper.getAllIncidences(db);
        String name="";
        String date="";
        String urgence = "";
        int id = 0;

        TextView nameTextView = findViewById(R.id.incidenceInfoTitle);
        TextView dateTextView = findViewById(R.id.dateIncidenceActivity);
        TextView urgenceTextView = findViewById(R.id.urgenceIncidenceActivity);
        final TextView stateTextView = findViewById(R.id.stateIncidenceActivity);
        final ImageView stateImage = findViewById(R.id.stateCircleInfo);
        Button changeState = findViewById(R.id.changeStateButton);

        final Intent i = getIntent();
        Bundle extra = i.getExtras();
        if (extra != null) {
            name = extra.getString("name");
            date = extra.getString("date");
            urgence = extra.getString("urgence");
            id = Integer.parseInt(extra.getString("id"));
        }
        nameTextView.setText(name);
        dateTextView.setText(getString(R.string.date)+": "+ date);
        urgenceTextView.setText(urgence);
        switch(inci.get(id).getState()){
            case(0):stateImage.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.red_circle));
                stateTextView.setText(getString(R.string.state)+": "+getString(R.string.pending)); break;
            case(1):stateImage.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.orange_circle));
                stateTextView.setText(getString(R.string.state)+": "+getString(R.string.assigned)); break;
            case(2):stateImage.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.green_circle));
                stateTextView.setText(getString(R.string.state)+": "+getString(R.string.resolved)); break;
            default:stateImage.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.red_circle));break;
        }

        final int finalId = id;
        changeState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int state=inci.get(finalId).getState();
                state++;
                if(state>2)
                    state=0;
                inci.get(finalId).setState(state);
                dbHelper.changeState(db, inci.get(finalId));
                switch(state){
                    case(0):stateImage.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.red_circle));
                    stateTextView.setText(getString(R.string.state)+": "+getString(R.string.pending)); break;
                    case(1):stateImage.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.orange_circle));
                    stateTextView.setText(getString(R.string.state)+": "+getString(R.string.assigned)); break;
                    case(2):stateImage.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.green_circle));
                    stateTextView.setText(getString(R.string.state)+": "+getString(R.string.resolved)); break;
                    default:stateImage.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.red_circle));break;
                }
            }
        });
    }
}