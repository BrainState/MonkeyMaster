package com.cebsit.monkeymaster.ui.monkeyhouse;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cebsit.monkeymaster.R;
import com.cebsit.monkeymaster.database.Monkey;

import java.util.List;

public class MonkeyHouseFrag extends Fragment {

    private RecyclerView rv_monkeys;
    private MonkeyHouseViewModel monkeyHouseViewModel;
    private MonkeysRecyclerViewAdapter monkeysRecyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.frag_monkey_house, container, false);
        final Context context = root.getContext();

        rv_monkeys = root.findViewById(R.id.rv_monkeys);
        layoutManager = new LinearLayoutManager(context);
        rv_monkeys.setLayoutManager(layoutManager);

        monkeysRecyclerViewAdapter = new MonkeysRecyclerViewAdapter();
        rv_monkeys.setAdapter(monkeysRecyclerViewAdapter);
        rv_monkeys.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

        monkeyHouseViewModel = new ViewModelProvider(this).get(MonkeyHouseViewModel.class);
        monkeyHouseViewModel.getAllMonkeysLive().observe(getViewLifecycleOwner(), new Observer<List<Monkey>>() {
            @Override
            public void onChanged(List<Monkey> monkeys) {
                monkeysRecyclerViewAdapter.inflateMonkeys(monkeys);
                monkeysRecyclerViewAdapter.notifyDataSetChanged();
            }
        });

//        root.findViewById(R.id.fab_add_monkey).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_monkeyHouseNav_to_newMonkeyNav));

        return root;
    }


}