package com.cebsit.monkeymaster.tasks;

import androidx.room.Embedded;

public class TrialTime {
    @Embedded(prefix = "ready_")
    TimeFormat ready;
    @Embedded(prefix = "go_")
    TimeFormat go;
    @Embedded(prefix = "over_")
    TimeFormat over;

    public TrialTime() {}

    public TimeFormat getReady() {
        return ready;
    }

    public void setReady(TimeFormat ready) {
        this.ready = ready;
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