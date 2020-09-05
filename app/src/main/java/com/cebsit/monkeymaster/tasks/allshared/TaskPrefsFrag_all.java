package com.cebsit.monkeymaster.tasks.allshared;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.cebsit.monkeymaster.R;

public class TaskPrefsFrag_all extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.prefs_shared, rootKey);
    }
}
