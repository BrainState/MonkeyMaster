package com.cebsit.monkeymaster.main.newrecord;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import com.cebsit.monkeymaster.R;
import com.cebsit.monkeymaster.backend.UtilsSystem;
import com.cebsit.monkeymaster.database.Monkey;
import com.cebsit.monkeymaster.database.Record;
import com.cebsit.monkeymaster.main.MainViewModel;
import com.cebsit.monkeymaster.main.homepage.taskgallery.Task;
import com.cebsit.monkeymaster.main.homepage.taskgallery.TasksContent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.cebsit.monkeymaster.main.homepage.taskgallery.TasksContent.getTasksCount;
import static com.cebsit.monkeymaster.main.homepage.taskgallery.TasksContent.monkeyNameMap;
import static com.cebsit.monkeymaster.main.homepage.taskgallery.TasksContent.taskIdMap;
import static com.cebsit.monkeymaster.main.homepage.taskgallery.TasksContent.taskNameMap;


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

        taskPref = getPreferenceManager().findPreference("new_record_task");
        monkeyPref = getPreferenceManager().findPreference("new_record_monkey");
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        monkeysName = monkeyNameMap.keySet().toArray(new String[monkeyNameMap.size()]);
        monkeyPref.setEntries(monkeysName);
        monkeyPref.setEntryValues(monkeysName);

        String[] taskNames = taskNameMap.keySet().toArray(new String[getTasksCount()]);
        String[] taskIds = taskIdMap.keySet().toArray(new String[getTasksCount()]);
        taskPref.setEntries(taskNames);
        taskPref.setEntryValues(taskIds);

        final FloatingActionButton fab_save = getActivity().findViewById(R.id.fab_save);
        fab_save.setVisibility(View.VISIBLE);
        fab_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Record newRecord = new Record();
                newRecord.setTaskId(sp.getString("new_record_task","t001"));
                newRecord.setCreatingTime((new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(new Time(System.currentTimeMillis())));
                newRecord.setMonkey(monkeyNameMap.get(sp.getString("new_record_monkey","")));
                newRecord.setNotes(sp.getString("prefkey_record_notes","not set"));

                mainViewModel.insertRecords(newRecord);

                fab_save.setVisibility(View.INVISIBLE);
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.action_newRecordFrag_to_recordBookFrag);
            }
        });
    }

}