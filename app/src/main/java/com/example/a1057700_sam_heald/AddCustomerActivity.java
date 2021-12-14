package com.example.a1057700_sam_heald;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a1057700_sam_heald.datamodel.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddCustomerActivity extends AppCompatActivity {

    StoreViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        viewModel = new StoreViewModel(getApplication());
    }

    public void cancelAddCustomerClick(View view) {
        finish();
    }

    public void addCustomerButtonClick(View view) {
        EditText firstNameEt, lastNameEt, dobEt, addressEt,suburbEt, cityEt, zipEt;
        firstNameEt = findViewById(R.id.addCustomerFirstName);
        lastNameEt = findViewById(R.id.addCustomerLastName);
        dobEt = findViewById(R.id.addCustomerDob);
        addressEt = findViewById(R.id.addCustomerAddress);
        suburbEt = findViewById(R.id.addCustomerSuburb);
        cityEt = findViewById(R.id.addCustomerCity);
        zipEt = findViewById(R.id.addCustomerZip);

        String firstName, lastName, dob, address, suburb, city, zipCode;
        firstName = firstNameEt.getText().toString().isEmpty()? null : firstNameEt.getText().toString();
        lastName = lastNameEt.getText().toString().isEmpty()? null : lastNameEt.getText().toString();
        dob = dobEt.getText().toString().isEmpty()? null : dobEt.getText().toString();
        address = addressEt.getText().toString().isEmpty()? null : addressEt.getText().toString();
        suburb = suburbEt.getText().toString().isEmpty()? null : suburbEt.getText().toString();
        city = cityEt.getText().toString().isEmpty()? null : cityEt.getText().toString();
        zipCode = zipEt.getText().toString().isEmpty()? null : zipEt.getText().toString();
        if(firstName != null || lastName != null || dob != null){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date dobDate = sdf.parse(dob);
                Customer customer = new Customer(0, firstName, lastName, dobDate, address, suburb,  city, zipCode, new Date());
                if(viewModel.addCustomer(customer) != -1){
                    Toast.makeText(this, "Customer is successfully added in DB", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, ManageCustomersActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "Error in adding Customer in DB", Toast.LENGTH_LONG).show();
                }
            } catch (ParseException e){
                e.printStackTrace();
            }
        }
    }
}