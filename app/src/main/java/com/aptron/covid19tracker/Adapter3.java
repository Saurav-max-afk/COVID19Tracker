package com.aptron.covid19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter3 extends RecyclerView.Adapter<Adapter3.ViewHolder> {
    LayoutInflater inflater;
    List<DistrictModel1> districtList;


    public Adapter3(Context ctx,List<DistrictModel1> districtList){
        this.inflater=LayoutInflater.from(ctx);
        this.districtList=districtList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.customlist3,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Name.setText(districtList.get(position).getDistrict());
        holder.Confirmed.setText(districtList.get(position).getConfirmed());
        holder.Cured.setText(districtList.get(position).getRecovered());
        holder.Death.setText(districtList.get(position).getDeceased());
        holder.Active.setText(districtList.get(position).getActive());

    }

    @Override
    public int getItemCount() {
        return districtList.size();
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
