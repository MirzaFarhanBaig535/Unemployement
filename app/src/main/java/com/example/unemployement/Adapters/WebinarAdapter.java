package com.example.unemployement.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.unemployement.Models.WehinarModel;
import com.example.unemployement.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class WebinarAdapter extends RecyclerView.Adapter<WebinarAdapter.WebinarViewHolder> {

    private Context context;
    private ArrayList<WehinarModel> webinar;
    private ItemClickListener clickListener;


    public WebinarAdapter(Context context, ArrayList<WehinarModel> webinar, ItemClickListener clickListener) {
        this.context = context;
        this.webinar = webinar;
        this.clickListener = clickListener;
    }

    @NonNull
    @NotNull
    @Override
    public WebinarViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new WebinarViewHolder(LayoutInflater.from(context).inflate(R.layout.webinarcard, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull WebinarAdapter.WebinarViewHolder holder, @SuppressLint("RecyclerView") int position) {
        WehinarModel data = webinar.get(position);

        holder.mTvWebinarTitle.setText(data.getTitle());
        holder.mTvwebinardate.setText(String.valueOf(data.getDate()));
        holder.mTvcategory.setText(String.valueOf(data.getCatagory()));
        holder.mtvspeaker.setText(String.valueOf(data.getSpeaker()));

//        Image Loading
        Glide.with(this.context).load(data.getThumbnail()).into(holder.mIvwebinarImg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(webinar.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return webinar.size();
    }



    public class WebinarViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIvwebinarImg;
        private TextView mTvWebinarTitle;
        private TextView mTvwebinardate;
        private TextView mTvcategory,mtvspeaker;

        public WebinarViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            mIvwebinarImg = itemView.findViewById(R.id.iv_web_thumbnail);
            mTvWebinarTitle = itemView.findViewById(R.id.tv_webinartitle);
            mTvwebinardate = itemView.findViewById(R.id.tv_webinarcarddate);
            mTvcategory = itemView.findViewById(R.id.tv_webinarcardcategory);
            mtvspeaker=itemView.findViewById(R.id.tv_webinarcardspeaker);
        }
    }
    public interface ItemClickListener {
        void onItemClick(WehinarModel webinar);
    }
}
