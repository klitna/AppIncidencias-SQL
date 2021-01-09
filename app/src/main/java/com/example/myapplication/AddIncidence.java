package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.telecom.ConnectionService;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DB.IncidenciaDBHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.example.myapplication.DB.IncidenciaDBHelper.insertIncidence;

public class AddIncidence extends Fragment implements AdapterView.OnItemSelectedListener  {

    FragmentManager addIncidenceManager = null;
    FragmentTransaction addIncidenceTransaction = null;
    IncidenciaDBHelper dbHelper;
    SQLiteDatabase db;
    public AddIncidence() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fAddIncidence = inflater.inflate(R.layout.fragment_add_incidence, container, false);
        dbHelper = new IncidenciaDBHelper(getContext());
        db = dbHelper.getWritableDatabase();
        final ArrayList<String> incidencesAux = new ArrayList<String>();

        final EditText incidenceName = (EditText)fAddIncidence.findViewById(R.id.editTextTextPersonName);
        final Button saveIncidenceButton=(Button)fAddIncidence.findViewById(R.id.saveIncidenceButton);
        final Spinner addIncidenceSpinner = (Spinner) fAddIncidence.findViewById(R.id.addIncidenceSpinner);

        addIncidenceSpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) getView());
        String[] urgenceValues;
        Resources res = getResources();
        urgenceValues = res.getStringArray(R.array.incidencesUrgence ) ;

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, urgenceValues);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addIncidenceSpinner.setAdapter(dataAdapter);

        incidenceName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    saveIncidenceButton.performClick();
                    Toast.makeText(getActivity(), "Incidence saved succesfuly!", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });

        saveIncidenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String incidenceNameString = incidenceName.getText().toString();
                if (incidenceNameString.equals("") || incidenceNameString.equals(null)) {
                    Toast.makeText(container.getContext(), "Name cannot be empty!", Toast.LENGTH_SHORT).show();
                } else {
                    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd\n HH:mm:ss z");
                    Date date = new Date(System.currentTimeMillis());
                    Incidence incidence = new Incidence(incidenceName.getText().toString(), addIncidenceSpinner.getSelectedItem().toString(), formatter.format(date));
                    dbHelper.insertIncidence(db, incidence);
                    Log.i("add_incidence_success", "person name: "+incidence.name );
                    Toast.makeText(container.getContext(), "Incidence saved succesfully!", Toast.LENGTH_SHORT).show();
                    }
            }
        });
        return fAddIncidence;
    }

    @Override
    public void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}