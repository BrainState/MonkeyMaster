package com.cebsit.monkeymaster.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "monkeys")
public class Monkey implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "monkey_id")
    private int monkeyId;

    @ColumnInfo(name = "monkey_name")
    private String monkeyName;

    private String gender;

    private Double weight;

    @Embedded
    private Birthmonth birthmonth;

    public Monkey() {
    }

    public int getMonkeyId() {
        return monkeyId;
    }

    public void setMonkeyId(int monkeyId) {
        this.monkeyId = monkeyId;
    }

    public String getMonkeyName() {
        return monkeyName;
    }

    public void setMonkeyName(String monkeyName) {
        this.monkeyName = monkeyName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Birthmonth getBirthmonth() {
        return birthmonth;
    }

    public void setBirthmonth(Birthmonth birthmonth) {
        this.birthmonth = birthmonth;
    }

    public String getMonkeyNameById(int monkeyId) {
        return monkeyName;
    }

    public static class Birthmonth implements Serializable {
        private int year;
        private int month;

        public Birthmonth() {}

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        @Override
        public String toString() {
            return year + "/" + month;
        }
    }
}
