package com.cebsit.monkeymaster.tasks.t003.display;

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
import com.cebsit.monkeymaster.backend.SystemUtils;

public class IntervalFrag_t003 extends Fragment {
    ViewModel_t003 viewModel_t003;
    private int intervalTrials;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        intervalTrials = SystemUtils.getPossionVariable(10000.00);
        return inflater.inflate(R.layout.frag_main_tasks_shared_empty, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel_t003 = new ViewModelProvider(this).get(ViewModel_t003.class);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                viewModel_t003.insertTrials_t003();
                Navigation.findNavController(view).navigate(R.id.action_t003_intervalFrag_to_cueFrag);
            }
        },intervalTrials);
    }
}
