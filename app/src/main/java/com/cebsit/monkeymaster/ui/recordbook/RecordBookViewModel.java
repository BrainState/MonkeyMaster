package com.cebsit.monkeymaster.ui.recordbook;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.cebsit.monkeymaster.database.MyRepository;
import com.cebsit.monkeymaster.database.Record;

import java.util.List;


public class RecordBookViewModel extends AndroidViewModel {
    private MyRepository myRepository;

    public RecordBookViewModel(@NonNull Application application) {
        super(application);
        myRepository = new MyRepository(application);
    }

    LiveData<List<Record>> getAllRecordsLive() {
        return myRepository.getAllRecordsLive();
    }

    void insertRecords(Record... records) {
        myRepository.insertRecords(records);
    }

    void updateRecords(Record... records) {
        myRepository.updateRecords(records);
    }

    void deleteRecords(Record... records) {
        myRepository.deleteRecords(records);
    }

    void deleteAllRecords() {
        myRepository.deleteAllRecords();
    }
}
