package com.example.unemployement.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unemployement.Models.WebinarModel;
import com.example.unemployement.R;
import com.example.unemployement.databinding.WebinarLayoutBinding;

import java.util.ArrayList;

public class WebinarAdapter extends RecyclerView.Adapter<WebinarAdapter.WebinarViewHolder> {

    private Context mContext;
    private ArrayList<WebinarModel> models;

    public WebinarAdapter(Context mContext, ArrayList<WebinarModel> models) {
        this.mContext = mContext;
        this.models = models;
    }

    @NonNull
    @Override
    public WebinarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.webinar_layout, parent, false);
        return new WebinarAdapter.WebinarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WebinarViewHolder holder, int position) {
        holder.binding.imageView3.setImageResource(models.get(position).getImageResource());
        holder.binding.textView6.setText(models.get(position).getProgramName());
        holder.binding.textView8.setText(models.get(position).getProgramType());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class WebinarViewHolder extends RecyclerView.ViewHolder{

        WebinarLayoutBinding binding;

        public WebinarViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = WebinarLayoutBinding.bind(itemView);
        }
    }
}
