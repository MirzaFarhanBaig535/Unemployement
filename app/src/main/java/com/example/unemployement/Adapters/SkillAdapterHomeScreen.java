package com.example.unemployement.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unemployement.Models.SoftSkillModelHomeScreen;
import com.example.unemployement.R;
import com.example.unemployement.databinding.SoftSkillLayoutBinding;

import java.util.ArrayList;

public class SkillAdapterHomeScreen extends RecyclerView.Adapter<SkillAdapterHomeScreen.SkillViewHolder> {
    private Context mContext;
    private ArrayList<SoftSkillModelHomeScreen> models;


    public SkillAdapterHomeScreen(Context mContext, ArrayList<SoftSkillModelHomeScreen> models) {
        this.mContext = mContext;
        this.models = models;
    }

    @NonNull
    @Override
    public SkillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.soft_skill_layout, parent, false);
        return new SkillAdapterHomeScreen.SkillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillViewHolder holder, int position) {
        holder.binding.imageView3.setImageResource(models.get(position).getSkillLogo());
        holder.binding.textView6.setText(models.get(position).getSkillTitle());
        holder.binding.textView8.setText(models.get(position).getSkillType());
        holder.binding.textView9.setText(models.get(position).getSkillMode());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class SkillViewHolder  extends RecyclerView.ViewHolder{

        SoftSkillLayoutBinding binding;

        public SkillViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = SoftSkillLayoutBinding.bind(itemView);
        }
    }
}
