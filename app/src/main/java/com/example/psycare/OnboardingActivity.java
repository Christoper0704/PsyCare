package com.example.psycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

public class OnboardingActivity extends AppCompatActivity {
    private CarouselView carouselView;
    private Button btnGetStarted;
    private TextView btnLogin;

    private final int[] onboardingViews = {R.layout.onboarding_1, R.layout.onboarding_2, R.layout.onboarding_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(onboardingViews.length);
        carouselView.setViewListener(viewListener);

        btnGetStarted = findViewById(R.id.btn_get_started);
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSignUp = new Intent(OnboardingActivity.this, AuthActivity.class);
                Bundle b = new Bundle();
                b.putString("authType", "Sign Up");
                goToSignUp.putExtras(b);
                startActivity(goToSignUp);
            }
        });

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLogin = new Intent(OnboardingActivity.this, AuthActivity.class);
                Bundle b = new Bundle();
                b.putString("authType", "Login");
                goToLogin.putExtras(b);
                startActivity(goToLogin);
            }
        });
    }

    ViewListener viewListener = new ViewListener() {

        @Override
        public View setViewForPosition(int position) {
            View customView = getLayoutInflater().inflate(onboardingViews[position], null);

            return customView;
        }
    };
}