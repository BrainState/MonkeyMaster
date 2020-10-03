package com.cebsit.monkeymaster.tasks.t006.trial;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "trials_t006")
public class Trial_t006 implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "trial_id")
    private int trialId;
    private int shift;
    @Embedded(prefix = "stimulus1_")
    private Stimulus stimulus1;
    @Embedded(prefix = "stimulus2_")
    private Stimulus stimulus2;
    @Embedded(prefix = "stimulus3_")
    private Stimulus stimulus3;
    @ColumnInfo(name = "true_stimulus_number")
    private int trueStimulusNum;
    @ColumnInfo(name = "tapped_stimulus_number")
    private int tappedStimulusNum;
    @ColumnInfo(name = "tapped_time_stamp")
    private long tappedTimeStamp;
    @ColumnInfo(name = "tapped_time")
    private String tappedTime;
    private boolean correct;

    @ColumnInfo(name = "consecutive_correct_count")
    private int consecutiveCorrectCount;

    public int getTrialId() {
        return trialId;
    }

    public void setTrialId(int trialId) {
        this.trialId = trialId;
    }

    public Stimulus getStimulus1() {
        return stimulus1;
    }

    public void setStimulus1(Stimulus stimulus1) {
        this.stimulus1 = stimulus1;
    }

    public Stimulus getStimulus2() {
        return stimulus2;
    }

    public void setStimulus2(Stimulus stimulus2) {
        this.stimulus2 = stimulus2;
    }

    public Stimulus getStimulus3() {
        return stimulus3;
    }

    public void setStimulus3(Stimulus stimulus3) {
        this.stimulus3 = stimulus3;
    }

    public void setStimulus1(int row, int column, String color, String shape) {
        this.stimulus1 = new Stimulus(row, column, color, shape);
    }

    public void setStimulus2(int row, int column, String color, String shape) {
        this.stimulus2 = new Stimulus(row, column, color, shape);
    }

    public void setStimulus3(int row, int column, String color, String shape) {
        this.stimulus3 = new Stimulus(row, column, color, shape);
    }

    public int getTrueStimulusNum() {
        return trueStimulusNum;
    }

    public void setTrueStimulusNum(int trueStimulusNum) {
        this.trueStimulusNum = trueStimulusNum;
    }

    public int getTappedStimulusNum() {
        return tappedStimulusNum;
    }

    public void setTappedStimulusNum(int tappedStimulusNum) {
        this.tappedStimulusNum = tappedStimulusNum;
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

    public int getConsecutiveCorrectCount() {
        return consecutiveCorrectCount;
    }

    public void setConsecutiveCorrectCount(int consecutiveCorrectCount) {
        this.consecutiveCorrectCount = consecutiveCorrectCount;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public class Stimulus {
        private int raw;
        private int column;
        private String color;
        private String shape;

        public Stimulus(int raw, int column, String color, String shape) {
            this.raw = raw;
            this.column = column;
            this.color = color;
            this.shape = shape;
        }

        public int getRaw() {
            return raw;
        }

        public void setRaw(int raw) {
            this.raw = raw;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getShape() {
            return shape;
        }

        public void setShape(String shape) {
            this.shape = shape;
        }
    }
}
