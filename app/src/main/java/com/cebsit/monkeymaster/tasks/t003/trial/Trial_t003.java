package com.cebsit.monkeymaster.tasks.t003.trial;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "trials_t003")
public class Trial_t003 {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "trial_id")
    private int trialId;
    @ColumnInfo(name = "stimuli_orientation")
    private int stimuliOrientation;
    @ColumnInfo(name = "click_orientation")
    private int clickOrientation;
    @ColumnInfo(name = "click_time_stamp")
    private long clickTimeStamp;
    @ColumnInfo(name = "click_time")
    private String clickTime;
    private boolean correct;

    public Trial_t003() {

    }

    public int getTrialId() {
        return trialId;
    }

    public void setTrialId(int trialId) {
        this.trialId = trialId;
    }

    public int getStimuliOrientation() {
        return stimuliOrientation;
    }

    public void setStimuliOrientation(int stimuliOrientation) {
        this.stimuliOrientation = stimuliOrientation;
    }

    public int getClickOrientation() {
        return clickOrientation;
    }

    public void setClickOrientation(int clickOrientation) {
        this.clickOrientation = clickOrientation;
    }

    public long getClickTimeStamp() {
        return clickTimeStamp;
    }

    public void setClickTimeStamp(long clickTimeStamp) {
        this.clickTimeStamp = clickTimeStamp;
    }

    public String getClickTime() {
        return clickTime;
    }

    public void setClickTime(String clickTime) {
        this.clickTime = clickTime;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
