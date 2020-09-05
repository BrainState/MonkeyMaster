package com.cebsit.monkeymaster.main;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.cebsit.monkeymaster.R;
import com.cebsit.monkeymaster.database.Monkey;
import com.cebsit.monkeymaster.main.homepage.taskgallery.Task;
import com.cebsit.monkeymaster.main.homepage.taskgallery.TasksContent;
import com.google.android.material.navigation.NavigationView;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cebsit.monkeymaster.main.homepage.taskgallery.TasksContent.monkeyNameMap;
import static com.cebsit.monkeymaster.main.homepage.taskgallery.TasksContent.taskList;
import static com.cebsit.monkeymaster.main.homepage.taskgallery.TasksContent.taskIdMap;
import static com.cebsit.monkeymaster.main.homepage.taskgallery.TasksContent.taskNameMap;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private NavController navController;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initTasks();


        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout_main);
        NavigationView navigationView = findViewById(R.id.nv_main);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.recordBookFrag, R.id.taskGalleryFrag, R.id.monkeyHouseFrag)
                .setDrawerLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getAllMonkeysLive().observe(this, new Observer<List<Monkey>>() {
            @Override
            public void onChanged(List<Monkey> monkeys) {
                for (Monkey monkey:monkeys) {
                    monkeyNameMap.put(monkey.getMonkeyName(), monkey);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }

    private void initTasks() {
        InputStream is = this.getResources().openRawResource(R.raw.tasks);
        try {
            taskList = TasksContent.getTasksFromJson(is);
            for (Task task : taskList) {
                taskIdMap.put(task.getTaskId(), task);
                taskNameMap.put(task.getTaskName(), task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initMonkeys() {

    }

}