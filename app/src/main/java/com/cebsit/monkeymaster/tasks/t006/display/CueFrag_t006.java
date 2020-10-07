package com.cebsit.monkeymaster.tasks.t006.display;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.cebsit.monkeymaster.R;
import com.cebsit.monkeymaster.tasks.TimeFormat;
import com.cebsit.monkeymaster.tasks.TrialTime;

public class CueFrag_t006 extends Fragment {
    ViewModel_t006 viewModel_t006;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_main_tasks_shared_cue, container, false);
        viewModel_t006 = new ViewModelProvider(this).get(ViewModel_t006.class);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        TrialTime trialTime = new TrialTime();
        viewModel_t006.initTrial();
//        trialTime.setStart(new TimeFormat(System.currentTimeMillis()));
        viewModel_t006.getTrial_t006().getTrialTime().setStart(new TimeFormat(System.currentTimeMillis()));
        Button bt_cue = view.findViewById(R.id.bt_cue);
        bt_cue.setBackgroundColor(ContextCompat.getColor(view.getContext(), viewModel_t006.cueColor));
        bt_cue.setWidth(viewModel_t006.cueSize);
        bt_cue.setHeight(viewModel_t006.cueSize);
        bt_cue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel_t006.getTrial_t006().getTrialTime().setGo(new TimeFormat(System.currentTimeMillis()));
                Navigation.findNavController(view).navigate(R.id.action_t006_cueFrag_to_stimuliFrag);
            }
        });
    }
}
