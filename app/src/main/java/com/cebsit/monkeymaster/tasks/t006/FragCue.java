package com.cebsit.monkeymaster.tasks.t006;

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

public class FragCue extends Fragment {
    TrialViewModel trialViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_main_tasks_shared_cue, container, false);
        trialViewModel = new ViewModelProvider(this).get(TrialViewModel.class);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        trialViewModel.initTrial();
        trialViewModel.getTrial().getTrialTime().setReady(new TimeFormat(System.currentTimeMillis()));
        Button bt_cue = view.findViewById(R.id.bt_cue);
        bt_cue.setBackgroundColor(ContextCompat.getColor(view.getContext(), trialViewModel.cueColor));
        bt_cue.setWidth(trialViewModel.cueSize);
        bt_cue.setHeight(trialViewModel.cueSize);
        bt_cue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trialViewModel.getTrial().getTrialTime().setGo(new TimeFormat(System.currentTimeMillis()));
                Navigation.findNavController(view).navigate(R.id.action_t006_cueFrag_to_stimuliFrag);
            }
        });
    }
}
