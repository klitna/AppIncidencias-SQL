package com.example.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.DB.IncidenciaDBHelper;

import static java.security.AccessController.getContext;

public class ListIncidences extends Fragment {
    IncidenciaDBHelper dbHelper;
    SQLiteDatabase db;
    public ListIncidences() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dbHelper = new IncidenciaDBHelper(container.getContext());
        db = dbHelper.getWritableDatabase();
        // Inflate the layout for this fragment
        View fListIncidences = inflater.inflate(R.layout.fragment_list_incidences, container, false);

        String[] arrN = dbHelper.getIncidenceNames();
        String[] arrU= dbHelper.getUrgences();

        RecyclerView recyclerView = (RecyclerView)fListIncidences.findViewById(R.id.incidencesRecycler);
        //recyclerView.setLayoutManager(new GridLayoutManager(getContext()));


        int count = dbHelper.getCountRows();

        return inflater.inflate(R.layout.fragment_list_incidences, container, false);
    }
}