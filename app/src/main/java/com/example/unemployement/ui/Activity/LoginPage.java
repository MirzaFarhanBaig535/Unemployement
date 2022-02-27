package com.example.unemployement.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.unemployement.databinding.ActivityLoginPageBinding;
import com.example.unemployement.utils.NetworkChangeListener;
import com.example.unemployement.utils.SessionManager;

public class LoginPage extends AppCompatActivity {

    private ActivityLoginPageBinding binding;
    private NetworkChangeListener networkChangeListener=new NetworkChangeListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginPage.this, HomeScreen.class));
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