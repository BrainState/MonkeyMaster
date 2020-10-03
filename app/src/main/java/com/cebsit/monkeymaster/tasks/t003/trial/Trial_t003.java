package com.cebsit.monkeymaster.tasks.t003.trial;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "trials_t003")
public class Trial_t003 {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "trial_id")
    private int trialId;
    @ColumnInfo(name = "true_stimulus_orientation")
    private int trueStimulusOrientation;
    @ColumnInfo(name = "tapped_orientation")
    private int tappedOrientation;
    @ColumnInfo(name = "tapped_time_stamp")
    private long tappedTimeStamp;
    @ColumnInfo(name = "tapped_time")
    private String tappedTime;
    private boolean correct;

    public Trial_t003() {

    }

    public int getTrialId() {
        return trialId;
    }

    public void setTrialId(int trialId) {
        this.trialId = trialId;
    }

    public int getTrueStimulusOrientation() {
        return trueStimulusOrientation;
    }

    public void setTrueStimulusOrientation(int trueStimulusOrientation) {
        this.trueStimulusOrientation = trueStimulusOrientation;
    }

    public int getTappedOrientation() {
        return tappedOrientation;
    }

    public void setTappedOrientation(int tappedOrientation) {
        this.tappedOrientation = tappedOrientation;
    }

    public long getTappedTimeStamp() {
        return tappedTimeStamp;
    }

    public void setTappedTimeStamp(long tappedTimeStamp) {
        this.tappedTimeStamp = tappedTimeStamp;
    }

    public String getTappedTime() {
        return tappedTime;
    }

    public void setTappedTime(String tappedTime) {
        this.tappedTime = tappedTime;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
