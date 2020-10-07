package com.cebsit.monkeymaster.tasks.t006.display;

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
import com.cebsit.monkeymaster.tasks.t006.display.ViewModel_t006;

public class IntervalFrag_t006 extends Fragment {
    ViewModel_t006 viewModel_t006;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_main_tasks_shared_empty, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel_t006 = new ViewModelProvider(this).get(ViewModel_t006.class);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                viewModel_t006.getTrial_t006().getTrialTime().setOver(new TimeFormat(System.currentTimeMillis()));
                viewModel_t006.insertTrials_t006();
                Navigation.findNavController(view).navigate(R.id.action_t006_intervalFrag_to_cueFrag);
            }
        },3000);
    }
}
