package com.example.a1057700_sam_heald.datamodel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;


@Entity(
        tableName = "OrderDetails",
        primaryKeys = {
                "OrderDetailOrderID",
                "OrderDetailProductID"
        },
        foreignKeys = {
                @ForeignKey(
                        entity = CustomerOrder.class,
                        parentColumns = "OrderID",
                        childColumns = "OrderDetailOrderID"
                ),
                @ForeignKey(
                        entity = Product.class,
                        parentColumns = "ProductID",
                        childColumns = "OrderDetailProductID"
                ),
        }
)
public class OrderDetail {
    @ColumnInfo(name = "OrderDetailOrderID")
    long orderDetailOrderID;
    @ColumnInfo(name = "OrderDetailProductID")
    long orderDetailProductID;
    @ColumnInfo(name = "OrderDetailQuantity")
    int orderDetailQuantity;

    public long getOrderDetailOrderID() {
        return orderDetailOrderID;
    }

    public void setOrderDetailOrderID(long orderDetailOrderID) {
        this.orderDetailOrderID = orderDetailOrderID;
    }

    public long getOrderDetailProductID() {
        return orderDetailProductID;
    }

    public void setOrderDetailProductID(long orderDetailProductID) {
        this.orderDetailProductID = orderDetailProductID;
    }

    public int getOrderDetailQuantity() {
        return orderDetailQuantity;
    }

    public void setOrderDetailQuantity(int orderDetailQuantity) {
        this.orderDetailQuantity = orderDetailQuantity;
    }

    public OrderDetail(long orderDetailOrderID, long orderDetailProductID, int orderDetailQuantity) {
        this.orderDetailOrderID = orderDetailOrderID;
        this.orderDetailProductID = orderDetailProductID;
        this.orderDetailQuantity = orderDetailQuantity;
    }
}
