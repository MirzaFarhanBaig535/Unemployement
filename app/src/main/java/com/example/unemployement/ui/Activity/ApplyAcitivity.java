package com.example.unemployement.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.unemployement.R;
import com.example.unemployement.utils.NetworkChangeListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApplyAcitivity extends AppCompatActivity {
    private EditText username;
    private EditText email;
    private EditText password;
    private EditText confirmpassword;
    private String str;
    private LinearLayout progressregister;
    private String token;
    private int id;

    private NetworkChangeListener networkChangeListener=new NetworkChangeListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_acitivity);

        username=findViewById(R.id.et_username);
        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_password);
        confirmpassword=findViewById(R.id.et_confirmpassword);
    }

    private boolean validateUsername() {
        String val = username.getText().toString().trim();
        String checkspaces = "Aw{1,20}z";

        if (val.isEmpty()) {
            username.setError("Field can not be empty");
            return false;
        } else if (val.length() > 20) {
            username.setError("Username is too large!");
            return false;
        } else {
            username.setError(null);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = email.getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            email.setError("Invalid Email!");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = password.getText().toString().trim();

        if (val.isEmpty()) {
            password.setError("Field can not be empty");
            return false;
        } else {
            password.setError(null);
            return true;
        }
    }
    private boolean confirmpassword(){
        String val = confirmpassword.getText().toString().trim();

        if (val.isEmpty()) {
            confirmpassword.setError("Field can not be empty");
            return false;
        } else {
            confirmpassword.setError(null);
            return true;
        }

    }

    public void movetologin(View view) {

    }

    public void registerUser1(View view) {
        if ( validateUsername() && validateEmail() && validatePassword() && confirmpassword()){
            startActivity(new Intent(ApplyAcitivity.this, ApplySuccessfull.class));
            finish();
        }
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

    public void movetohome(View view) {
        Intent intent=new Intent(ApplyAcitivity.this, HomeScreen.class);
        startActivity(intent);
        finish();
    }
}