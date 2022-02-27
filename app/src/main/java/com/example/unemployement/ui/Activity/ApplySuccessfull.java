package com.example.unemployement.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.unemployement.R;

public class ApplySuccessfull extends AppCompatActivity {
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_successfull);
    }
    @Override
    public void onBackPressed() {
        Intent moveback =
                new Intent(ApplySuccessfull.this, MainActivity.class);
        startActivity(moveback);
        finish();
    }

    public void gotohome(View view) {
        Intent moveback =
                new Intent(ApplySuccessfull.this, HomeScreen.class);
        startActivity(moveback);
        finish();
    }
}