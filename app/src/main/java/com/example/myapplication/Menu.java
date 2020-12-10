package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Menu extends Fragment {
    FragmentManager menuManager = null;
    FragmentTransaction menuTransaction = null;

    public Menu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View fMenu = inflater.inflate(R.layout.fragment_menu, container, false);
        final Button btnAdd = fMenu.findViewById(R.id.addIncidenceButton);
        final Button btnShow = fMenu.findViewById(R.id.listIncidenceButton);
        final Button btnDelete = fMenu.findViewById(R.id.deleteIncidenceButton);
        final Button btnAbout = fMenu.findViewById(R.id.aboutButton);
        final Button btnSettings = fMenu.findViewById(R.id.settingsButton);
        btnAdd.setBackgroundColor(Color.parseColor("#65EFC3"));
        btnShow.setBackgroundColor(Color.parseColor("#708881"));
        btnDelete.setBackgroundColor(Color.parseColor("#708881"));
        btnAbout.setBackgroundColor(Color.parseColor("#708881"));
        btnSettings.setBackgroundColor(Color.parseColor("#708881"));
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAdd.setBackgroundColor(Color.parseColor("#65EFC3"));
                btnShow.setBackgroundColor(Color.parseColor("#708881"));
                btnDelete.setBackgroundColor(Color.parseColor("#708881"));
                btnAbout.setBackgroundColor(Color.parseColor("#708881"));
                btnSettings.setBackgroundColor(Color.parseColor("#708881"));
                Log.i("click", "button add clicked");
                menuManager = getFragmentManager();
                menuTransaction = menuManager.beginTransaction();
                Fragment fAddIncidence = new AddIncidence();
                menuTransaction.replace(R.id.constraintMainLayout, fAddIncidence);
                menuTransaction.commit();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAdd.setBackgroundColor(Color.parseColor("#708881"));
                btnShow.setBackgroundColor(Color.parseColor("#65EFC3"));
                btnDelete.setBackgroundColor(Color.parseColor("#708881"));
                btnAbout.setBackgroundColor(Color.parseColor("#708881"));
                btnSettings.setBackgroundColor(Color.parseColor("#708881"));
                Log.i("click", "button show clicked");
                menuManager = getFragmentManager();
                menuTransaction = menuManager.beginTransaction();
                Fragment fListIncidences = new ListIncidences();
                menuTransaction.replace(R.id.constraintMainLayout, fListIncidences);
                menuTransaction.commit();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAdd.setBackgroundColor(Color.parseColor("#708881"));
                btnShow.setBackgroundColor(Color.parseColor("#708881"));
                btnDelete.setBackgroundColor(Color.parseColor("#65EFC3"));
                btnAbout.setBackgroundColor(Color.parseColor("#708881"));
                btnSettings.setBackgroundColor(Color.parseColor("#708881"));
                Log.i("click", "button delete one incidence clicked");
                menuManager = getFragmentManager();
                menuTransaction = menuManager.beginTransaction();
                Fragment fDeleteIncidence = new DeleteIncidence();
                menuTransaction.replace(R.id.constraintMainLayout, fDeleteIncidence);
                menuTransaction.commit();
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAdd.setBackgroundColor(Color.parseColor("#708881"));
                btnShow.setBackgroundColor(Color.parseColor("#708881"));
                btnDelete.setBackgroundColor(Color.parseColor("#708881"));
                btnAbout.setBackgroundColor(Color.parseColor("#65EFC3"));
                btnSettings.setBackgroundColor(Color.parseColor("#708881"));
                Log.i("clickAbout", "About");
                menuManager = getFragmentManager();
                menuTransaction = menuManager.beginTransaction();
                Fragment fAbout = new About();
                menuTransaction.replace(R.id.constraintMainLayout, fAbout);
                menuTransaction.commit();
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAdd.setBackgroundColor(Color.parseColor("#708881"));
                btnShow.setBackgroundColor(Color.parseColor("#708881"));
                btnDelete.setBackgroundColor(Color.parseColor("#708881"));
                btnAbout.setBackgroundColor(Color.parseColor("#708881"));
                btnSettings.setBackgroundColor(Color.parseColor("#65EFC3"));
                Log.i("clickSettings", "Settings");
                menuManager = getFragmentManager();
                menuTransaction = menuManager.beginTransaction();
                Fragment fSettings = new Settings();
                menuTransaction.replace(R.id.constraintMainLayout, fSettings);
                menuTransaction.commit();
            }
        });

        return fMenu;
    }
    private void setViewLayout(int id){
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mainView = inflater.inflate(id, null);
        ViewGroup rootView = (ViewGroup) getView();
        rootView.removeAllViews();
        rootView.addView(mainView);
    }
}