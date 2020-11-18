package com.example.myapplication;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DB.IncidenciaDBHelper;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    IncidenciaDBHelper dbHelper;
    SQLiteDatabase db;
    ArrayList<Incidence> incidencesList = new ArrayList<Incidence>();
    int rows;

    public RecyclerViewAdapter(ListIncidences l, ArrayList<Incidence> i){
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        dbHelper = new IncidenciaDBHelper(parent.getContext());
        db = dbHelper.getWritableDatabase();
        rows=dbHelper.getCountRows();
        incidencesList=dbHelper.getAllIncidences();
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int id) {
        holder.nameTextView.setText(incidencesList.get(id).getName());
        holder.urgenceTextView.setText(incidencesList.get(id).getUrgence());
        holder.idTextView.setText(id);
    }

    @Override
    public int getItemCount() {
        return incidencesList.size();
    }

        public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView;
        TextView urgenceTextView;
        TextView idTextView;
        GridLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameIncidenceItem);
            urgenceTextView = itemView.findViewById(R.id.urgenceIncidence);
            idTextView = itemView.findViewById(R.id.countUrgence);
            layout = itemView.findViewById(R.id.itemList);
        }
    }
}



