package com.example.unemployement.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.unemployement.R;
import com.example.unemployement.utils.NetworkChangeListener;

public class WebinarDescActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_webinar_desc);
        webinarthumbnail=findViewById(R.id.iv_pdt_img);
        btnBack=findViewById(R.id.webback1);
        webinarCategory=findViewById(R.id.tv_cardcategory);
        webinarDesc=findViewById(R.id.webinardesc);
        webinarDate=findViewById(R.id.tv_carddate);
        webinarTitle=findViewById(R.id.tv_cardtitle);
        webinarSpeaker=findViewById(R.id.tv_cardspeaker);


        Intent intent = getIntent();
        webinarTitle.setText(intent.getStringExtra("title"));
        webinarDate.setText(intent.getStringExtra("date"));
        webinarDesc.setText(intent.getStringExtra("desc"));
        webinarCategory.setText(intent.getStringExtra("category"));
        webinarSpeaker.setText(intent.getStringExtra("speaker"));
        webinarid = (intent.getIntExtra("id",1));


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
        startActivity(new Intent(WebinarDescActivity.this,HomeScreen.class));
        finish();
    }
}