package com.cebsit.monkeymaster.tasks;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.cebsit.monkeymaster.R;

public class TaskActivity extends AppCompatActivity {
    private static String fileName;
    private static String taskId;
    private SharedPreferences sp;
//    public static boolean trialRunning = false;


    public static String getFileName() {
        return fileName;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_task);
        taskId  = getIntent().getStringExtra("taskId");
        fileName = getIntent().getStringExtra("fileName");
        sp = getSharedPreferences(fileName, MODE_PRIVATE);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        int identify_nav_task = getResources().getIdentifier("nav_" + taskId, "navigation", getPackageName());
        NavHostFragment finalHost = NavHostFragment.create(identify_nav_task);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_tasks, finalHost)
                .setPrimaryNavigationFragment(finalHost)
                .commit();

        int backgroundColor = getResources().getIdentifier(sp.getString("shared_taskBackgroundColor", "black"),"color" , getPackageName());
        findViewById(R.id.container_tasks).setBackgroundColor(getResources().getColor(backgroundColor));

    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}