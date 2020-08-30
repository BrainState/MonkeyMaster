//package com.cebsit.monkeymaster.ui.recordbook;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.preference.PreferenceManager;
//import android.util.Log;
//
//
//import com.cebsit.monkeymaster.database.Record;
//
//import java.util.Map;
//import java.util.Set;
//
//
//import static android.content.ContentValues.TAG;
//
//public class RecordsPrefsSaveHelper {
//
//
//    public static String saveRecordPrefs(Context context, Record record) {
//        SharedPreferences dfsp = PreferenceManager.getDefaultSharedPreferences(context);
//        Map<String, ?> dfspMap = dfsp.getAll();
//        Set<String> dfspKeySet = dfspMap.keySet();
//
//        String fileName = "";
//        fileName = record.creatingTime.replaceAll(":","");
//        fileName = "RecordPref_" + fileName.replaceAll("/","") + "_" + String.valueOf(record.recordId);
//        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sp.edit();
//
//        for (String preftag : dfspKeySet) {
//            String taskId = "";
//            try {
//                taskId = preftag.split("_")[1];
//            } catch (ArrayIndexOutOfBoundsException e) {
//                Log.d(TAG, "saveRecordPrefs: prefTag wrong name");
//            }
//            //TODO
//            if (taskId.equals("system")|| taskId.equals(record.taskName)) {
//                String key = preftag.split("_")[2];
//                String value = String.valueOf(dfspMap.get(preftag));
//                editor.putString(key,value);
//                editor.commit();
//            }
//        }
//
//        return fileName;
//    }
//}
