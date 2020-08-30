package com.cebsit.monkeymaster.main.homepage.recordbook;

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
import com.cebsit.monkeymaster.database.Record;
import com.cebsit.monkeymaster.main.MainViewModel;

import java.util.List;


public class RecordBookFrag extends Fragment {

    private RecyclerView rv_records;
    private MainViewModel mainViewModel;
    private RecordsRecyclerViewAdapter recordsRecyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.frag_record_book, container, false);
        Context context = root.getContext();

        getActivity().findViewById(R.id.fab_save).setVisibility(View.INVISIBLE);

        rv_records = root.findViewById(R.id.rv_records);
        layoutManager = new LinearLayoutManager(context);
        rv_records.setLayoutManager(layoutManager);

        recordsRecyclerViewAdapter = new RecordsRecyclerViewAdapter();
        rv_records.setAdapter(recordsRecyclerViewAdapter);
        rv_records.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getAllRecordsLive().observe(getViewLifecycleOwner(), new Observer<List<Record>>() {
            @Override
            public void onChanged(List<Record> records) {
                recordsRecyclerViewAdapter.inflateRecords(records);
                recordsRecyclerViewAdapter.notifyDataSetChanged();
            }
        });
        return root;
    }


}