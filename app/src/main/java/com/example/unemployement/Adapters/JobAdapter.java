package com.example.unemployement.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.unemployement.Models.JobModel;
import com.example.unemployement.Models.WehinarModel;
import com.example.unemployement.R;

import java.util.ArrayList;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder>{

    private final ItemClickListener clickListener;
    private Context context;
    private ArrayList<JobModel> jobs;
//    private WebinarAdapter.ItemClickListener clickListener;

//    public JobAdapter(Context context, ArrayList<JobModel> foods, ItemClickListener clickListener) {
//        this.context = context;
//        this.jobs = jobs;
//        this.clickListener = clickListener;
//    }

    public JobAdapter(Context context, ArrayList<JobModel> jobs,ItemClickListener clickListener) {
        this.context = context;
        this.jobs = jobs;
        this.clickListener = clickListener;
    }


    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new JobViewHolder(LayoutInflater.from(context).inflate(R.layout.cell_job, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull JobAdapter.JobViewHolder holder, @SuppressLint("RecyclerView") int position) {
        JobModel data = jobs.get(position);

        holder.mTvJobTitle.setText(data.getPosition());
        holder.mTvJobDate.setText(String.valueOf(data.getDuration()));
        holder.mTvJobPlace.setText(String.valueOf(data.getLocation()));
        holder.mTvJobCompany.setText(String.valueOf(data.getCompany()));

//        Image Loading
        Glide.with(this.context).load(data.getThumbnail()).into(holder.mIvJobImg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(jobs.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    public class JobViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIvJobImg;
        private TextView mTvJobTitle;
        private TextView mTvJobDate;
        private TextView mTvJobCompany;
        private TextView mTvJobPlace;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);

            mIvJobImg = itemView.findViewById(R.id.iv_jobImage);
            mTvJobTitle = itemView.findViewById(R.id.tv_jobTitle);
            mTvJobDate = itemView.findViewById(R.id.tv_exp);
            mTvJobCompany = itemView.findViewById(R.id.tv_companyName);
            mTvJobPlace = itemView.findViewById(R.id.tv_jobLocation);
        }
    }

    public interface ItemClickListener {
        void onItemClick(JobModel job);
    }
}
