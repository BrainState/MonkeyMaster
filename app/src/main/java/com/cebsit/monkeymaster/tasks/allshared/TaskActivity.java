package com.cebsit.monkeymaster.tasks.allshared;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.preference.PreferenceFragmentCompat;

import com.cebsit.monkeymaster.R;

public class TaskActivity extends AppCompatActivity {

    private static String taskId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Intent intent = getIntent();
        taskId = intent.getStringExtra("taskId");

        if (findViewById(R.id.rl_taskViewsContainer) != null) {
            if (savedInstanceState != null) {
                return;
            }

            int identify_xml_task_prefs = getResources().getIdentifier("nav_" + taskId, "navigation", getPackageName());
            NavHostFragment navHostFragment = NavHostFragment.create(identify_xml_task_prefs);
            getSupportFragmentManager().beginTransaction().add(R.id.rl_taskViewsContainer, navHostFragment).commit();
        }
    }

    public static class TaskPrefFrag extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            int identify_xml_task_prefs = getResources().getIdentifier("prefs_" + taskId, "xml", getActivity().getPackageName());
            setPreferencesFromResource(identify_xml_task_prefs, rootKey);
        }
    }
}
