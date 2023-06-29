package com.example.a1_expensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a1_expensemanager.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}