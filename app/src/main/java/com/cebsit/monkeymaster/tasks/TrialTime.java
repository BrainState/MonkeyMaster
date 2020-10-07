package com.cebsit.monkeymaster.tasks;

import androidx.room.Embedded;

public class TrialTime {
    @Embedded(prefix = "start_")
    TimeFormat start;
    @Embedded(prefix = "go_")
    TimeFormat go;
    @Embedded(prefix = "over_")
    TimeFormat over;

    public TrialTime() {}

    public TimeFormat getStart() {
        return start;
    }

    public void setStart(TimeFormat start) {
        this.start = start;
    }

    public TimeFormat getGo() {
        return go;
    }

    public void setGo(TimeFormat go) {
        this.go = go;
    }

    public TimeFormat getOver() {
        return over;
    }

    public void setOver(TimeFormat over) {
        this.over = over;
    }

}