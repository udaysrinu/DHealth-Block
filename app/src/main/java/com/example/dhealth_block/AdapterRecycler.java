package com.example.dhealth_block;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.Viewholder> {

    private List<Disease> diseaseList;

    public AdapterRecycler(List<Disease> diseaseList) {
        this.diseaseList = diseaseList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.diseasedetail,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        String diseaseName=diseaseList.get(position).getDisease();
        String doctorName=diseaseList.get(position).getDocname();
        String date= String.valueOf(diseaseList.get(position).getDate());
        holder.setData(diseaseName,date,doctorName);
    }

    @Override
    public int getItemCount() {
        return diseaseList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {

        private TextView doctorName,diseaseName,date;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            doctorName=itemView.findViewById(R.id.doctor);
            diseaseName=itemView.findViewById(R.id.disease);
            date=itemView.findViewById(R.id.date);
        }

        private void setData(String disesename,String  date,String doctorName){
            this.diseaseName.setText(disesename);
            this.date.setText(date);
            this.doctorName.setText(doctorName);
        }
    }
}
