package com.cebsit.monkeymaster.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.cebsit.monkeymaster.database.Monkey;
import com.cebsit.monkeymaster.database.room.MyRepository;
import com.cebsit.monkeymaster.database.Record;

import java.util.List;


public class MainViewModel extends AndroidViewModel {
    private MyRepository myRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        myRepository = new MyRepository(application);
    }

    public LiveData<List<Record>> getAllRecordsLive() {
        return myRepository.getAllRecordsLive();
    }

    public LiveData<List<Monkey>> getAllMonkeysLive() {
        return myRepository.getAllMonkeysLive();
    }

    public LiveData<List<String>> getAllMonkeysNameLive() {
        return myRepository.getAllMonkeysNameLive();
    }

    public void insertRecords(Record... records) {
        myRepository.insertRecords(records);
    }

    public void updateRecords(Record... records) {
        myRepository.updateRecords(records);
    }

    public void deleteRecords(Record... records) {
        myRepository.deleteRecords(records);
    }

    public void deleteAllRecords() {
        myRepository.deleteAllRecords();
    }

    public void insertMonkeys(Monkey... monkeys) {
        myRepository.insertMonkeys(monkeys);
    }

    public void updateMonkeys(Monkey... monkeys) {
        myRepository.updateMonkeys(monkeys);
    }

    public void deleteMonkeys(Monkey... monkeys) {
        myRepository.deleteMonkeys(monkeys);
    }

    public void deleteAllMonkeys() {
        myRepository.deleteAllMonkeys();
    }
}
