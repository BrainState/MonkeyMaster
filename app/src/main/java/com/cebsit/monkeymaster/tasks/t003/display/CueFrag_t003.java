package com.cebsit.monkeymaster.tasks.t003.display;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.cebsit.monkeymaster.R;

public class CueFrag_t003 extends Fragment {
    ViewModel_t003 viewModel_t003;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_main_tasks_shared_cue, container, false);
        viewModel_t003 = new ViewModelProvider(this).get(ViewModel_t003.class);
        viewModel_t003.loadPrefs();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button bt_cue = view.findViewById(R.id.bt_cue);
        bt_cue.setBackgroundColor(getResources().getColor(viewModel_t003.cueColor));
        bt_cue.setWidth(viewModel_t003.cueSize);
        bt_cue.setHeight(viewModel_t003.cueSize);
        bt_cue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel_t003.initTrial();
                Navigation.findNavController(view).navigate(R.id.action_t003_cueFrag_to_stimuliFrag);
            }
        });
    }
}
