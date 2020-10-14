package com.example.myapplication;

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
        // Inflate the layout for this fragment
        View fMenu = inflater.inflate(R.layout.fragment_menu, container, false);
        Button btnAdd = fMenu.findViewById(R.id.buttonAdd);
        Button btnShow = fMenu.findViewById(R.id.buttonShow);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                Log.i("click", "button show clicked");
                menuManager = getFragmentManager();
                menuTransaction = menuManager.beginTransaction();
                Fragment fListIncidences = new ListIncidences();
                menuTransaction.replace(R.id.constraintMainLayout, fListIncidences);
                menuTransaction.commit();
            }
        });

        return fMenu;
    }
}