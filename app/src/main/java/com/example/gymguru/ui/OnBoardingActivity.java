package com.example.gymguru.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gymguru.R;
import com.example.gymguru.databinding.ActivityOnBoardingBinding;

public class OnBoardingActivity extends AppCompatActivity {

    private ActivityOnBoardingBinding binding;
    private int currentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding  = ActivityOnBoardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        int [] image = {R.drawable.frame1,R.drawable.frame2,R.drawable.frame3,R.drawable.fram4};
        String [] text1= {"Track Your Goal","Get Burn" ,"Eat Well" ,"Improve Sleep  Quality"};
        String [] text2= {getString(R.string.text1),getString(R.string.text2) ,getString(R.string.text3) ,getString(R.string.text4)};
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (currentIndex<image.length-1) {


                    currentIndex++;
//                    currentIndex = (currentIndex + 1) % image.length;
                    binding.frame1.setImageResource(image[currentIndex]);
                    binding.textView1.setText(text1[currentIndex]);
                    binding.text2.setText(text2[currentIndex]);
                }
                else
                {
                    startActivity(new Intent(OnBoardingActivity.this, RegistrationActivity.class));
                }


            }
        });



    }
}