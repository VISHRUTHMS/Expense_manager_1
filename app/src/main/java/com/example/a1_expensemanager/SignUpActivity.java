package com.example.a1_expensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a1_expensemanager.databinding.ActivityMainBinding;
import com.example.a1_expensemanager.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}