package com.cebsit.monkeymaster.main.newmonkey;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import com.cebsit.monkeymaster.R;
import com.cebsit.monkeymaster.backend.SystemUtils;
import com.cebsit.monkeymaster.database.Monkey;
import com.cebsit.monkeymaster.main.MainViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import static com.cebsit.monkeymaster.main.homepage.taskgallery.TasksContent.monkeyNameMap;


public class NewMonkeyFrag extends PreferenceFragmentCompat {

    private MainViewModel mainViewModel;
    private SharedPreferences sp;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.new_monkey, rootKey);

        sp = PreferenceManager.getDefaultSharedPreferences(getContext());

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        //TODO 增加功能：根据传过来的值自动调整设置界面

        final FloatingActionButton fab_save = getActivity().findViewById(R.id.fab_save);
        fab_save.setVisibility(View.VISIBLE);
        fab_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Monkey monkey = new Monkey();
                monkey.setMonkeyName(sp.getString("monkey_name", ""));
                monkey.setGender(sp.getString("monkey_gender", "Male"));
                monkey.setWeight(Double.parseDouble(sp.getString("monkey_weight", "0")));
                Monkey.Birthmonth birthmonth = new Monkey.Birthmonth();
                birthmonth.setYear(Integer.parseInt(sp.getString("monkey_birthmonth_year", "0")));
                birthmonth.setMonth(Integer.parseInt(sp.getString("monkey_birthmonth_month", "0")));
                monkey.setBirthmonth(birthmonth);

                int presentYear = SystemUtils.timeIntConverter("yyyy");
                if (monkey.getMonkeyName().equals("")) {
                    Snackbar.make(view, getResources().getString(R.string.snackbar_msg_new_monkey_name_empty), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                } else if (monkeyNameMap.keySet().contains(monkey.getMonkeyName())) {
                    Snackbar.make(view, getResources().getString(R.string.snackbar_msg_new_monkey_name_exist), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                } else if (monkey.getWeight() <= 0) {
                    Snackbar.make(view, getResources().getString(R.string.snackbar_msg_new_monkey_weight), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                } else if (monkey.getBirthmonth().getYear() < 1970 || monkey.getBirthmonth().getYear() > presentYear) {
                    Snackbar.make(view, getResources().getString(R.string.snackbar_msg_new_monkey_birthmonth_year), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                } else if (monkey.getBirthmonth().getMonth() < 1 || monkey.getBirthmonth().getMonth() > 12) {
                    Snackbar.make(view, getResources().getString(R.string.snackbar_msg_new_monkey_birthmonth_month), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                } else {
                    mainViewModel.insertMonkeys(monkey);
                    Snackbar.make(view, getResources().getString(R.string.snackbar_msg_success_save), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    fab_save.setVisibility(View.INVISIBLE);
                    Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.action_newMonkeyFrag_to_monkeyHouseFrag);
                }
            }
        });

    }
}