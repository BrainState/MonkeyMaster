package com.cebsit.monkeymaster.tasks.t003.display;

import android.app.Application;
import android.content.SharedPreferences;
import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.cebsit.monkeymaster.tasks.t003.trial.TrialRepository_t003;
import com.cebsit.monkeymaster.tasks.t003.trial.Trial_t003;

public class ViewModel_t003 extends AndroidViewModel {
    private static TrialRepository_t003 trialRepository_t003;
    private String fileName;
    private SharedPreferences sp;
    private static Trial_t003 trial_t003;

    static int rewardColor, errorColor;
    static int rewardDuraion, intervalPreReward, intervalPostReward, timeOutDuraion;
    static int cueColor, borderColor;
    static int cueSize, cueBorderSize;
    static int distractorsNum;
    static int stimuliColor, distractorsColor;
    static int intervalPreStimuli, stimuliDuration, intervalPreOptions, optionsDuration;

    public ViewModel_t003(@NonNull Application application) {
        super(application);
//        trailsFileName = "fileName";
//        trialRepository_t003 = new TrialRepository_t003(application, trailsFileName);
    }

    public void loadSharedPrefs(SharedPreferences sp) {this.sp = sp;}

    public void loadDatabase(String fileName) {
        trialRepository_t003 = new TrialRepository_t003(getApplication(), fileName);
    }

    @SuppressWarnings({"UnnecessaryBoxing", "ConstantConditions"})
    public void loadPrefs() {
        rewardColor = getApplication().getResources().getIdentifier(sp.getString("shared_rewardColor", "green"), "color", getApplication().getPackageName());
        errorColor = getApplication().getResources().getIdentifier(sp.getString("shared_errorColor", "red"), "color", getApplication().getPackageName());

        rewardDuraion = Integer.valueOf(sp.getString("shared_rewardDuraion", "3000"));
        intervalPreReward = Integer.valueOf(sp.getString("shared_intervalPreReward", "3000"));
        intervalPostReward = Integer.valueOf(sp.getString("shared_intervalPostReward", "3000"));
        timeOutDuraion = 60 * 1000 * Integer.valueOf(sp.getString("shared_timeoutDuration_min","0")) + 1000 * Integer.valueOf(sp.getString("shared_timeoutDuration_sec","0")) + Integer.valueOf(sp.getString("shared_timeoutDuration_msec","0"));

        cueColor = getApplication().getResources().getIdentifier(sp.getString("shared_cueColor", "white"), "color", getApplication().getPackageName());
        borderColor = getApplication().getResources().getIdentifier(sp.getString("shared_borderColor", "yellow"), "color", getApplication().getPackageName());
        cueSize = 10 * Integer.valueOf(sp.getString("shared_cueSize","30"));
        cueBorderSize = 10 * Integer.valueOf(sp.getString("shared_cueBorderSize","0"));

        distractorsNum = Integer.valueOf(sp.getString("t003_distractorsNum", "7"));
        stimuliColor = getApplication().getResources().getIdentifier(sp.getString("t003_stimuliColor", "white"),"color", getApplication().getPackageName());
        distractorsColor = getApplication().getResources().getIdentifier(sp.getString("t003_distractorsColor", "red"),"color", getApplication().getPackageName());
        intervalPreStimuli = Integer.valueOf(sp.getString("t003_intervalPreStimuli", "3000"));
        stimuliDuration = Integer.valueOf(sp.getString("t003_stimuliDuration","3000"));
        intervalPreOptions = Integer.valueOf(sp.getString("t003_intervalPreOptions","3000"));
        optionsDuration = Integer.valueOf(sp.getString("t003_optionsDuration","3000"));
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
