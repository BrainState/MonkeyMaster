//package com.cebsit.monkeymaster.tasks.t006.trial;
//
//import android.content.Context;
//import android.os.AsyncTask;
//
//import com.cebsit.monkeymaster.tasks.t006.trial.TrialDao_t006;
//import com.cebsit.monkeymaster.tasks.t006.trial.TrialDatabase_t006;
//import com.cebsit.monkeymaster.tasks.t006.trial.Trial_t006;
//
//import java.util.List;
//
//public class TrialRepository_t006 {
//    private TrialDao_t006 trialDao_t006;
//    private List<Trial_t006> trials_t006;
//
//    public TrialRepository_t006(Context context, String fileName) {
//        TrialDatabase_t006 trialDatabase_t006 = TrialDatabase_t006.getTrialDatabase_t006(context.getApplicationContext(), fileName);
//        trialDao_t006 = trialDatabase_t006.getTrialDao_t006();
//    }
//
//    public void insertTrials_t006(Trial_t006... trial_t006) {
//        new TrialRepository_t006.InsertTrials_t006AsyncTask(trialDao_t006).execute(trial_t006);
//    }
//
//    static class InsertTrials_t006AsyncTask extends AsyncTask<Trial_t006, Void, Void> {
//        private TrialDao_t006 trialDao_t006;
//
//        InsertTrials_t006AsyncTask(TrialDao_t006 trialDao_t006) {
//            this.trialDao_t006 = trialDao_t006;
//        }
//
//        @Override
//        protected Void doInBackground(Trial_t006... trials_t006) {
//            trialDao_t006.insertTrial(trials_t006);
//            return null;
//        }
//
//    }
//
//}
