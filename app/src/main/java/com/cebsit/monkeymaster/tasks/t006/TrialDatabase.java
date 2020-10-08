package com.cebsit.monkeymaster.tasks.t006;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.cebsit.monkeymaster.tasks.TimeFormat;
import com.cebsit.monkeymaster.tasks.TrialTime;

import java.io.Serializable;

@Database(entities = {TrialDatabase.Trial.class}, version = 1, exportSchema = false)
public abstract class TrialDatabase extends RoomDatabase {
    private static TrialDatabase INSTANCE;

    static synchronized TrialDatabase getTrialDatabase(Context context, String trialsFileName) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TrialDatabase.class, trialsFileName).build();
        }
        return INSTANCE;
    }

    abstract TrialDao getTrialDao();

    @Dao
    interface TrialDao {
        @Insert
        void insertTrial(Trial... trials);
    }

    @Entity(tableName = "trials")
    static class Trial implements Serializable {
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "trial_id")
        private int trialId;
        @Embedded(prefix = "time_")
        private TrialTime trialTime;
        private boolean correct;
        @Embedded
        private Performance performance;

        int getTrialId() {
            return trialId;
        }

        void setTrialId(int trialId) {
            this.trialId = trialId;
        }

        TrialTime getTrialTime() {
            if (this.trialTime == null) {
                trialTime = new TrialTime();
            }
            return trialTime;
        }

        void setTrialTime(TrialTime trialTime) {
            this.trialTime = trialTime;
        }

        boolean isCorrect() {
            return correct;
        }

        void setCorrect(boolean correct) {
            this.correct = correct;
        }

        Performance getPerformance() {
            if (this.performance == null) {
                performance = new Performance();
            }
            return performance;
        }

        void setPerformance(Performance performance) {
            this.performance = performance;
        }

        static class Performance {
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
            @Embedded(prefix = "tapped_time_")
            private TimeFormat tappedTime;
            @ColumnInfo(name = "consecutive_correct_count")
            private int consecutiveCorrectCount;

            int getShift() {
                return shift;
            }

            void setShift(int shift) {
                this.shift = shift;
            }

            Stimulus getStimulus1() {
                return stimulus1;
            }

            void setStimulus1(Stimulus stimulus1) {
                this.stimulus1 = stimulus1;
            }

            Stimulus getStimulus2() {
                return stimulus2;
            }

            void setStimulus2(Stimulus stimulus2) {
                this.stimulus2 = stimulus2;
            }

            Stimulus getStimulus3() {
                return stimulus3;
            }

            void setStimulus3(Stimulus stimulus3) {
                this.stimulus3 = stimulus3;
            }

            int getTrueStimulusNum() {
                return trueStimulusNum;
            }

            void setTrueStimulusNum(int trueStimulusNum) {
                this.trueStimulusNum = trueStimulusNum;
            }

            int getTappedStimulusNum() {
                return tappedStimulusNum;
            }

            void setTappedStimulusNum(int tappedStimulusNum) {
                this.tappedStimulusNum = tappedStimulusNum;
            }

            TimeFormat getTappedTime() {
                return tappedTime;
            }

            void setTappedTime(TimeFormat tappedTime) {
                this.tappedTime = tappedTime;
            }

            int getConsecutiveCorrectCount() {
                return consecutiveCorrectCount;
            }

            void setConsecutiveCorrectCount(int consecutiveCorrectCount) {
                this.consecutiveCorrectCount = consecutiveCorrectCount;
            }

            static class Stimulus {
                private int row;
                private int column;
                private String color;
                private String shape;

                Stimulus(int row, int column, String color, String shape) {
                    this.row = row;
                    this.column = column;
                    this.color = color;
                    this.shape = shape;
                }

                int getRow() {
                    return row;
                }

                void setRow(int row) {
                    this.row = row;
                }

                int getColumn() {
                    return column;
                }

                void setColumn(int column) {
                    this.column = column;
                }

                String getColor() {
                    return color;
                }

                void setColor(String color) {
                    this.color = color;
                }

                String getShape() {
                    return shape;
                }

                void setShape(String shape) {
                    this.shape = shape;
                }
            }
        }
    }

    static class TrialRepository {
        private TrialDao trialDao;

        TrialRepository(Context context, String fileName) {
            TrialDatabase trialDatabase = getTrialDatabase(context.getApplicationContext(), fileName);
            trialDao = trialDatabase.getTrialDao();
        }

        void insertTrials(Trial... trials) {
            new InsertTrialsAsyncTask(trialDao).execute(trials);
        }
    }

    static class InsertTrialsAsyncTask extends AsyncTask<Trial, Void, Void> {
        private TrialDao trialDao;

        InsertTrialsAsyncTask(TrialDao trialDao) {
            this.trialDao = trialDao;
        }

        @Override
        protected Void doInBackground(Trial... trials) {
            trialDao.insertTrial(trials);
            return null;
        }
    }
}