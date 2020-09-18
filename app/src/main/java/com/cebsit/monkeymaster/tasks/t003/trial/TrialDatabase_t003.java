package com.cebsit.monkeymaster.tasks.t003.trial;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Trial_t003.class}, version = 1, exportSchema = false)
public abstract class TrialDatabase_t003 extends RoomDatabase {
    private static TrialDatabase_t003 INSTANCE;

    static synchronized TrialDatabase_t003 getTrialDatabase_t003(Context context, String trialsFileName) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TrialDatabase_t003.class, trialsFileName)
                    .build();
        }
        return INSTANCE;
    }

    public abstract TrialDao_t003 getTrialDao_t003();
}
