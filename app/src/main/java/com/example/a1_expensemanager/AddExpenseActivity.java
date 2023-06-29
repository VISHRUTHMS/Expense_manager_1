package com.example.a1_expensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a1_expensemanager.databinding.ActivityAddExpenseBinding;

public class AddExpenseActivity extends AppCompatActivity {
    ActivityAddExpenseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        binding = ActivityAddExpenseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}