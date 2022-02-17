package com.example.unemployement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.unemployement.databinding.ActivityLoginPageBinding;

public class LoginPage extends AppCompatActivity {

    private ActivityLoginPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginPage.this, MainActivity.class));
                finishAffinity();
            }
        });

        binding.newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, RegistrationPage.class);

                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View, String>(binding.imageView, "logo_image");
                pairs[1] = new Pair<View, String>(binding.textView2, "logo_text");
                pairs[2] = new Pair<View, String>(binding.textView3, "sign_text");
                pairs[3] = new Pair<View, String>(binding.EmailLayout, "email_tran");
                pairs[4] = new Pair<View, String>(binding.PasswordLayout, "pass_tran");
                pairs[5] = new Pair<View, String>(binding.SignInBtn, "btn_tran");
                pairs[6] = new Pair<View, String>(binding.newAccount, "new_account");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginPage.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });
    }
}