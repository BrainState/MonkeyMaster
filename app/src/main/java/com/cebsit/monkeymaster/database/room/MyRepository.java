package com.cebsit.monkeymaster.database.room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.cebsit.monkeymaster.database.Monkey;
import com.cebsit.monkeymaster.database.Record;

import java.util.List;

public class MyRepository {
    private MyDao myDao;
    private LiveData<List<Monkey>> allMonkeysLive;
    private LiveData<List<Record>> allRecordsLive;

    public MyRepository(Context context) {
        MyDatabase myDatabase = MyDatabase.getDatabase(context.getApplicationContext());
        myDao = myDatabase.getMyDao();
    }

    public void insertMonkeys(Monkey... monkeys) {
        new MyRepository.InsertMonkeysAsyncTask(myDao).execute(monkeys);
    }

    public void updateMonkeys(Monkey... monkeys) {
        new MyRepository.UpdateMonkeysAsyncTask(myDao).execute(monkeys);
    }

    public void deleteMonkeys(Monkey... monkeys) {
        new MyRepository.DeleteMonkeysAsyncTask(myDao).execute(monkeys);
    }

    public void deleteAllMonkeys(Monkey... monkeys) {
        new MyRepository.DeleteAllMonkeysAsyncTask(myDao).execute();
    }

    public void insertRecords(Record... records) {
        new MyRepository.InsertAsyncTask(myDao).execute(records);
    }

    public void updateRecords(Record... records) {
        new MyRepository.UpdateAsyncTask(myDao).execute(records);
    }

    public void deleteRecords(Record... records) {
        new MyRepository.DeleteRecordsAsyncTask(myDao).execute(records);
    }

    public void deleteAllRecords(Record... records) {
        new MyRepository.DeleteAllRecordsAsyncTask(myDao).execute();
    }

    public LiveData<List<Monkey>> getAllMonkeysLive() {
        return myDao.getAllMonkeysLive();
    }

    public LiveData<List<String>> getAllMonkeysNameLive() {
        return myDao.getAllMonkeysNameLive();
    }

    public LiveData<List<Record>> getAllRecordsLive() {
        return myDao.getAllRecordsLive();
    }

    public LiveData<Integer> getMonkeyIdByName(String monkey_name) {
        return myDao.getMonkeyIdByName(monkey_name);
    }

    public LiveData<String> getMonkeyNameById(int monkey_id) {
        return myDao.getMonkeyNameById(monkey_id);
    }

    static class InsertMonkeysAsyncTask extends AsyncTask<Monkey, Void, Void> {
        private MyDao myDao;

        InsertMonkeysAsyncTask(MyDao myDao) {
            this.myDao = myDao;
        }

        @Override
        protected Void doInBackground(Monkey... monkeys) {
            myDao.insertMonkeys(monkeys);
            return null;
        }

    }

    static class UpdateMonkeysAsyncTask extends AsyncTask<Monkey, Void, Void> {
        private MyDao myDao;

        UpdateMonkeysAsyncTask(MyDao myDao) {
            this.myDao = myDao;
        }

        @Override
        protected Void doInBackground(Monkey... monkeys) {
            myDao.updateMonkeys(monkeys);
            return null;
        }

    }

    static class DeleteMonkeysAsyncTask extends AsyncTask<Monkey, Void, Void> {
        private MyDao myDao;

        DeleteMonkeysAsyncTask(MyDao myDao) {
            this.myDao = myDao;
        }

        @Override
        protected Void doInBackground(Monkey... monkeys) {
            myDao.deleteMonkeys(monkeys);
            return null;
        }

    }

    static class DeleteAllMonkeysAsyncTask extends AsyncTask<Void, Void, Void> {
        private MyDao myDao;

        DeleteAllMonkeysAsyncTask(MyDao myDao) {
            this.myDao = myDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            myDao.deleteAllMonkeys();
            return null;
        }

    }

    static class InsertAsyncTask extends AsyncTask<Record, Void, Void> {
        private MyDao myDao;

        InsertAsyncTask(MyDao myDao) {
            this.myDao = myDao;
        }

        @Override
        protected Void doInBackground(Record... records) {
            myDao.insertRecords(records);
            return null;
        }

    }

    static class UpdateAsyncTask extends AsyncTask<Record, Void, Void> {
        private MyDao myDao;

        UpdateAsyncTask(MyDao myDao) {
            this.myDao = myDao;
        }

        @Override
        protected Void doInBackground(Record... records) {
            myDao.updateRecords(records);
            return null;
        }

    }

    static class DeleteRecordsAsyncTask extends AsyncTask<Record, Void, Void> {
        private MyDao myDao;

        DeleteRecordsAsyncTask(MyDao myDao) {
            this.myDao = myDao;
        }

        @Override
        protected Void doInBackground(Record... records) {
            myDao.deleteRecords(records);
            return null;
        }

    }

    static class DeleteAllRecordsAsyncTask extends AsyncTask<Void, Void, Void> {
        private MyDao myDao;

        DeleteAllRecordsAsyncTask(MyDao myDao) {
            this.myDao = myDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            myDao.deleteAllRecords();
            return null;
        }

    }
}
