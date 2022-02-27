package com.example.unemployement.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.unemployement.R;
import com.example.unemployement.utils.NetworkChangeListener;

public class JobDesc extends AppCompatActivity {
    private NetworkChangeListener networkChangeListener=new NetworkChangeListener();
    private ImageView btnBack;
    private TextView webinarCategory;
    private TextView webinarSpeaker;
    private TextView webinarDesc;
    private TextView webinarDate;
    private TextView webinarTitle;
    private ImageView webinarthumbnail;
    private int webinarid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_desc);

        webinarthumbnail=findViewById(R.id.iv_jobdesc_img);
        btnBack=findViewById(R.id.webback1);
        webinarCategory=findViewById(R.id.jobreq);
        webinarDesc=findViewById(R.id.jobdesc);
        webinarDate=findViewById(R.id.tv_location);
        webinarTitle=findViewById(R.id.tv_jobtitledesc);
        webinarSpeaker=findViewById(R.id.tv_companyName);


        Intent intent = getIntent();
        webinarTitle.setText(intent.getStringExtra("position"));
        webinarDate.setText(intent.getStringExtra("location"));
        webinarDesc.setText(intent.getStringExtra("desc"));
        webinarCategory.setText(intent.getStringExtra("requirements"));
        webinarSpeaker.setText(intent.getStringExtra("company"));

        String imageUrl = intent.getStringExtra("thumbnail");
        Glide.with(this).load(imageUrl).into(webinarthumbnail);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gobackhome();
            }
        });
    }
    @Override
    protected void onStart() {
        IntentFilter filter1=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListener,filter1);
        super.onStart();
    }


    @Override
    protected void onStop() {
        unregisterReceiver(networkChangeListener);
        super.onStop();
    }

    public void gobackhome() {
        onBackPressed();
    }



    public void onApply(View view) {
        startActivity(new Intent(JobDesc.this,ApplyAcitivity.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}