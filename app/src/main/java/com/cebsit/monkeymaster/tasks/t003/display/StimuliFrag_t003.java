package com.cebsit.monkeymaster.tasks.t003.display;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.cebsit.monkeymaster.R;
import com.cebsit.monkeymaster.backend.UtilsSystem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class StimuliFrag_t003 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_main_tasks_shared_empty, container, false);
//        Point centre = UtilsSystem.getScreenCentre(getActivity());
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

        Handler step1 = new Handler();
        step1.postDelayed(new Runnable() {
            @Override
            public void run() {
                Point centre = UtilsSystem.getScreenCentre(getActivity());
                Button[] choices = new Button[8];
                ConstraintLayout container_square = view.findViewById(R.id.container_empty);
                for (int i=0;i<choices.length;i++) {
                    choices[i] = new Button(getContext());
                    GradientDrawable drawable = new GradientDrawable();
                    drawable.setShape(GradientDrawable.OVAL);
                    drawable.setColor(ContextCompat.getColor(getContext(), R.color.design_default_color_error));
//                    drawable.setStroke(5, ContextCompat.getColor(getContext(), R.color.black_overlay));
                    choices[i].setBackground(drawable);
                    choices[i].setHeight(200);
                    choices[i].setWidth(200);
                    choices[i].setX((float) (centre.x + centre.x*7/10*Math.cos(2*3.14*i/choices.length) - 200/2.0));
                    choices[i].setY((float) (centre.y + centre.x*7/10*Math.sin(2*3.14*i/choices.length) - 200/2.0));
                    container_square.addView(choices[i]);
                }

                Random r = new Random();
                int stimuleIndex = r.nextInt(8);
                GradientDrawable drawable = new GradientDrawable();
                drawable.setShape(GradientDrawable.OVAL);
                drawable.setColor(getResources().getColor(R.color.colorAccent));
                choices[stimuleIndex].setBackground(drawable);
            }
        }, 3000);

        Handler step2 = new Handler();
        step2.postDelayed(new Runnable() {
            @Override
            public void run() {
                Navigation.findNavController(view).navigate(R.id.action_t003_stimuliFrag_to_optionsFrag);
            }
        }, 6000);
    }
}
