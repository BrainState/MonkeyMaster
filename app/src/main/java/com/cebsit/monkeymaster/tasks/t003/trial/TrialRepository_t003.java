package com.cebsit.monkeymaster.tasks.t003.trial;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class TrialRepository_t003 {
    private TrialDao_t003 trialDao_t003;
    private List<Trial_t003> trials_t003;

    public TrialRepository_t003(Context context, String fileName) {
        TrialDatabase_t003 trialDatabase_t003 = TrialDatabase_t003.getTrialDatabase_t003(context.getApplicationContext(), fileName);
        trialDao_t003 = trialDatabase_t003.getTrialDao_t003();
    }

    public void insertTrials_t003(Trial_t003... trial_t003) {
        new TrialRepository_t003.InsertTrials_t003AsyncTask(trialDao_t003).execute(trial_t003);
    }

    static class InsertTrials_t003AsyncTask extends AsyncTask<Trial_t003, Void, Void> {
        private TrialDao_t003 trialDao_t003;

        InsertTrials_t003AsyncTask(TrialDao_t003 trialDao_t003) {
            this.trialDao_t003 = trialDao_t003;
        }

        @Override
        protected Void doInBackground(Trial_t003... trials_t003) {
            trialDao_t003.insertTrial(trials_t003);
            return null;
        }

    }

}
