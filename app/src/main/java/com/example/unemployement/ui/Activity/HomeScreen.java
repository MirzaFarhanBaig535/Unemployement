package com.example.unemployement.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;

import com.example.unemployement.Adapters.IntershipAdapterHomeScreen;
import com.example.unemployement.Adapters.JobAdapterHomeScreen;
import com.example.unemployement.Adapters.SkillAdapterHomeScreen;
import com.example.unemployement.Adapters.WebinarAdapterHomeScreen;
import com.example.unemployement.Models.InternshipModelHomeScreen;
import com.example.unemployement.Models.JobModelHomeScreen;
import com.example.unemployement.Models.SoftSkillModelHomeScreen;
import com.example.unemployement.Models.WebinarModelHomeScreen;
import com.example.unemployement.R;
import com.example.unemployement.databinding.ActivityHomeScreenBinding;
import com.example.unemployement.utils.NetworkChangeListener;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {
    private NetworkChangeListener networkChangeListener=new NetworkChangeListener();

    private ActivityHomeScreenBinding binding;
    private ArrayList<WebinarModelHomeScreen> models;
    private WebinarAdapterHomeScreen adapter;

    private ArrayList<InternshipModelHomeScreen> internshipModelHomeScreens;
    private IntershipAdapterHomeScreen internshipAdapter;

    private ArrayList<SoftSkillModelHomeScreen> softSkillModelHomeScreens;
    private SkillAdapterHomeScreen skillAdapterHomeScreen;

    private ArrayList<JobModelHomeScreen> jobModelHomeScreens;
    private JobAdapterHomeScreen jobAdapterHomeScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] progLogo = {R.drawable.python, R.drawable.python, R.drawable.python, R.drawable.python};
        String[] progTitle = {"Get Started with Python", "Get Started with Python", "Get Started with Python", "Get Started with Python"};
        String[] progType = {"Programming", "Programming", "Programming", "Programming"};

        models = new ArrayList<>();
        for (int i = 0; i<progLogo.length; i++){
            WebinarModelHomeScreen model = new WebinarModelHomeScreen(progLogo[i], progTitle[i], progType[i]);
            models.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.WebinarList.setLayoutManager(layoutManager);

        adapter = new WebinarAdapterHomeScreen(HomeScreen.this, models);
        binding.WebinarList.setAdapter(adapter);

        int[] internLogo = {R.drawable.netflix, R.drawable.google, R.drawable.flutter, R.drawable.amazon};
        String[] internTitle = {"Product Designer", "Backend Intern", "Flutter Developer", "UX Designer"};
        String[] internLocation = {"Netflix.San Francisco", "Google.WFH", "Geetyan.WFH", "Amazon.WFH"};
        String[] internDuration = {"2 Months", "3 Months", "4 Months", "2 Months"};

        internshipModelHomeScreens = new ArrayList<>();
        for (int i=0; i<internLogo.length; i++){
            InternshipModelHomeScreen model = new InternshipModelHomeScreen(internLogo[i], internTitle[i], internLocation[i], internDuration[i]);
            internshipModelHomeScreens.add(model);
        }

        internshipAdapter = new IntershipAdapterHomeScreen(this, internshipModelHomeScreens);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.InternshipList.setLayoutManager(layoutManager1);
        binding.InternshipList.setAdapter(internshipAdapter);

        int[] skillLogo = {R.drawable.python, R.drawable.python, R.drawable.python, R.drawable.python};
        String[] skillTitle = {"Art of Communication", "Art of Communication", "Art of Communication", "Art of Communication"};
        String[] skillType = {"Communication", "Communication", "Communication", "Communication"};
        String[] skillMode = {"Life Skill", "Life Skill", "Life Skill", "Life Skill"};

        softSkillModelHomeScreens = new ArrayList<>();
        for (int i=0; i<skillLogo.length; i++){
            SoftSkillModelHomeScreen model = new SoftSkillModelHomeScreen(skillLogo[i], skillTitle[i], skillType[i], skillMode[i]);
            softSkillModelHomeScreens.add(model);
        }

        skillAdapterHomeScreen = new SkillAdapterHomeScreen(this, softSkillModelHomeScreens);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.SoftSkillList.setLayoutManager(layoutManager2);
        binding.SoftSkillList.setAdapter(skillAdapterHomeScreen);

        int[] jobLogo = {R.drawable.netflix, R.drawable.google, R.drawable.flutter, R.drawable.amazon};
        String[] jobTitle = {"Product Designer", "Backend Intern", "Flutter Developer", "UX Designer"};
        String[] jobLocation = {"Netflix.San Francisco", "Google.WFH", "Geetyan.WFH", "Amazon.WFH"};
        String[] jobDuration = {"2 Months", "3 Months", "4 Months", "2 Months"};

        jobModelHomeScreens = new ArrayList<>();
        for (int i=0; i<jobLogo.length; i++){
            JobModelHomeScreen model = new JobModelHomeScreen(jobLogo[i], jobTitle[i], jobLocation[i], jobDuration[i]);
            jobModelHomeScreens.add(model);
        }

        jobAdapterHomeScreen = new JobAdapterHomeScreen(this, jobModelHomeScreens);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.JobsList.setLayoutManager(layoutManager3);
        binding.JobsList.setAdapter(jobAdapterHomeScreen);
    }

    public void gotooppotunities(View view) {
        startActivity(new Intent(HomeScreen.this,MainActivity.class));
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
}