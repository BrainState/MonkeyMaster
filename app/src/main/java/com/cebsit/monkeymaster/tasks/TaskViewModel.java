package com.cebsit.monkeymaster.tasks;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.cebsit.monkeymaster.backend.SystemUtils;

public class TaskViewModel extends AndroidViewModel {
    protected String fileName = TaskActivity.getFileName();
    protected SharedPreferences sp;

    public boolean timeRunning = false;

    public int rewardColor, errorColor;
    public int rewardDuration, intervalPreReward, intervalPostReward, timeOutDuration;
    public int cueColor, borderColor;
    public int cueSize, cueBorderSize;

    @SuppressWarnings({"ConstantConditions"})
    public TaskViewModel(@NonNull Application application) {
        super(application);
        sp = application.getSharedPreferences(fileName, Context.MODE_PRIVATE);

        rewardColor = SystemUtils.getColor(getApplication(), sp, "shared_rewardColor", "green");
        errorColor = SystemUtils.getColor(getApplication(), sp, "shared_errorColor", "red");
        rewardDuration = Integer.parseInt(sp.getString("shared_rewardDuration", "3000"));
        intervalPreReward = Integer.parseInt(sp.getString("shared_intervalPreReward", "3000"));
        intervalPostReward = Integer.parseInt(sp.getString("shared_intervalPostReward", "3000"));
        timeOutDuration =
            Integer.parseInt(sp.getString("shared_timeoutDuration_min", "0")) * 1000 * 60 +
            Integer.parseInt(sp.getString("shared_timeoutDuration_sec", "0")) * 1000 +
            Integer.parseInt(sp.getString("shared_timeoutDuration_msec", "0"));
        cueColor = SystemUtils.getColor(getApplication(), sp, "shared_cueColor", "white");
        borderColor = SystemUtils.getColor(getApplication(), sp, "shared_borderColor", "yellow");
        cueSize = 10 * Integer.parseInt(sp.getString("shared_cueSize", "30"));
        cueBorderSize = 10 * Integer.parseInt(sp.getString("shared_cueBorderSize", "0"));
    }
}
