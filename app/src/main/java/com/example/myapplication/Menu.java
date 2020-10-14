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

    public Menu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fMenu = inflater.inflate(R.layout.fragment_menu, container, false);
        Button btnAdd = fMenu.findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("click", "button add clicked");
            }
        });

        FragmentManager menuManager = getFragmentManager();
        FragmentTransaction menuTranaction = menuManager.beginTransaction();

        Fragment fAddIncidence = new AddIncidence();
        menuTranaction.replace(R.id.constraintMainLayout, fAddIncidence);
        menuTranaction.commit();
        return fMenu;
    }
}