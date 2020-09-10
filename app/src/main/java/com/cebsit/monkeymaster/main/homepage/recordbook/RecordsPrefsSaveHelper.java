package com.cebsit.monkeymaster.main.homepage.recordbook;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.Map;
import java.util.Set;

import static android.content.ContentValues.TAG;

public class RecordsPrefsSaveHelper {


    public static void saveRecordPrefs(Context context, String spFileName, String taskId) {
        SharedPreferences dfsp = PreferenceManager.getDefaultSharedPreferences(context);
        Map<String, ?> dfspMap = dfsp.getAll();
        Set<String> dfspKeySet = dfspMap.keySet();

        SharedPreferences sp = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        for (String prefkey : dfspKeySet) {
            String tag = "";
            try {
                tag = prefkey.split("_")[0];
            } catch (ArrayIndexOutOfBoundsException e) {
                Log.d(TAG, "saveRecordPrefs: prefTag wrong name");
            }
            //TODO
            if (tag.equals("system") || tag.equals("shared") || tag.equals(taskId)) {
                String key = prefkey.split("_")[1];
                String value = String.valueOf(dfspMap.get(prefkey));
                editor.putString(prefkey, value);
                editor.commit();
            }
        }
    }
}
