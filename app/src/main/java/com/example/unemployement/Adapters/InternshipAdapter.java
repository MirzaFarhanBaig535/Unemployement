package com.example.unemployement.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unemployement.Models.InternshipModel;
import com.example.unemployement.R;
import com.example.unemployement.databinding.InternshipLayoutBinding;

import java.util.ArrayList;

public class InternshipAdapter extends RecyclerView.Adapter<InternshipAdapter.InternViewHolder> {

    private Context mContext;
    private ArrayList<InternshipModel> models;

    public InternshipAdapter(Context mContext, ArrayList<InternshipModel> models) {
        this.mContext = mContext;
        this.models = models;
    }

    @NonNull
    @Override
    public InternViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.internship_layout, parent, false);
        return new InternshipAdapter.InternViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InternViewHolder holder, int position) {
        holder.binding.ProgDuration.setText(models.get(position).getInternDuration());
        holder.binding.ProgTitle.setText(models.get(position).getInternTitle());
        holder.binding.ProgLocation.setText(models.get(position).getInternLocation());
        holder.binding.ProgLogo.setImageResource(models.get(position).getInternLogo());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class InternViewHolder extends RecyclerView.ViewHolder{

        InternshipLayoutBinding binding;

        public InternViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = InternshipLayoutBinding.bind(itemView);
        }
    }
}
