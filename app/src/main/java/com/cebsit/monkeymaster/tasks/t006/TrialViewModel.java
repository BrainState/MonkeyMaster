package com.cebsit.monkeymaster.tasks.t006;

import android.app.Application;

import androidx.annotation.NonNull;

import com.cebsit.monkeymaster.tasks.TaskViewModel;
import com.cebsit.monkeymaster.tasks.t006.TrialDatabase.Trial;
import com.cebsit.monkeymaster.tasks.t006.TrialDatabase.TrialRepository;

public class TrialViewModel extends TaskViewModel {
    static TrialRepository trialRepository;
    static Trial trial;

    static int consecutiveCorrectCount;
    static int shift;

    public TrialViewModel(@NonNull Application application) {
        super(application);
        trialRepository = new TrialRepository(getApplication(), super.fileName);
    }

    void initTrial() {
        trial = new Trial();
    }

    Trial getTrial() {
        return trial;
    }

    void insertTrials() {
        trialRepository.insertTrials(trial);
    }

    int getCCC() {
        return consecutiveCorrectCount;
    }

    int getShift() {
        return shift;
    }

    void addCCC() {
        if (getCCC() < 10) {
            consecutiveCorrectCount++;
        } else {
            consecutiveCorrectCount = 1;
        }
    }

    void resetCCC() {
        consecutiveCorrectCount = 0;
    }

    void changeShift() {
        if (getShift() < 4) {
            shift++;
        } else {
            shift = 0;
        }
    }
}
