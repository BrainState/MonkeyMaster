package com.cebsit.monkeymaster.ui.taskgallery;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TasksContent {
    public static List<Task> taskList;
    public static Map<String, Task> taskMap = new HashMap<>();

    public static List<Task> getTasksFromJson (InputStream is) throws Exception {
        byte[] buffer = new byte[is.available()];
        is.read(buffer);
        String json = new String(buffer, "utf-8");
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Task>>() {}.getType();
        List<Task> taskList = gson.fromJson(json,listType);
        return taskList;
    }
}
