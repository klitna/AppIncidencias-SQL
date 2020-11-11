package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListIncidences extends Fragment {

    public ListIncidences() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View flistIncidences = inflater.inflate(R.layout.fragment_list_incidences, container, false);
        /*
        RecyclerView recyclerView = findViewById(R.id.addIncidenceRecycler);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, array_noms);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));*/

        return inflater.inflate(R.layout.fragment_list_incidences, container, false);
    }
}