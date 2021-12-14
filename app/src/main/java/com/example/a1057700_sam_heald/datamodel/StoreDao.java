package com.example.a1057700_sam_heald.datamodel;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StoreDao {

    // Customer Management
    @Query("SELECT * FROM Customers")
    List<Customer> readAllCustomers();

    @Query("SELECT * FROM Customers")
    LiveData<List<Customer>> readAllCustomersLive();

    @Insert
    long insertCustomer(Customer customer);

    @Update
    int updateCustomer(Customer customer);

    @Delete
    int deleteCustomer(Customer customer);

    // Department Management
    @Query("SELECT * FROM Products")
    List<Product> readAllProducts();

    @Insert
    long insertProduct(Product product);

    // Position Management
    @Query("SELECT * FROM CustomerOrders")
    List<CustomerOrder> readAllOrders();

    @Insert
    long insertOrder(CustomerOrder customerOrder);

    @Update
    int updateOrder(CustomerOrder customerOrder);

    @Delete
    int deleteOrder(CustomerOrder customerOrder);

    // EmployeePositions Management
    @Query("SELECT * FROM OrderDetails")
    List<OrderDetail> readAllOrderDetails();

    @Insert
    long insertOrderDetails(OrderDetail orderDetail);

    @Update
    int updateOrderDetails(OrderDetail orderDetail);

    @Delete
    int deleteOrderDetails(OrderDetail orderDetail);
}
