package com.example.a1057700_sam_heald;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a1057700_sam_heald.datamodel.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerDetailsActivity extends AppCompatActivity {

    EditText idEt, joinDateEt, firstNameEt, lastNameEt, dobEt, addressEt, suburbEt, cityEt, zipEt;
    Button editButton, updateButton, deleteButton;

    StoreViewModel viewModel;

    Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        customer = (Customer) getIntent().getSerializableExtra("CUSTOMER_EXTRA");
        if(customer == null){
            finish();
        }
        viewModel = new StoreViewModel(getApplication());
        idEt = findViewById(R.id.detailsCustomerID);
        joinDateEt = findViewById(R.id.detailsCustomerRegistrationDate);
        firstNameEt = findViewById(R.id.detailsCustomerFirstName);
        lastNameEt = findViewById(R.id.detailsCustomerLastName);
        dobEt = findViewById(R.id.detailsCustomerDob);
        addressEt = findViewById(R.id.detailsCustomerAddress);
        suburbEt = findViewById(R.id.detailsCustomerSuburb);
        cityEt = findViewById(R.id.detailsCustomerCity);
        zipEt = findViewById(R.id.detailsCustomerZip);

        editButton = findViewById(R.id.detailsCustomerEdit);
        updateButton = findViewById(R.id.detailsCustomerUpdate);
        deleteButton = findViewById(R.id.detailsCustomerDelete);

        setCustomerData();

        setEditing(false);
    }

    public void detailsCustomerEditButtonClick(View view) {
        setEditing(true);
    }

    public void detailsCustomerUpdateButtonClick(View view) {
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
                customer.setCustomerFirstName(firstName);
                customer.setCustomerLastName(lastName);
                customer.setCustomerAddress(address);
                customer.setCustomerSuburb(suburb);
                customer.setCustomerCity(city);
                customer.setCustomerZip(zipCode);
                if(viewModel.updateCustomer(customer) != 0){
                    Toast.makeText(this, "Customer is successfully updated in DB", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Error in updating Customer in DB", Toast.LENGTH_LONG).show();
                }
            } catch (ParseException e){
                e.printStackTrace();
            }
        }
    }

    public void detailsCustomerDeleteButtonClick(View view) {
        if(viewModel.deleteCustomer(customer) != 0){
            Toast.makeText(this, "Customer is successfully deleted from DB", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    public void detailsCustomerCancelClick(View view) {
        finish();
    }

    private void setEditing(boolean enable){
        firstNameEt.setEnabled(enable);
        lastNameEt.setEnabled(enable);
        dobEt.setEnabled(enable);
        addressEt.setEnabled(enable);
        suburbEt.setEnabled(enable);
        cityEt.setEnabled(enable);
        zipEt.setEnabled(enable);
        updateButton.setEnabled(enable);
        deleteButton.setEnabled(enable);
        editButton.setEnabled(!enable);
    }

    private void setCustomerData(){
        idEt.setText(String.valueOf(customer.getCustomerID()));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        joinDateEt.setText(sdf.format(customer.getCustomerRegistrationDate()));
        firstNameEt.setText(customer.getCustomerFirstName());
        lastNameEt.setText(customer.getCustomerLastName());
        dobEt.setText(sdf.format(customer.getCustomerDateOfBirth()));
        addressEt.setText(customer.getCustomerAddress()==null? "" : customer.getCustomerAddress());
        suburbEt.setText(customer.getCustomerSuburb() == null? "" : customer.getCustomerSuburb());
        cityEt.setText(customer.getCustomerCity() == null? "" : customer.getCustomerCity());
        zipEt.setText(customer.getCustomerZip());
    }
}