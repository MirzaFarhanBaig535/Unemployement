package com.example.unemployement.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unemployement.Models.JobModel;
import com.example.unemployement.R;
import com.example.unemployement.databinding.JobLayoutBinding;

import java.util.ArrayList;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {

    private Context mContext;
    private ArrayList<JobModel> models;

    public JobAdapter(Context mContext, ArrayList<JobModel> models) {
        this.mContext = mContext;
        this.models = models;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.job_layout, parent, false);
        return new JobAdapter.JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        holder.binding.JobDuration.setText(models.get(position).getJobDuration());
        holder.binding.JobLocation.setText(models.get(position).getJobLocation());
        holder.binding.JobTitle.setText(models.get(position).getJobTitle());
        holder.binding.JobLogo.setImageResource(models.get(position).getJobLogo());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class JobViewHolder extends RecyclerView.ViewHolder{

        JobLayoutBinding binding;
        public JobViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = JobLayoutBinding.bind(itemView);
        }
    }
}
