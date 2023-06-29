package com.example.a1_expensemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.a1_expensemanager.databinding.ActivityAddExpenseBinding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.UUID;

public class AddExpenseActivity extends AppCompatActivity {
    ActivityAddExpenseBinding binding;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        binding = ActivityAddExpenseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        type=getIntent().getStringExtra("type");
        if(type.equals("Income"))
        {
            binding.incomeRadio.setChecked(true);
        }
        else{
            binding.incomeRadio.setChecked(true);
        }

        binding.incomeRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type="Income";

            }
        });


        binding.expenseRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type="Expense";

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.add_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.saveExpense)
        {
            createExpense();
            return true;
        }
        return false;
    }

    private void createExpense() {

        String expenseID= UUID.randomUUID().toString();
        String amount=binding.amount.getText().toString();
        String note=binding.note.getText().toString();
        String category=binding.category.getText().toString();

       // String type;

        boolean incomeChecked= binding.incomeRadio.isChecked();

        if(incomeChecked)
        {
            type="Income";
        }
        else{
            type="Expense";
        }

       // Firebase


        if(amount.trim().length()==0)
        {
            binding.amount.setError("Empty");
            return;
        }

        ExpenseModel expenseModel=new ExpenseModel(expenseID,note,category,type,Long.parseLong(amount),Calendar.getInstance().getTimeInMillis());

        FirebaseFirestore
                .getInstance()
                .collection("expenses")
                .document(expenseID)
                .set(expenseModel);
        finish();


    }
}