package com.example.a1057700_sam_heald.datamodel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

@Entity(
        tableName = "Customers"
)

public class Customer implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "CustomerID")
    long customerID;
    @ColumnInfo(name = "First_Name")
    String customerFirstName;
    @ColumnInfo(name = "Last_Name")
    String customerLastName;
    @ColumnInfo(name ="Date_Of_Birth")
    Date customerDateOfBirth;
    @ColumnInfo(name ="Address")
    String customerAddress;
    @ColumnInfo(name ="Suburb")
    String customerSuburb;
    @ColumnInfo(name ="City")
    String customerCity;
    @ColumnInfo(name ="ZIP")
    String customerZip;
    @ColumnInfo(name = "Registration_Date")
    Date customerRegistrationDate;

    public Customer(long customerID, String customerFirstName, String customerLastName, Date customerDateOfBirth, String customerAddress, String customerSuburb, String customerCity, String customerZip, Date customerRegistrationDate) {
        this.customerID = customerID;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerDateOfBirth = customerDateOfBirth;
        this.customerAddress = customerAddress;
        this.customerSuburb = customerSuburb;
        this.customerCity = customerCity;
        this.customerZip = customerZip;
        this.customerRegistrationDate = customerRegistrationDate;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public Date getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(Date customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerSuburb() {
        return customerSuburb;
    }

    public void setCustomerSuburb(String customerSuburb) {
        this.customerSuburb = customerSuburb;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerZip() {
        return customerZip;
    }

    public void setCustomerZip(String customerZip) {
        this.customerZip = customerZip;
    }

    public Date getCustomerRegistrationDate() {
        return customerRegistrationDate;
    }

    public void setCustomerRegistrationDate(Date customerRegistrationDate) {
        this.customerRegistrationDate = customerRegistrationDate;
    }
}
