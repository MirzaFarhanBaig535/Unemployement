package com.example.unemployement.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unemployement.Models.WebinarModelHomeScreen;
import com.example.unemployement.Models.WehinarModel;
import com.example.unemployement.R;
import com.example.unemployement.databinding.WebinarLayoutBinding;

import java.util.ArrayList;

public class WebinarAdapterHomeScreen extends RecyclerView.Adapter<WebinarAdapterHomeScreen.WebinarViewHolder> {

    private Context mContext;
    private ArrayList<WebinarModelHomeScreen> models;
    private WebinarAdapter.ItemClickListener clickListener;

    public WebinarAdapterHomeScreen(Context mContext, ArrayList<WebinarModelHomeScreen> models, WebinarAdapter.ItemClickListener clickListener) {
        this.mContext = mContext;
        this.models = models;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public WebinarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.webinar_layout, parent, false);
        return new WebinarAdapterHomeScreen.WebinarViewHolder(view);
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

    public interface ItemClickListener {
        void onItemClick(WebinarModelHomeScreen webinar);
    }
}