package com.cebsit.monkeymaster.tasks.t003;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;

public class TaskPrefsFrag_t003 extends PreferenceFragmentCompat implements EditTextPreference.OnBindEditTextListener {

    private static String taskId;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        final Intent intent = getActivity().getIntent();
        taskId = intent.getStringExtra("taskId");
        int identify_xml_task_prefs = getResources().getIdentifier("prefs_" + taskId, "xml", getActivity().getPackageName());
        setPreferencesFromResource(identify_xml_task_prefs, rootKey);

        ListPreference lp_distractorsNum = findPreference("t003_distractorsNum");
        lp_distractorsNum.setEntries(new String[]{"1", "3", "7"});
        lp_distractorsNum.setEntryValues(new String[]{"1", "3", "7"});

    }


    @Override
    public void onBindEditText(@NonNull EditText editText) {
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
    }
}
