package com.example.a1057700_sam_heald;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1057700_sam_heald.datamodel.Customer;

public class CustomerViewHolder extends RecyclerView.ViewHolder {
    CardView cardView;
    TextView idTv, nameTv, dateTv;
    Customer customer;
    public CustomerViewHolder(@NonNull final View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.customersListCard);
        idTv = itemView.findViewById(R.id.customerListCardID);
        nameTv = itemView.findViewById(R.id.customerListCardName);
        dateTv = itemView.findViewById(R.id.customerListCardJoinDate);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), CustomerDetailsActivity.class);
                intent.putExtra("CUSTOMER_EXTRA", customer);
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
