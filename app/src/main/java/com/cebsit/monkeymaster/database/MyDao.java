package com.cebsit.monkeymaster.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

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

    @Query("SELECT * FROM monkeys WHERE monkey_name = :selected_monkey_names")
    LiveData<Monkey> getMonkeyByName(String selected_monkey_names);

    @Transaction
    @Query("SELECT * FROM monkeys")
    List<MonkeyWithRecords> getMonkeyWithRecords();
}
