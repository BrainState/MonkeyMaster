package com.cebsit.monkeymaster.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Record.class, Monkey.class},version = 1,exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    private static MyDatabase INSTANCE;
    static synchronized MyDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class,"my_database")
                    .build();
        }
        return INSTANCE;
    }
    public abstract MyDao getMyDao();
}
