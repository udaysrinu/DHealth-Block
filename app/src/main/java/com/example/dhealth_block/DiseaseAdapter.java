package com.example.dhealth_block;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DiseaseAdapter extends RecyclerView.Adapter<DiseaseAdapter.MyViewHolder>{
    private Context mContext;
    private List<Disease> DiseaseList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView disease,doctor,date,medicines;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            disease = (TextView) view.findViewById(R.id.disease);
            doctor = (TextView) view.findViewById(R.id.doctor);
            date = (TextView) view.findViewById(R.id.date);
            medicines = (TextView) view.findViewById(R.id.medicines);

            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    public DiseaseAdapter(Context mContext, List<Disease> DiseaseList, MedicalHistoryFragment medicalHistoryFragment) {
        this.mContext = mContext;
        this.DiseaseList= DiseaseList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_medical_history, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Disease album = DiseaseList.get(position);
        holder.disease.setText(album.getDiseaseName());
        holder.doctor.setText("Dr: "+album.getDoctorTreated());
        holder.date.setText("Date: "+album.getDate());
        holder.medicines.setText("/ Hospital: "+album.getMedicines());


        holder.thumbnail.setImageResource(R.drawable.doctor);
    }

    @Override
    public int getItemCount() {
        return DiseaseList.size();
    }
}
