package com.cebsit.monkeymaster.main.homepage.taskgallery;

import java.io.Serializable;

public class Task implements Serializable {
    private String taskId;
    private String taskName;
    private String intro;

    public Task(String taskId, String taskName, String intro) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.intro = intro;
    }

    public Task() {

    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
