package com.example.a1057700_sam_heald;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1057700_sam_heald.datamodel.Customer;

import java.text.SimpleDateFormat;
import java.util.List;

public class CustomerRecyclerViewAdapter extends RecyclerView.Adapter<CustomerViewHolder> {
    List<Customer> customerList = null;

    public CustomerRecyclerViewAdapter(List<Customer> customers){
        this.customerList = customers;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.customer_list_item, parent, false);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        Customer customer = customerList.get(position);
        holder.customer = customer;
        holder.idTv.setText(String.valueOf(customer.getCustomerID()));
        holder.nameTv.setText(customer.getCustomerFirstName() + " " + customer.getCustomerLastName());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateStr = sdf.format(customer.getCustomerRegistrationDate());
        holder.dateTv.setText(dateStr);
    }

    @Override
    public int getItemCount() {
        if (customerList == null)
            return 0;
        else
            return customerList.size();
    }
}
