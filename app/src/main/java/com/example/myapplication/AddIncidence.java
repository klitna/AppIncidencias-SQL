package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static com.example.myapplication.DB.IncidenciaDBHelper.insertIncidencia;

public class AddIncidence extends Fragment {

    FragmentManager addIncidenceManager = null;
    FragmentTransaction addIncidenceTransaction = null;
    SQLiteDatabase db;
    Incidence incidence;
    public AddIncidence() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fAddIncidence = inflater.inflate(R.layout.fragment_add_incidence, container, false);
        Button buttonAdd = fAddIncidence.findViewById(R.id.addIncidenceButton);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertIncidencia(db, incidence);
                Log.i("add", "incidence added");
            }
        });

        return inflater.inflate(R.layout.fragment_add_incidence, container, false);
    }



    public void onBackClick(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState){
        View fAddIncidence = inflater.inflate(R.layout.fragment_login_old, container, false);
        Log.i("click", "button add clicked");
        addIncidenceManager = getFragmentManager();
        addIncidenceTransaction = addIncidenceManager.beginTransaction();
        Fragment fMenu = new Menu();
        addIncidenceTransaction.replace(R.id.constraintMainLayout, fMenu);
        addIncidenceTransaction.commit();
    }
}