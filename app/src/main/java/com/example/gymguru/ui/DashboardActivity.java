package com.example.gymguru.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gymguru.R;
import com.example.gymguru.databinding.ActivityDashboardBinding;

public class DashboardActivity extends AppCompatActivity {

    private ActivityDashboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_dashboard);
    }
}