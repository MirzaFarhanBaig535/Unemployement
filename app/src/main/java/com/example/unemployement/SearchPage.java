package com.example.unemployement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.unemployement.databinding.ActivitySearchPageBinding;

public class SearchPage extends AppCompatActivity {

    private ActivitySearchPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}