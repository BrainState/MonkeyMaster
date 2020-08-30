package com.cebsit.monkeymaster.database.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.cebsit.monkeymaster.database.Monkey;
import com.cebsit.monkeymaster.database.MonkeyWithRecords;
import com.cebsit.monkeymaster.database.Record;

import java.util.List;

@Dao
public interface MyDao {
    @Insert
    void insertRecords(Record... records);

    @Update
    void updateRecords(Record... records);

    @Delete
    void deleteRecords(Record... records);

    @Query("DELETE FROM records")
    void deleteAllRecords();

    @Query("SELECT * FROM records ORDER BY record_id DESC")
    LiveData<List<Record>> getAllRecordsLive();

    @Insert
    void insertMonkeys(Monkey... monkeys);

    @Update
    void updateMonkeys(Monkey... monkeys);

    @Delete
    void deleteMonkeys(Monkey... monkeys);

    @Query("DELETE FROM monkeys")
    void deleteAllMonkeys();

    @Query("SELECT * FROM monkeys ORDER BY monkey_id DESC")
    LiveData<List<Monkey>> getAllMonkeysLive();

    @Query("SELECT monkey_name FROM monkeys")
    LiveData<List<String>> getAllMonkeysNameLive();

    @Query("SELECT monkey_id FROM monkeys WHERE monkey_name LIKE :selected_monkey_name")
    LiveData<Integer> getMonkeyIdByName(String selected_monkey_name);

    @Query("SELECT monkey_name FROM monkeys WHERE monkey_id LIKE :selected_monkey_id ")
    LiveData<String> getMonkeyNameById(int selected_monkey_id);

    @Transaction
    @Query("SELECT * FROM monkeys")
    List<MonkeyWithRecords> getMonkeyWithRecords();
}
