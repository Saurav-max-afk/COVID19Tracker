package com.aptron.covid19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<States> statesList;

    public Adapter(Context ctx,List<States> statesList){
        this.inflater=LayoutInflater.from(ctx);
        this.statesList=statesList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.custom_list_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Name.setText(statesList.get(position).getName());
        holder.Confirmed.setText(statesList.get(position).getConfirmed());
        holder.Cured.setText(statesList.get(position).getCured());
        holder.Death.setText(statesList.get(position).getDeath());
        holder.Active.setText(statesList.get(position).getActive());

    }

    @Override
    public int getItemCount() {
        return statesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView Name,Confirmed,Cured,Death,Active;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Name=itemView.findViewById(R.id.tvName);
            Confirmed=itemView.findViewById(R.id.tvConfirmed);
            Cured=itemView.findViewById(R.id.tvCured);
            Death=itemView.findViewById(R.id.tvDeath);
            Active=itemView.findViewById(R.id.tvActive);
        }
    }
}
