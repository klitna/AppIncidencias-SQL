package com.example.myapplication;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.DB.IncidenciaDBHelper;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    IncidenciaDBHelper dbHelper;
    SQLiteDatabase db;
    ArrayList<Incidence> incidencesList = new ArrayList<Incidence>();
    int rows;

    public RecyclerViewAdapter(ListIncidences l, ArrayList<Incidence> i){
        incidencesList.addAll(i);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        View fList = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_incidences, parent, false);
        dbHelper = new IncidenciaDBHelper(parent.getContext());
        db = dbHelper.getWritableDatabase();
        rows=dbHelper.getCountRows();
        //incidencesList=dbHelper.getAllIncidences();
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int id) {
        holder.nameTextView.setText(incidencesList.get(id).getName());
        holder.urgenceTextView.setText("Urgency: "+incidencesList.get(id).getUrgency());
        holder.idTextView.setText("Id: "+String.valueOf(id));
        holder.dateTextView.setText(incidencesList.get(id).getDate());

    }

    @Override
    public int getItemCount() {
        return incidencesList.size();
    }
        public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView;
        TextView urgenceTextView;
        TextView idTextView;
        TextView dateTextView;
        ImageView stateCircle;
        GridLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameIncidenceItem);
            urgenceTextView = itemView.findViewById(R.id.urgenceIncidence);
            idTextView = itemView.findViewById(R.id.countUrgence);
            dateTextView = itemView.findViewById(R.id.dateIncidence);
            stateCircle = itemView.findViewById(R.id.stateCircle);
            layout = itemView.findViewById(R.id.itemList);
        }
    }
}



