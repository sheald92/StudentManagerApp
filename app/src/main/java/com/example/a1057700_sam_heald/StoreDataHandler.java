package com.example.a1057700_sam_heald;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.a1057700_sam_heald.datamodel.Customer;
import com.example.a1057700_sam_heald.datamodel.Product;
import com.example.a1057700_sam_heald.datamodel.StoreDao;
import com.example.a1057700_sam_heald.datamodel.StoreDatabase;

import java.util.List;

public class StoreDataHandler {

    private StoreDao dao;

    public StoreDataHandler(Application application){
        this.dao = StoreDatabase.createDbInstance(application).getStoreDao();
        insertProducts();

    }
    public long addCustomer(Customer customer){
        return dao.insertCustomer(customer);
    }

    public int updateCustomer(Customer customer){
        return dao.updateCustomer(customer);
    }

    public int deleteCustomer(Customer customer){
        return dao.deleteCustomer(customer);
    }

    public LiveData<List<Customer>> getCustomersList(){
        return dao.readAllCustomersLive();
    }

    private void insertProducts(){
        if(dao.readAllProducts().size() == 0) {
            Product product = new Product(0, "Pencil", "Write on Paper", 0.99);
            dao.insertProduct(product);
            product = new Product(0, "Notebook A4", "Write your notes in it", 2.50);
            dao.insertProduct(product);
            product = new Product(0, "Book on ICT", "Learn ICT", 12.75);
            dao.insertProduct(product);
        }
    }
}
