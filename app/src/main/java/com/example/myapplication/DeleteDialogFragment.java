package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import com.example.myapplication.DB.IncidenciaDBHelper;

public class DeleteDialogFragment extends DialogFragment {
    IncidenciaDBHelper dbHelper;
    SQLiteDatabase db;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dbHelper = new IncidenciaDBHelper(getContext());
        db = dbHelper.getWritableDatabase();
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.deleteAll)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        boolean ok = dbHelper.deleteIncidenceById(db);
                        if(ok) {
                            Toast.makeText(getActivity(), getString(R.string.deleteAllToast), Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(getActivity(), "Gone wrong", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        getDialog().dismiss();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}