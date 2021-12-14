package com.example.a1057700_sam_heald.datamodel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Products")

public class Product {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ProductID")
    long productID;

    @ColumnInfo(name = "ProductName")
    String productName;

    @ColumnInfo(name = "ProductDescription")
    String productDescription;

    @ColumnInfo(name = "ProductUnitPrice")
    double productUnitPrice;

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(int productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public Product(long productID, String productName, String productDescription, double productUnitPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productUnitPrice = productUnitPrice;
    }
}
