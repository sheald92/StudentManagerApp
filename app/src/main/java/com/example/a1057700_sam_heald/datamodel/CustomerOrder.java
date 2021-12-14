package com.example.a1057700_sam_heald.datamodel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(
        tableName = "CustomerOrders",
        foreignKeys = {
                @ForeignKey(
                        entity = Customer.class,
                        parentColumns = "CustomerID",
                        childColumns = "OrderCustomerID"
                )
        }
)

public class CustomerOrder {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "OrderID")
    long orderID;
    @ColumnInfo(name = "OrderDate")
    Date orderDate;
    @ColumnInfo(name = "OrderCustomerID")
    long orderCustomerID;

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public long getOrderCustomerID() {
        return orderCustomerID;
    }

    public void setOrderCustomerID(long orderCustomerID) {
        this.orderCustomerID = orderCustomerID;
    }

    public CustomerOrder(long orderID, Date orderDate, long orderCustomerID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderCustomerID = orderCustomerID;
    }
}
