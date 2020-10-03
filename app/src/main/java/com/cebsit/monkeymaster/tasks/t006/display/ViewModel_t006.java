package com.cebsit.monkeymaster.tasks.t006.display;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.cebsit.monkeymaster.tasks.TaskActivity;
import com.cebsit.monkeymaster.tasks.t003.trial.Trial_t003;
import com.cebsit.monkeymaster.tasks.t006.trial.TrialRepository_t006;
import com.cebsit.monkeymaster.tasks.t006.trial.Trial_t006;

public class ViewModel_t006 extends AndroidViewModel {
    static boolean timerRunning;
    private static TrialRepository_t006 trialRepository_t006;
    private static Trial_t006 trial_t006;
    private SharedPreferences sp;

    private MutableLiveData<Integer> consecutiveCorrectCount;
    private MutableLiveData<Integer> shift;

    public ViewModel_t006(@NonNull Application application) {
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

    public MutableLiveData<Integer> getConsecutiveCorrectCount() {
        if (consecutiveCorrectCount == null) {
            consecutiveCorrectCount = new MutableLiveData<>();
            consecutiveCorrectCount.setValue(0);
        }
        return consecutiveCorrectCount;
    }

    public MutableLiveData<Integer> getShift() {
        if (shift == null) {
            shift = new MutableLiveData<>();
            shift.setValue(0);
        }
        return shift;
    }
}
