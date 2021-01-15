package com.example.myapplication;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.DB.IncidenciaDBHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    IncidenciaDBHelper dbHelper;
    SQLiteDatabase db;
    View fList;
    ArrayList<Incidence> incidencesList = new ArrayList<Incidence>();
    int rows;
    Context context;
    ViewHolder holderGlobal = null;
    public RecyclerViewAdapter(ArrayList<Incidence> i){
        incidencesList.addAll(i);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        fList = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_incidences, parent, false);
        dbHelper = new IncidenciaDBHelper(parent.getContext());
        db = dbHelper.getWritableDatabase();
        rows=dbHelper.getCountRows();
        ViewHolder holder = new ViewHolder(view);
        context = parent.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int id) {
        holderGlobal = holder;
        sendDataToAdapter(holder, id);
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

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameIncidenceItem);
            urgenceTextView = itemView.findViewById(R.id.urgenceIncidence);
            idTextView = itemView.findViewById(R.id.countUrgence);
            dateTextView = itemView.findViewById(R.id.dateIncidence);
            stateCircle = itemView.findViewById(R.id.stateCircle);
            layout = itemView.findViewById(R.id.itemList);

            ImageButton goToIncidence = itemView.findViewById(R.id.goToIncidenceButton);
            goToIncidence.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String value="Hello world";
                    Intent i = new Intent(itemView.getContext(), IncidenceInfoActivity.class);
                    i.putExtra("name",nameTextView.getText().toString());
                    i.putExtra("urgence",urgenceTextView.getText().toString());
                    i.putExtra( "date", dateTextView.getText().toString());
                    i.putExtra("id", idTextView.getText().toString().replace("Id: ", ""));
                    itemView.getContext().startActivity(i);
                }
            });

            ImageButton deleteIncidence = itemView.findViewById(R.id.deleteItem);
            deleteIncidence.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    DeleteDialogFragment dialog = new DeleteDialogFragment();
                    db = dbHelper.getWritableDatabase();
                    dbHelper.deleteIncidence(db, String.valueOf(getAdapterPosition()));
                    incidencesList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    notifyItemRangeChanged(getAdapterPosition(),incidencesList.size());
                }
            });
        }
    }

    public void sendDataToAdapter(@NonNull ViewHolder holder, int id){
        holder.nameTextView.setText(incidencesList.get(id).getName());
        holder.urgenceTextView.setText(context.getResources().getString(R.string.urgence)+": " +incidencesList.get(id).getUrgency());
        holder.idTextView.setText("Id: "+String.valueOf(id));
        holder.dateTextView.setText(incidencesList.get(id).getDate());
        if (incidencesList.get(id).getState()==0)
            holder.stateCircle.setBackground(ContextCompat.getDrawable(context, R.drawable.red_circle));
        else if(incidencesList.get(id).getState()==1)
            holder.stateCircle.setBackground(ContextCompat.getDrawable(context, R.drawable.orange_circle));
        else
            holder.stateCircle.setBackground(ContextCompat.getDrawable(context, R.drawable.green_circle));
    }

    public void orderByDate(){

    }

}