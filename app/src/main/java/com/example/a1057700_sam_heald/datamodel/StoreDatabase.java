package com.example.a1057700_sam_heald.datamodel;


import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(
        entities = {Customer.class, Product.class, OrderDetail.class, CustomerOrder.class},
        version = 1,
        exportSchema = false
)
@TypeConverters(DataTypeConverter.class)
public abstract class StoreDatabase extends RoomDatabase {
    private static StoreDatabase database = null;

    public abstract StoreDao getStoreDao();

    public static StoreDatabase createDbInstance(Application application){
        if(database == null){
            database = Room.databaseBuilder(
                    application.getApplicationContext(),
                    StoreDatabase.class,
                    "Store_Database")
                    .allowMainThreadQueries()
                    .build();
        }
        return database;
    }
}
