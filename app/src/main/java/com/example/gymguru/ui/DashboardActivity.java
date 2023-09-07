package com.example.gymguru.ui;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.gymguru.R;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.MenuItem;


import android.widget.FrameLayout;


import com.example.gymguru.databinding.ActivityDashboardBinding;

import com.example.gymguru.fragments.ExerciseFragment;
import com.example.gymguru.fragments.HomeFragment;
;
import com.example.gymguru.fragments.MealPlaneFragment;
import com.example.gymguru.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class DashboardActivity extends AppCompatActivity {

    private ActivityDashboardBinding binding;

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        frameLayout = findViewById(R.id.frameContainer);


        getSupportFragmentManager().beginTransaction().replace(binding.frameContainer.getId(), new HomeFragment()).commit();


        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int pos = item
                        .getItemId();
                if (pos == R.id.bottom_home) {
                    callFragment(new HomeFragment());
                    return true;
                }
                if (pos == R.id.bottom_meal) {
                    callFragment(new MealPlaneFragment());
                    return true;
                }
                if (pos == R.id.bottom_exercise) {
                    callFragment(new ExerciseFragment());
                    return true;
                }
                if (pos == R.id.bottom_profile) {
                    callFragment(new ProfileFragment());
                    return true;
                }

                return false;
        }
    });


}


    private void callFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_out_right, android.R.anim.slide_out_right);
        transaction.replace(R.id.frameContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}