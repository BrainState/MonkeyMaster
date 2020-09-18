package com.cebsit.monkeymaster.tasks.t003.display;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.cebsit.monkeymaster.database.Monkey;
import com.cebsit.monkeymaster.tasks.t003.trial.TrialRepository_t003;
import com.cebsit.monkeymaster.tasks.t003.trial.Trial_t003;

public class ViewModel_t003 extends AndroidViewModel {
    private TrialRepository_t003 trialRepository_t003;
    private String trailsFileName;
    private static Trial_t003 trial_t003;

    public ViewModel_t003(@NonNull Application application) {
        super(application);
        trailsFileName = "fileName";
        trialRepository_t003 = new TrialRepository_t003(application, trailsFileName);
    }

    public void initTrial() {
        trial_t003 = new Trial_t003();
    }

    public Trial_t003 getTrial_t003() {
        return trial_t003;
    }

    public void insertTrials_t003() {
        trialRepository_t003.insertTrials_t003(trial_t003);
    }

}
