package com.example.psycare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.synnapps.carouselview.ViewListener;

public class OnboardingActivity extends AppCompatActivity {
    CarouselView carouselView;
    Button btn_get_started;
    TextView btn_login;

    int[] onboardingViews = {R.layout.onboarding_1, R.layout.onboarding_2, R.layout.onboarding_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(onboardingViews.length);
        carouselView.setViewListener(viewListener);

        btn_get_started = findViewById(R.id.btn_get_started);
        btn_get_started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to create account
            }
        });

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to login
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