package com.cebsit.monkeymaster.main.newrecord;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import com.cebsit.monkeymaster.R;
import com.cebsit.monkeymaster.database.Record;
import com.cebsit.monkeymaster.main.MainViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Time;
import java.text.SimpleDateFormat;

import static com.cebsit.monkeymaster.main.homepage.taskgallery.TasksContent.getTasksCount;
import static com.cebsit.monkeymaster.main.homepage.taskgallery.TasksContent.monkeyNameMap;
import static com.cebsit.monkeymaster.main.homepage.taskgallery.TasksContent.taskList;


public class NewRecordFrag extends PreferenceFragmentCompat {

    private MainViewModel mainViewModel;

    ListPreference taskPref;
    ListPreference monkeyPref;

    private String[] monkeysName;

    private SharedPreferences sp;


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.new_record, rootKey);

        sp = PreferenceManager.getDefaultSharedPreferences(getContext());

        taskPref = getPreferenceManager().findPreference("record_task");
        monkeyPref = getPreferenceManager().findPreference("record_monkey");
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        monkeysName = monkeyNameMap.keySet().toArray(new String[monkeyNameMap.size()]);
        monkeyPref.setEntries(monkeysName);
        monkeyPref.setEntryValues(monkeysName);

//        String[] taskNames = taskNameMap.keySet().toArray(new String[getTasksCount()]);
        String[] taskNames = new String[getTasksCount()];
//        String[] taskIds = taskIdMap.keySet().toArray(new String[getTasksCount()]);
        String[] taskIds = new String[getTasksCount()];

        for (int i=0;i<getTasksCount();i++) {
            taskNames[i] = taskList.get(i).getTaskName();
            taskIds[i] = taskList.get(i).getTaskId();
        }
        taskPref.setEntries(taskNames);
        taskPref.setEntryValues(taskIds);

        final FloatingActionButton fab_save = getActivity().findViewById(R.id.fab_save);
        fab_save.setVisibility(View.VISIBLE);
        fab_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Record newRecord = new Record();
                newRecord.setTaskId(sp.getString("record_task","t001"));
                newRecord.setCreatingTime((new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(new Time(System.currentTimeMillis())));
                newRecord.setMonkey(monkeyNameMap.get(sp.getString("record_monkey","")));
                newRecord.setNotes(sp.getString("record_notes","not set"));

                mainViewModel.insertRecords(newRecord);

                fab_save.setVisibility(View.INVISIBLE);
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.action_newRecordFrag_to_recordBookFrag);
            }
        });
    }

}