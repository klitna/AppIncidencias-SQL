package com.example.myapplication;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

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
        Button btnAdd = fMenu.findViewById(R.id.addIncidenceButton);
        Button btnShow = fMenu.findViewById(R.id.listIncidenceButton);
        Button btnDelete = fMenu.findViewById(R.id.deleteIncidenceButton);
        Button btnDeleteAll = fMenu.findViewById(R.id.deleteIncidencesButton);

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

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("click", "button delete one incidence clicked");
                menuManager = getFragmentManager();
                menuTransaction = menuManager.beginTransaction();
                Fragment fDeleteIncidence = new DeleteIncidence();
                menuTransaction.replace(R.id.constraintMainLayout, fDeleteIncidence);
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