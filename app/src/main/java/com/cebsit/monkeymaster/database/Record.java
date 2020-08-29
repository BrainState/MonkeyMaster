package com.cebsit.monkeymaster.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "records")
public class Record {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "record_id")
    public int recordId;

    public String notes;

    @ColumnInfo(name = "creating_time")
    public String creatingTime;

    @ColumnInfo(name = "monkey_id")
    public int monkeyId;

    @ColumnInfo(name = "task_name")
    public String taskName;

    public Record() {
    }


}