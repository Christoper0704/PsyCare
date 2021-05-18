package com.psycare.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.transition.AutoTransition;
import androidx.transition.Scene;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;


public class AuthActivity extends AppCompatActivity {
    private ImageView btnBack, btnGoogle, btnFacebook;
    private TextView authTitle, btnLogin, btnSignUp;
    private ViewFlipper inputs;
    private Scene loginScene, signUpScene;
    private AuthViewModel model;

    private String currentTab;
    private final Transition transition = new AutoTransition();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        Bundle b = getIntent().getExtras();
        model = new ViewModelProvider(this).get(AuthViewModel.class);
        final Observer<String> selectedTabObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                currentTab = s;

                if(s.equals("Login")) {
                    authTitle.setText("Login");
                    TransitionManager.go(loginScene, transition);
                    btnLogin.setAlpha((float) 1);
                    btnSignUp.setAlpha((float) 0.5);
                    findViewById(R.id.login_line).setVisibility(View.VISIBLE);
                    findViewById(R.id.sign_up_line).setVisibility(View.GONE);
                } else {
                    authTitle.setText("Create Account");
                    TransitionManager.go(signUpScene, transition);
                    btnLogin.setAlpha((float) 0.5);
                    btnSignUp.setAlpha((float) 1);
                    findViewById(R.id.login_line).setVisibility(View.GONE);
                    findViewById(R.id.sign_up_line).setVisibility(View.VISIBLE);
                }
            }
        };
        model.getSelectedTab().observe(this, selectedTabObserver);
        model.getSelectedTab().setValue(b.getString("authType"));

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToOnboarding = new Intent(AuthActivity.this, OnboardingActivity.class);
                startActivity(goToOnboarding);
            }
        });

        authTitle = findViewById(R.id.auth_title);
        inputs = findViewById(R.id.inputs);
        loginScene = Scene.getSceneForLayout(inputs, R.layout.login, this);
        signUpScene = Scene.getSceneForLayout(inputs, R.layout.sign_up, this);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String authType = "Login";
                model.getSelectedTab().setValue(authType);
            }
        });

        btnSignUp = findViewById(R.id.btn_sign_up);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String authType = "Sign Up";
                model.getSelectedTab().setValue(authType);
            }
        });
    }
}