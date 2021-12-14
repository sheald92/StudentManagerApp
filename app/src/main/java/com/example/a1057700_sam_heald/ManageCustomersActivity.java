package com.example.a1057700_sam_heald;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.a1057700_sam_heald.datamodel.Customer;

import java.util.List;

public class ManageCustomersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_customers);
        final RecyclerView recyclerView = findViewById(R.id.customersList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        StoreViewModel viewModel = new StoreViewModel(getApplication());
        viewModel.getCustomersList().observe(this, new Observer<List<Customer>>() {
            @Override
            public void onChanged(List<Customer> customer) {
                recyclerView.setAdapter(new CustomerRecyclerViewAdapter(customer));
            }
        });
    }
}