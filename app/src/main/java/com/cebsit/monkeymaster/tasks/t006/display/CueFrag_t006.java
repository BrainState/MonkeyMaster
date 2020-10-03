package com.cebsit.monkeymaster.tasks.t006.display;

import android.content.Context;
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
import com.cebsit.monkeymaster.tasks.t003.display.ViewModel_t003;

public class CueFrag_t006 extends Fragment {
    ViewModel_t006 viewModel_t006;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_main_tasks_shared_cue, container, false);
        viewModel_t006 = new ViewModelProvider(this).get(ViewModel_t006.class);
//        viewModel_t006.loadSharedPrefs(getActivity().getSharedPreferences(getActivity().getIntent().getStringExtra("fileName"), Context.MODE_PRIVATE));
//        viewModel_t006.loadDatabase(getActivity().getIntent().getStringExtra("fileName"));
//        viewModel_t006.loadPrefs();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button bt_cue = view.findViewById(R.id.bt_cue);
//        bt_cue.setBackgroundColor(getResources().getColor(viewModel_t003.cueColor));
//        bt_cue.setWidth(viewModel_t003.cueSize);
//        bt_cue.setHeight(viewModel_t003.cueSize);
        bt_cue.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.white));
        bt_cue.setWidth(300);
        bt_cue.setHeight(300);
        bt_cue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel_t006.initTrial();
                Navigation.findNavController(view).navigate(R.id.action_t006_cueFrag_to_stimuliFrag);
            }
        });
    }
}
