package com.example.dhealth_block;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.Viewholder> {

    private List<Disease> diseaseList;
    private Context context;
    String diseasename;
    String doctorNamestr;
    String datestr;
    String license;
    String id;


    public AdapterRecycler(List<Disease> diseaseList,Context context) {
        this.diseaseList = diseaseList;
        this.context=context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.diseasedetail,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
         diseasename=diseaseList.get(position).getDisease();
         doctorNamestr=diseaseList.get(position).getDocname();
         datestr= String.valueOf(diseaseList.get(position).getDate());
         license=String.valueOf(diseaseList.get(position).getLicense());
         id=String.valueOf(diseaseList.get(position).getPatientid());
        holder.setData(diseasename,datestr,doctorNamestr);
    }

    @Override
    public int getItemCount() {
        return diseaseList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {

        private TextView doctorName,diseaseName,date;
        private CardView cardView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            doctorName=itemView.findViewById(R.id.doctor);
            diseaseName=itemView.findViewById(R.id.disease);
            date=itemView.findViewById(R.id.date);
            cardView=itemView.findViewById(R.id.card_view);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Bundle a=new Bundle();\
//                    int itemPosition =.getChildLayoutPosition(context);
                    Intent intent=new Intent(context,NewAppointment.class);
                    intent.putExtra("disease",diseasename);
                    intent.putExtra("date",datestr);
                    intent.putExtra("doctor", doctorNamestr);
                    intent.putExtra("license",license);
                    intent.putExtra("id",id);
                    context.startActivity(intent);
                }
            });
        }

        private void setData(String disesename,String  date,String doctorName){
            this.diseaseName.setText(disesename);
            this.date.setText(date);
            this.doctorName.setText(doctorName);
        }
    }
}
