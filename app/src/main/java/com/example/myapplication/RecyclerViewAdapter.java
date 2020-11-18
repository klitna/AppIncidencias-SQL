package com.example.myapplication;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DB.IncidenciaDBHelper;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    IncidenciaDBHelper dbHelper;
    SQLiteDatabase db;

    String [] incidenceNames;
    String [] incidenceUrgences;
    int rows;
    final Context context;

    public RecyclerViewAdapter(Context con, String[] arrN, String[] arrU, int count){
        incidenceNames = arrN;
        incidenceUrgences=arrU;
        rows=count;
        context = con;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        dbHelper = new IncidenciaDBHelper(parent.getContext());
        db = dbHelper.getWritableDatabase();
        rows=dbHelper.getCountRows();
        incidenceNames=dbHelper.getIncidenceNames();
        incidenceUrgences=dbHelper.getUrgences();

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int id) {
        holder.nameTextView.setText(incidenceNames[id]);
        holder.urgenceTextView.setText(incidenceUrgences[id]);
        holder.idTextView.setText(id);
    }

    @Override
    public int getItemCount() {
        return incidenceNames.length;
    }

        public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView;
        TextView urgenceTextView;
        TextView idTextView;
        AbsoluteLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameIncidenceItem);
            layout = itemView.findViewById(R.id.itemList);
        }
    }
}



