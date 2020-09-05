package com.cebsit.monkeymaster.tasks.t001;

import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;

import com.cebsit.monkeymaster.R;

public class Activity_t001 extends AppCompatActivity {

    private final static String taskId = "t001";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        if (findViewById(R.id.rl_taskViewsContainer) != null) {
            if (savedInstanceState != null) {
                return;
            }

            int identify_xml_task_prefs = getResources().getIdentifier("nav_" + taskId, "navigation", getPackageName());
            NavHostFragment navHostFragment = NavHostFragment.create(identify_xml_task_prefs);
            getSupportFragmentManager().beginTransaction().add(R.id.rl_taskViewsContainer, navHostFragment).commit();
        }

    }

}