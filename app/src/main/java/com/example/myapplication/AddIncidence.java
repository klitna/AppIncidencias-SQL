package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AddIncidence extends Fragment {

    public AddIncidence() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fAddIncidence = inflater.inflate(R.layout.fragment_add_incidence, container, false);
        /*Button buttonAdd = fAddIncidence.findViewById(R.id.addIncidenceButton);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager menuManager = null;
                FragmentTransaction menuTransaction = null;

            }
        });*/

        return inflater.inflate(R.layout.fragment_add_incidence, container, false);
    }
}