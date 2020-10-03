package com.cebsit.monkeymaster.tasks.t003.display;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.cebsit.monkeymaster.backend.SystemUtils;
import com.cebsit.monkeymaster.tasks.TaskActivity;
import com.cebsit.monkeymaster.tasks.t003.trial.TrialRepository_t003;
import com.cebsit.monkeymaster.tasks.t003.trial.Trial_t003;

public class ViewModel_t003 extends AndroidViewModel {
    static boolean timerRunning;
    static int rewardColor, errorColor;
    static int rewardDuration, intervalPreReward, intervalPostReward, timeOutDuration;
    static int cueColor, borderColor;
    static int cueSize, cueBorderSize;
    static int stimuliCount;
    static int trueStimulusColor, falseStimuliColor;
    static int intervalPreStimuli, stimuliDuration, intervalPreOptions, optionsDuration;
    private static TrialRepository_t003 trialRepository_t003;
    private static Trial_t003 trial_t003;
    private SharedPreferences sp;

    public ViewModel_t003(@NonNull Application application) {
        super(application);

        timerRunning = false;
        String fileName = TaskActivity.getFileName();
        sp = getApplication().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        trialRepository_t003 = new TrialRepository_t003(getApplication(), fileName);
    }

    @SuppressWarnings({"UnnecessaryBoxing", "ConstantConditions"})
    public void loadPrefs() {
        rewardColor = SystemUtils.getColor(getApplication(), sp, "shared_rewardColor", "green");
        errorColor = SystemUtils.getColor(getApplication(), sp, "shared_errorColor", "red");

        rewardDuration = Integer.valueOf(sp.getString("shared_rewardDuration", "3000"));
        intervalPreReward = Integer.valueOf(sp.getString("shared_intervalPreReward", "3000"));
        intervalPostReward = Integer.valueOf(sp.getString("shared_intervalPostReward", "3000"));
        timeOutDuration =
                Integer.valueOf(sp.getString("shared_timeoutDuration_min", "0")) * 1000 * 60 +
                Integer.valueOf(sp.getString("shared_timeoutDuration_sec", "0")) * 1000 +
                Integer.valueOf(sp.getString("shared_timeoutDuration_msec", "0"));

        cueColor = SystemUtils.getColor(getApplication(), sp, "shared_cueColor", "white");
        borderColor = SystemUtils.getColor(getApplication(), sp, "shared_borderColor", "yellow");
        cueSize = 10 * Integer.valueOf(sp.getString("shared_cueSize", "30"));
        cueBorderSize = 10 * Integer.valueOf(sp.getString("shared_cueBorderSize", "0"));

        stimuliCount = Integer.valueOf(sp.getString("t003_stimuliCount", "8"));
        trueStimulusColor = SystemUtils.getColor(getApplication(), sp, "t003_trueStimulusColor", "white");
        falseStimuliColor = SystemUtils.getColor(getApplication(), sp, "t003_falseStimuliColor", "red");
        intervalPreStimuli = Integer.valueOf(sp.getString("t003_intervalPreStimuli", "3000"));
        stimuliDuration = Integer.valueOf(sp.getString("t003_stimuliDuration", "3000"));
        intervalPreOptions = Integer.valueOf(sp.getString("t003_intervalPreOptions", "3000"));
        optionsDuration = Integer.valueOf(sp.getString("t003_optionsDuration", "3000"));
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
