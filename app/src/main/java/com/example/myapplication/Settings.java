package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.DB.IncidenciaDBHelper;

import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;


public class Settings extends Fragment {


    Locale esLocale = new Locale("es");
    Locale enLocale = new Locale("en");
    IncidenciaDBHelper dbHelper;
    SQLiteDatabase db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fSettings = inflater.inflate(R.layout.fragment_settings, container, false);
        final Context context = fSettings.getContext();
        final Configuration config = new Configuration(getResources().getConfiguration());
        dbHelper = new IncidenciaDBHelper(container.getContext());
        db = dbHelper.getWritableDatabase();

        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        final Button changeLang = fSettings.findViewById(R.id.changeLanguageButton);
        changeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLanguageDialog(context);
            }
        });
        return fSettings;
    }

    public void showChangeLanguageDialog(Context context)
    {
        final String[] listLanguages = {"English", "Español"};
        final AlertDialog.Builder dialogLanguages = new AlertDialog.Builder(context);
        dialogLanguages.setTitle("Choose your language: ");
        dialogLanguages.setSingleChoiceItems(listLanguages, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==0)
                {
                    //English
                    setLocale("en");
                    refresh();
                }else if(which==1)
                {
                    //Spanish
                    setLocale("es");
                    refresh();
                }
                dialog.dismiss();
            }
        });
        AlertDialog mDialog = dialogLanguages.create();
        mDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getActivity().getBaseContext().getResources().updateConfiguration(config, getActivity().getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = (SharedPreferences.Editor) getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    public void loadLocale(){
        SharedPreferences prefs = getActivity().getSharedPreferences("Settings", MODE_PRIVATE);
        String language = prefs.getString("My_lang", "");
        setLocale(language);
    }

    public void refresh(){
        getFragmentManager()
                .beginTransaction()
                .detach(Settings.this)
                .attach(Settings.this)
                .commit();
    }
}