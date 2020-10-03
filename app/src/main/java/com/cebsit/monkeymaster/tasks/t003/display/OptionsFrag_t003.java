package com.cebsit.monkeymaster.tasks.t003.display;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.cebsit.monkeymaster.R;
import com.cebsit.monkeymaster.backend.SystemUtils;

public class OptionsFrag_t003 extends Fragment {
    ViewModel_t003 viewModel_t003;
    private int trueStimulusIndex;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        trueStimulusIndex = getArguments().getInt("trueStimulusIndex");
        return inflater.inflate(R.layout.frag_main_tasks_shared_empty, container, false);
//        Point centre = SystemUtils.getScreenCentre(getActivity());
//        Button[] choices = new Button[8];
//        ConstraintLayout container_square = root.findViewById(R.id.container_empty);
//        for (int i=0;i<choices.length;i++) {
//            choices[i] = new Button(getContext());
//            choices[i].setWidth(200);
//            choices[i].setHeight(200);
//            choices[i].setX((float) (centre.x + centre.x*7/10*Math.cos(2*3.14*i/choices.length) - 200/2.0));
//            choices[i].setY((float) (centre.y + centre.x*7/10*Math.sin(2*3.14*i/choices.length) - 200/2.0));
//            container_square.addView(choices[i]);
//        }
//        return root;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel_t003 = new ViewModelProvider(this).get(ViewModel_t003.class);
        Handler step1 = new Handler();
        step1.postDelayed(new Runnable() {
            @Override
            public void run() {
                ViewModel_t003.timerRunning = true;
                Point centre = SystemUtils.getScreenCentre(getActivity());
                Button[] choices = new Button[ViewModel_t003.stimuliCount];
                ConstraintLayout container_square = view.findViewById(R.id.container_empty);
                for (int i=0;i<choices.length;i++) {
                    choices[i] = new Button(getContext());
                    choices[i].setWidth(ViewModel_t003.cueSize);
                    choices[i].setHeight(ViewModel_t003.cueSize);
                    choices[i].setX((float) (centre.x + centre.x*7/10*Math.cos(2*3.14*i/choices.length) - ViewModel_t003.cueSize/2.0));
                    choices[i].setY((float) (centre.y + centre.x*7/10*Math.sin(2*3.14*i/choices.length) - ViewModel_t003.cueSize/2.0));
                    container_square.addView(choices[i]);
                    final int finalI = i;
                    choices[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            viewModel_t003.getTrial_t003().setTappedOrientation(finalI*(360/(ViewModel_t003.stimuliCount)));
                            long currentTime = System.currentTimeMillis();
                            viewModel_t003.getTrial_t003().setTappedTimeStamp(currentTime);
                            viewModel_t003.getTrial_t003().setTappedTime(SystemUtils.timeConverter(currentTime));
                            if (finalI == trueStimulusIndex) {
                                Navigation.findNavController(view).navigate(R.id.action_t003_optionsFrag_to_rewardFrag);
                                viewModel_t003.getTrial_t003().setCorrect(true);
                            } else {
                                Navigation.findNavController(view).navigate(R.id.action_t003_optionsFrag_to_errorFrag);
                                viewModel_t003.getTrial_t003().setCorrect(false);
                            }
                            ViewModel_t003.timerRunning = false;
                        }
                    });
                }
//                choices[stimuliIndex].setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Navigation.findNavController(view).navigate(R.id.action_t003_optionsFrag_to_rewardFrag);
//                    }
//                });
            }
        }, ViewModel_t003.intervalPreOptions);

        Handler step2 = new Handler();
        step2.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (ViewModel_t003.timerRunning) {
                    Navigation.findNavController(view).navigate(R.id.action_t003_optionsFrag_to_errorFrag);
                }
            }
        },ViewModel_t003.intervalPreOptions + ViewModel_t003.timeOutDuration);
    }
}
