package com.example.unemployement.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.unemployement.R;
import com.example.unemployement.ui.Fragment.SoftskillFragment;

public class EntrepreneurshipActivity extends AppCompatActivity {
    private ImageView cvback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrepreneurship);
        cvback=findViewById(R.id.enback);

        cvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


}