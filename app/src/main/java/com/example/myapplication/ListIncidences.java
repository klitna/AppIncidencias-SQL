package com.example.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.myapplication.DB.IncidenciaDBHelper;

import java.security.AccessController;
import java.util.ArrayList;

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
        ArrayList<Incidence> inci =  dbHelper.getAllIncidences(db);
        for(int i=0; i<inci.size(); i++ )
            Log.i("ListIncidence: ", inci.get(i).getName());

        /*final Button goToActivity = fListIncidences.findViewById(R.id.goToIncidenceButton);
        goToActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value="Hello world";
                Intent i = new Intent(getActivity(), IncidenceInfoActivity.class);
                i.putExtra("key",value);
                startActivity(i);
            }
        });*/

        RecyclerView recyclerView = (RecyclerView)fListIncidences.findViewById(R.id.incidencesRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(fListIncidences.getContext()));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, dbHelper.getAllIncidences(db));
        recyclerView.setAdapter(adapter);

        return fListIncidences;
    }


}