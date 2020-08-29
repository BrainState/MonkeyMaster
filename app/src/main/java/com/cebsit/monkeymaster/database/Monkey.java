package com.cebsit.monkeymaster.database;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "monkeys")
public class Monkey {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "monkey_id")
    public int monkeyId;

    @ColumnInfo(name = "monkey_name")
    public String monkeyName;

    public String gender;

    public Double weight;

    @Embedded
    public Birthmonth birthmonth;

    public Monkey() {
    }

    public static class Birthmonth {
        public int year;
        public int month;

        @Override
        public String toString() {
            return year + "/" + month;
        }
    }
}
