package com.example.unemployement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.unemployement.Adapters.InternshipAdapter;
import com.example.unemployement.Adapters.SkillAdapter;
import com.example.unemployement.Adapters.WebinarAdapter;
import com.example.unemployement.Models.InternshipModel;
import com.example.unemployement.Models.SoftSkillModel;
import com.example.unemployement.Models.WebinarModel;
import com.example.unemployement.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<WebinarModel> models;
    private WebinarAdapter adapter;

    private ArrayList<InternshipModel> internshipModels;
    private InternshipAdapter internshipAdapter;

    private ArrayList<SoftSkillModel> softSkillModels;
    private SkillAdapter skillAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] progLogo = {R.drawable.python, R.drawable.python, R.drawable.python, R.drawable.python};
        String[] progTitle = {"Get Started with Python", "Get Started with Python", "Get Started with Python", "Get Started with Python"};
        String[] progType = {"Programming", "Programming", "Programming", "Programming"};

        models = new ArrayList<>();
        for (int i = 0; i<progLogo.length; i++){
            WebinarModel model = new WebinarModel(progLogo[i], progTitle[i], progType[i]);
            models.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.WebinarList.setLayoutManager(layoutManager);

        adapter = new WebinarAdapter(MainActivity.this, models);
        binding.WebinarList.setAdapter(adapter);

        int[] internLogo = {R.drawable.netflix, R.drawable.google, R.drawable.flutter, R.drawable.amazon};
        String[] internTitle = {"Product Designer\nInternship", "Backend Intern", "Flutter Developer", "UX Designer"};
        String[] internLocation = {"Netflix.San Francisco", "Google.WFH", "Geetyan.WFH", "Amazon.WFH"};
        String[] internDuration = {"2 Months", "3 Months", "4 Months", "2 Months"};

        internshipModels = new ArrayList<>();
        for (int i=0; i<internLogo.length; i++){
            InternshipModel model = new InternshipModel(internLogo[i], internTitle[i], internLocation[i], internDuration[i]);
            internshipModels.add(model);
        }

        internshipAdapter = new InternshipAdapter(this, internshipModels);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.InternshipList.setLayoutManager(layoutManager1);
        binding.InternshipList.setAdapter(internshipAdapter);

        int[] skillLogo = {R.drawable.python, R.drawable.python, R.drawable.python, R.drawable.python};
        String[] skillTitle = {"Art of Communication", "Art of Communication", "Art of Communication", "Art of Communication"};
        String[] skillType = {"Communication", "Communication", "Communication", "Communication"};
        String[] skillMode = {"Life Skill", "Life Skill", "Life Skill", "Life Skill"};

        softSkillModels = new ArrayList<>();
        for (int i=0; i<skillLogo.length; i++){
            SoftSkillModel model = new SoftSkillModel(skillLogo[i], skillTitle[i], skillType[i], skillMode[i]);
            softSkillModels.add(model);
        }

        skillAdapter = new SkillAdapter(this, softSkillModels);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.SoftSkillList.setLayoutManager(layoutManager2);
        binding.SoftSkillList.setAdapter(skillAdapter);
    }
}