package com.cebsit.monkeymaster.ui.monkeyhouse;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import com.cebsit.monkeymaster.database.Monkey;
import com.cebsit.monkeymaster.database.MyRepository;

public class MonkeyHouseViewModel extends AndroidViewModel {
    private MyRepository myRepository;

    public MonkeyHouseViewModel(@NonNull Application application) {
        super(application);
        myRepository = new MyRepository(application);
    }

    LiveData<List<Monkey>> getAllMonkeysLive() {
        return myRepository.getAllMonkeysLive();
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
