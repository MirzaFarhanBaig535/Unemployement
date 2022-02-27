package com.example.unemployement.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.unemployement.Adapters.CategoryAdapter;
import com.example.unemployement.JoinUs;
import com.example.unemployement.R;
import com.example.unemployement.databinding.ActivityMainBinding;
import com.example.unemployement.ui.Fragment.InternshipFragment;
import com.example.unemployement.ui.Fragment.JobsFragment;
import com.example.unemployement.ui.Fragment.JoinUsFragment;
import com.example.unemployement.ui.Fragment.SettingsFragment;
import com.example.unemployement.ui.Fragment.SoftskillFragment;
import com.example.unemployement.ui.Fragment.WebinarsFragment;
import com.example.unemployement.utils.NetworkChangeListener;

public class MainActivity extends AppCompatActivity implements CategoryAdapter.CategoryClickListener{
    private NetworkChangeListener networkChangeListener=new NetworkChangeListener();
    private RecyclerView mRcCategories;
    private String categoryValue="Webinars",categoryValue1 ;
    private ImageView cvback;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mRcCategories = findViewById(R.id.rc_news_categories);
        mRcCategories.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false));

        CategoryAdapter categoryAdapter = new CategoryAdapter(MainActivity.this);
        categoryAdapter.setListener(this);
        mRcCategories.setAdapter(categoryAdapter);

        cvback=findViewById(R.id.mainback);

        cvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        categoryValue = categoryValue1;

        Fragment fragment = new WebinarsFragment();


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();




    }

    @Override
    public void onCategoryClicked(String categoryname) {
        categoryValue = categoryname;

        Fragment fragment = null;
        switch (categoryValue){
            case "Webinars":
                fragment = new WebinarsFragment();
                break;
            case "Soft Skills":
                fragment = new SoftskillFragment();
                break;
            case "Jobs":
                fragment = new JobsFragment();
                break;
            case "Internship":
                fragment = new InternshipFragment();
                break;
            case "Join Us":
                fragment = new JoinUsFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();


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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}