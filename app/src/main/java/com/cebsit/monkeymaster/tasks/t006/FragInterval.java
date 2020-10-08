package com.cebsit.monkeymaster.tasks.t006;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.cebsit.monkeymaster.R;
import com.cebsit.monkeymaster.tasks.TimeFormat;

public class FragInterval extends Fragment {
    TrialViewModel trialViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_main_tasks_shared_empty, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        trialViewModel = new ViewModelProvider(this).get(TrialViewModel.class);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                trialViewModel.getTrial().getTrialTime().setOver(new TimeFormat(System.currentTimeMillis()));
                trialViewModel.insertTrials();
                Navigation.findNavController(view).navigate(R.id.action_t006_intervalFrag_to_cueFrag);
            }
        },3000);
    }
}
