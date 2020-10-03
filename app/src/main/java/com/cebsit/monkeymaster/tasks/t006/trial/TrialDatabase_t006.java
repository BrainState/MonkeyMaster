package com.cebsit.monkeymaster.tasks.t006.trial;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.cebsit.monkeymaster.tasks.t006.trial.TrialDao_t006;
import com.cebsit.monkeymaster.tasks.t006.trial.Trial_t006;

@Database(entities = {Trial_t006.class}, version = 1, exportSchema = false)
public abstract class TrialDatabase_t006 extends RoomDatabase {
    private static TrialDatabase_t006 INSTANCE;

    static synchronized TrialDatabase_t006 getTrialDatabase_t006(Context context, String trialsFileName) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TrialDatabase_t006.class, trialsFileName)
                    .build();
        }
        return INSTANCE;
    }

    public abstract TrialDao_t006 getTrialDao_t006();
}
