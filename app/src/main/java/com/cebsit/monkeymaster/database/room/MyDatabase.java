package com.cebsit.monkeymaster.database.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.cebsit.monkeymaster.database.Monkey;
import com.cebsit.monkeymaster.database.Record;


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
