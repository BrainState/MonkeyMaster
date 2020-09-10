package com.cebsit.monkeymaster.tasks.t002;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;


public class TaskPrefsFrag_t002 extends PreferenceFragmentCompat implements EditTextPreference.OnBindEditTextListener {

    private static String taskId;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        final Intent intent = getActivity().getIntent();
        taskId = intent.getStringExtra("taskId");
        int identify_xml_task_prefs = getResources().getIdentifier("prefs_" + taskId, "xml", getActivity().getPackageName());
        setPreferencesFromResource(identify_xml_task_prefs, rootKey);

        ListPreference lp_numDistractors = findPreference("t002_distractorsNum");
        lp_numDistractors.setEntries(new String[]{"1", "2", "3"});
        lp_numDistractors.setEntryValues(new String[]{"1", "2", "3"});

        EditTextPreference etp_durationON = findPreference("t002_durationON");
        EditTextPreference etp_durationOFF = findPreference("t002_durationOFF");
        EditTextPreference etp_startDelay = findPreference("t002_startDelay");

        etp_durationON.setOnBindEditTextListener(this);
        etp_durationOFF.setOnBindEditTextListener(this);
        etp_startDelay.setOnBindEditTextListener(this);

    }


    @Override
    public void onBindEditText(@NonNull EditText editText) {
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
    }
}
