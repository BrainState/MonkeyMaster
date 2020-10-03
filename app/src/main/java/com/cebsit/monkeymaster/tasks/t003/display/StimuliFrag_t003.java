package com.cebsit.monkeymaster.tasks.t003.display;

import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.cebsit.monkeymaster.R;
import com.cebsit.monkeymaster.backend.SystemUtils;

import java.util.Random;

public class StimuliFrag_t003 extends Fragment {

    ViewModel_t003 viewModel_t003;

    private int trueStimulusIndex;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_main_tasks_shared_empty, container, false);
//        Point centre = SystemUtils.getScreenCentre(getActivity());
//        Button[] choices = new Button[8];
//        ConstraintLayout container_square = root.findViewById(R.id.container_empty);
//        for (int i=0;i<choices.length;i++) {
//            choices[i] = new Button(getContext());
//            GradientDrawable drawable = new GradientDrawable();
//            drawable.setShape(GradientDrawable.OVAL); //use different shape to denote a response cue
//            drawable.setColor(ContextCompat.getColor(getContext(), R.color.design_default_color_error));
//            drawable.setStroke(5, ContextCompat.getColor(getContext(), R.color.black_overlay));
//            choices[i].setBackground(drawable);
//            choices[i].setHeight(200);
//            choices[i].setWidth(200);
//            choices[i].setX((float) (centre.x + centre.x*7/10*Math.cos(2*3.14*i/choices.length) - 200/2.0));
//            choices[i].setY((float) (centre.y + centre.x*7/10*Math.sin(2*3.14*i/choices.length) - 200/2.0));
//            container_square.addView(choices[i]);
//        }
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel_t003 = new ViewModelProvider(this).get(ViewModel_t003.class);
        Random r = new Random();
        trueStimulusIndex = r.nextInt(ViewModel_t003.stimuliCount);
        viewModel_t003.getTrial_t003().setTrueStimulusOrientation(trueStimulusIndex * (360/ViewModel_t003.stimuliCount));



        Handler step1 = new Handler();
        step1.postDelayed(new Runnable() {
            @Override
            public void run() {
                Point centre = SystemUtils.getScreenCentre(getActivity());
                Button[] choices = new Button[ViewModel_t003.stimuliCount];
                ConstraintLayout container_square = view.findViewById(R.id.container_empty);
                for (int i=0;i<choices.length;i++) {
                    choices[i] = new Button(getContext());
                    GradientDrawable drawable = new GradientDrawable();
                    drawable.setShape(GradientDrawable.OVAL);
                    drawable.setColor(ContextCompat.getColor(getContext(), ViewModel_t003.falseStimuliColor));
//                    drawable.setStroke(5, ContextCompat.getColor(getContext(), R.color.black_overlay));
                    choices[i].setBackground(drawable);
//                    choices[i].setBackgroundColor(viewModel_t003.distractorsColor);
                    choices[i].setHeight(ViewModel_t003.cueSize);
                    choices[i].setWidth(ViewModel_t003.cueSize);
                    choices[i].setX((float) (centre.x + centre.x*7/10*Math.cos(2*3.14*i/choices.length) - ViewModel_t003.cueSize /2));
                    choices[i].setY((float) (centre.y + centre.x*7/10*Math.sin(2*3.14*i/choices.length) - ViewModel_t003.cueSize /2));
                    container_square.addView(choices[i]);
                }

                GradientDrawable drawable = new GradientDrawable();
                drawable.setShape(GradientDrawable.OVAL);
                drawable.setColor(getResources().getColor(viewModel_t003.trueStimulusColor));
                choices[trueStimulusIndex].setBackground(drawable);
//                choices[stimuliIndex].setBackgroundColor(viewModel_t003.stimuliColor);
            }
        }, ViewModel_t003.intervalPreStimuli);

        Handler step2 = new Handler();
        step2.postDelayed(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putInt("trueStimulusIndex", trueStimulusIndex);
//                NavHostFragment.findNavController(getParentFragment()).navigate(R.id.action_t003_stimuliFrag_to_optionsFrag, bundle);
                Navigation.findNavController(view).navigate(R.id.action_t003_stimuliFrag_to_optionsFrag, bundle);
            }
        }, ViewModel_t003.intervalPreStimuli + ViewModel_t003.stimuliDuration);
    }
}
