package com.example.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.DB.IncidenciaDBHelper;

public class DeleteIncidence extends Fragment {
    IncidenciaDBHelper dbHelper;
    SQLiteDatabase db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View fDeleteIncidence = inflater.inflate(R.layout.fragment_delete_incidence, container, false);

        dbHelper = new IncidenciaDBHelper(container.getContext());
        db = dbHelper.getWritableDatabase();

        EditText idEditText = fDeleteIncidence.findViewById(R.id.idIncidenceDelete);
        Button delete = fDeleteIncidence.findViewById(R.id.deleteIncidenceByIdButton);
        final String idString = idEditText.getText().toString();
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!idString.matches(""))
                {
                    int id = Integer.parseInt(idString);
                    dbHelper.deleteIncidence(db, id);
                }
                else
                    Toast.makeText(getActivity(), "Incidence saved succesfuly!", Toast.LENGTH_LONG).show();
            }
        });
        return fDeleteIncidence;
    }

    public void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }
}