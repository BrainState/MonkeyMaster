package com.cebsit.monkeymaster.tasks.t003.trial;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.cebsit.monkeymaster.database.Record;

import java.util.List;
@Dao
public interface TrialDao_t003 {
    @Insert
    void insertTrial(Trial_t003... trials_t003);

    @Query("SELECT * FROM trials_t003 ORDER BY trial_id DESC")
    List<Trial_t003> getTrials_t003();
}
