package com.example.dhealth_block;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {

    private List<AppointmentClass> appointmentClassList;

    public Adapter(List<AppointmentClass> appointmentClassList) {
        this.appointmentClassList = appointmentClassList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.appointmentlist,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        String date=appointmentClassList.get(position).getDate();
        String symptoms=appointmentClassList.get(position).getSymptoms();
        holder.setdata(date,symptoms);
    }

    @Override
    public int getItemCount() {
        return appointmentClassList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {

        private TextView date,progress,note,symptoms, medicines;

        private void setdata(String date,String symptoms){
            this.date.setText(date);
//            this.progress.setText(progress);
            this.symptoms.setText(symptoms);
//            this.medicines.setText(medicines);
//            this.note.setText(note);
        }

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            date=itemView.findViewById(R.id.datetxt);
//            progress=itemView.findViewById(R.id.progresstxt);
            symptoms=itemView.findViewById(R.id.symptomstxt);
//            medicines=itemView.findViewById(R.id.medicinestxt);
//            note=itemView.findViewById(R.id.notestxt);

        }
    }
}
