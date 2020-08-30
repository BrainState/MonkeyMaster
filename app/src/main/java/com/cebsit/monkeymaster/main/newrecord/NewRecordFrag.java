package com.cebsit.monkeymaster.main.newrecord;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;

import com.cebsit.monkeymaster.R;
import com.cebsit.monkeymaster.database.Monkey;
import com.cebsit.monkeymaster.main.MainViewModel;

import java.util.List;


public class NewRecordFrag extends PreferenceFragmentCompat {

    MainViewModel mainViewModel;
    LiveData<List<String>> allMonkeysLive;

    String[] monkeyIds;
    String[] monkeyNames;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.new_record, rootKey);

        final ListPreference taskPref = getPreferenceManager().findPreference("new_record_task");
        final ListPreference monkeyPref = getPreferenceManager().findPreference("new_record_task");

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }
}