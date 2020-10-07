package com.cebsit.monkeymaster.tasks.t006.display;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.cebsit.monkeymaster.tasks.TaskActivity;
import com.cebsit.monkeymaster.tasks.TaskViewModel;
import com.cebsit.monkeymaster.tasks.t006.trial.TrialRepository_t006;
import com.cebsit.monkeymaster.tasks.t006.trial.Trial_t006;

public class ViewModel_t006 extends TaskViewModel {
    static boolean timerRunning;
    private static int consecutiveCorrectCount;
    private static int shift;
    private static TrialRepository_t006 trialRepository_t006;
    private static Trial_t006 trial_t006;
    private SharedPreferences sp;

    public ViewModel_t006(@NonNull Application application, SavedStateHandle handle) {
        super(application);

        timerRunning = false;
        String fileName = TaskActivity.getFileName();
        sp = getApplication().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        trialRepository_t006 = new TrialRepository_t006(getApplication(), fileName);
    }

    public void initTrial() {
        trial_t006 = new Trial_t006();
    }

    public Trial_t006 getTrial_t006() {
        return trial_t006;
    }

    public void insertTrials_t006() {
        trialRepository_t006.insertTrials_t006(trial_t006);
    }

    public int getCCC() {
        return consecutiveCorrectCount;
    }

    public int getShift() {
        return shift;
    }

    public void addCCC() {
        if (getCCC() < 10) {
            consecutiveCorrectCount ++;
        } else {
            consecutiveCorrectCount = 1;
        }
    }


    public void resetCCC() {
        consecutiveCorrectCount = 0;
    }

    public void changeShift() {
        if (getShift() < 4) {
            shift ++;
        } else {
            shift = 0;
        }
    }

}
