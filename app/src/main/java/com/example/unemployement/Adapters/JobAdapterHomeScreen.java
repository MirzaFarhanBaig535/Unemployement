package com.example.unemployement.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unemployement.Models.JobModelHomeScreen;
import com.example.unemployement.Models.WebinarModelHomeScreen;
import com.example.unemployement.R;
import com.example.unemployement.databinding.JobLayoutBinding;

import java.util.ArrayList;

public class JobAdapterHomeScreen extends RecyclerView.Adapter<JobAdapterHomeScreen.JobViewHolder> {

    private Context mContext;
    private ArrayList<JobModelHomeScreen> models;
    private final ItemClickListener clickListener;

    public JobAdapterHomeScreen(Context mContext, ArrayList<JobModelHomeScreen> models, JobAdapterHomeScreen.ItemClickListener clickListener) {
        this.mContext = mContext;
        this.models = models;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.job_layout, parent, false);
        return new JobAdapterHomeScreen.JobViewHolder(view);
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
    public interface ItemClickListener {
        void onItemClick(JobModelHomeScreen job);
    }
}
