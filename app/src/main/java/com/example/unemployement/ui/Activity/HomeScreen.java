package com.example.unemployement.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.example.unemployement.Adapters.IntershipAdapterHomeScreen;
import com.example.unemployement.Adapters.JobAdapter;
import com.example.unemployement.Adapters.JobAdapterHomeScreen;
import com.example.unemployement.Adapters.SkillAdapterHomeScreen;
import com.example.unemployement.Adapters.WebinarAdapter;
import com.example.unemployement.Adapters.WebinarAdapterHomeScreen;
import com.example.unemployement.Models.InternshipModelHomeScreen;
import com.example.unemployement.Models.JobModel;
import com.example.unemployement.Models.JobModelHomeScreen;
import com.example.unemployement.Models.SoftSkillModelHomeScreen;
import com.example.unemployement.Models.WebinarModelHomeScreen;
import com.example.unemployement.Models.WehinarModel;
import com.example.unemployement.R;
import com.example.unemployement.databinding.ActivityHomeScreenBinding;
import com.example.unemployement.utils.NetworkChangeListener;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity implements  WebinarAdapter.ItemClickListener, JobAdapterHomeScreen.ItemClickListener{
    private NetworkChangeListener networkChangeListener=new NetworkChangeListener();
    private Toolbar myToolbar;

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
        String[] progTitle = {"Get Started with Python", "Python Fundamentals", "Netlix Student Program", "Work at Amazon"};
        String[] progType = {"Programming", "Programming", "Career Counselling", "Job"};

        models = new ArrayList<>();
        for (int i = 0; i<progLogo.length; i++){
            WebinarModelHomeScreen model = new WebinarModelHomeScreen(progLogo[i], progTitle[i], progType[i]);
            models.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.WebinarList.setLayoutManager(layoutManager);

        adapter = new WebinarAdapterHomeScreen(HomeScreen.this, models,HomeScreen.this);
        binding.WebinarList.setAdapter(adapter);

        int[] internLogo = {R.drawable.netflix, R.drawable.google, R.drawable.flutter, R.drawable.amazon};
        String[] internTitle = {"Product Designer", "Backend Intern", "Flutter Developer", "UX Designer"};
        String[] internLocation = {"San Francisco", "Google.WFH", "Geetyan.WFH", "Amazon.WFH"};
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

        int[] skillLogo = {R.drawable.business, R.drawable.cv};
        String[] skillTitle = {"Entrepreneurship Development", "Resume Building"};
        String[] skillType = {"Communication", "Communication"};
        String[] skillMode = {"Life Skill", "Life Skill"};

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
        String[] jobLocation = {"San Francisco", "Google.WFH", "Geetyan.WFH", "Amazon.WFH"};
        String[] jobDuration = {"2 Months", "3 Months", "4 Months", "2 Months"};

        jobModelHomeScreens = new ArrayList<>();
        for (int i=0; i<jobLogo.length; i++){
            JobModelHomeScreen model = new JobModelHomeScreen(jobLogo[i], jobTitle[i], jobLocation[i], jobDuration[i]);
            jobModelHomeScreens.add(model);
        }

        jobAdapterHomeScreen = new JobAdapterHomeScreen(this, jobModelHomeScreens,HomeScreen.this);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.JobsList.setLayoutManager(layoutManager3);
        binding.JobsList.setAdapter(jobAdapterHomeScreen);
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

    public void gotooppotunitieswebinar(View view) {
        Intent intent = new Intent(HomeScreen.this, MainActivity.class);
        intent.putExtra("category","Webinars");
        startActivity(intent);
    }

    public void gotooppotunitiesInternship(View view) {
        Intent intent = new Intent(HomeScreen.this, MainActivity.class);
        intent.putExtra("category","Internships");
        startActivity(intent);
    }


    public void gotooppotunitiessoft(View view) {
        Intent intent = new Intent(HomeScreen.this, MainActivity.class);
        intent.putExtra("category","Soft Skills");
        startActivity(intent);
    }

    public void gotooppotunitiesJob(View view) {
        Intent intent = new Intent(HomeScreen.this, MainActivity.class);
        intent.putExtra("category","Jobs");
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub

        new AlertDialog.Builder(HomeScreen.this)
                .setTitle("Exit")
                .setMessage("Do you really want to exit?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.finishAffinity(HomeScreen.this);
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();

    }

    @Override
    public void onItemClick(WehinarModel webinar) {
        Intent intent = new Intent(getApplicationContext(), WebinarDescActivity.class);
        intent.putExtra("title",webinar.getTitle());
        intent.putExtra("desc",webinar.getDesc());
        intent.putExtra("id",webinar.getId());
        intent.putExtra("date",webinar.getDate());
        intent.putExtra("category",webinar.getCatagory());
        intent.putExtra("speaker",webinar.getSpeaker());
        intent.putExtra("thumbnail",webinar.getThumbnail());
        startActivity(intent);

    }


    @Override
    public void onItemClick(JobModelHomeScreen job) {
        Intent intent = new Intent(getApplicationContext(), JobDesc.class);
        intent.putExtra("position",job.getJobTitle());
        intent.putExtra("desc","Not Found");
        intent.putExtra("duration",job.getJobDuration());
        intent.putExtra("company","Amazon");
        intent.putExtra("location",job.getJobLocation());
        intent.putExtra("type","WFH");
        intent.putExtra("requirements","Not Found");
        intent.putExtra("thumbnail",job.getJobLogo());
        startActivity(intent);
    }

    public void gotoOppurtunities(View view) {
        Intent intent = new Intent(HomeScreen.this, MainActivity.class);
        startActivity(intent);
    }
}