package com.example.a1057700_sam_heald;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.a1057700_sam_heald.datamodel.Customer;

import java.util.List;

public class StoreViewModel extends ViewModel {
    Application application;
    StoreDataHandler dataHandler;
    LiveData<List<Customer>> customerList;

    public StoreViewModel(Application application){
        this.application = application;
        dataHandler = new StoreDataHandler(application);
        customerList = dataHandler.getCustomersList();
    }

    public long addCustomer(Customer customer){
        return dataHandler.addCustomer(customer);
    }

    public LiveData<List<Customer>> getCustomersList(){
        return customerList;
    }

    public int updateCustomer(Customer customer){
        return dataHandler.updateCustomer(customer);
    }

    public int deleteCustomer(Customer customer){
        return dataHandler.deleteCustomer(customer);
    }

}
