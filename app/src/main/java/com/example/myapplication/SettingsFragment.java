package com.example.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myapplication.DB.IncidenciaDBHelper;

import java.util.Locale;


public class SettingsFragment extends Fragment {

    Configuration config = new Configuration(getResources().getConfiguration());
    Locale esLocale = new Locale("es");
    Locale enLocale = new Locale("en");
    IncidenciaDBHelper dbHelper;
    SQLiteDatabase db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fSettings = inflater.inflate(R.layout.fragment_settings, container, false);

        dbHelper = new IncidenciaDBHelper(container.getContext());
        db = dbHelper.getWritableDatabase();
        ImageButton toEsButton = fSettings.findViewById(R.id.buttonSpanishFlag);
        toEsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                config.setLocale(esLocale);
                Toast.makeText(getActivity(), "El idioma se ha cambiado a castellano.", Toast.LENGTH_LONG).show();
            }
        });

        ImageButton toEnButton = fSettings.findViewById(R.id.buttonEnglishFlag);
        toEsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                config.setLocale(enLocale);
                Toast.makeText(getActivity(), "Language switched to English.", Toast.LENGTH_LONG).show();
            }
        });

        return fSettings;
    }
}