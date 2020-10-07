package com.cebsit.monkeymaster.tasks;

import com.cebsit.monkeymaster.backend.SystemUtils;

public class TimeFormat {
    long stamp;
    String string;

    public TimeFormat() {}

    public TimeFormat(long currentTime) {
        this.stamp = currentTime;
        this.string = SystemUtils.timeConverter(currentTime);
    }

    public long getStamp() {
        return stamp;
    }

    public void setStamp(long stamp) {
        this.stamp = stamp;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
