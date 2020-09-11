//package com.cebsit.monkeymaster.tasks.t003.display;
//
//import android.os.Bundle;
//import android.os.Handler;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.navigation.Navigation;
//
//import com.cebsit.monkeymaster.R;
//
//public class DisplayFrag_t003_1 extends Fragment {
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.frag_main_tasks_shared_empty, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Navigation.findNavController(view).navigate(R.id.action_displayFrag_t003_1_to_displayFrag_t003_2);
//            }
//        }, 3000);
//    }
//}
