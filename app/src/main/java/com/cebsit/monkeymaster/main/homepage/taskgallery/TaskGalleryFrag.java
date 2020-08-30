package com.cebsit.monkeymaster.main.homepage.taskgallery;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cebsit.monkeymaster.R;


public class TaskGalleryFrag extends Fragment {

    private RecyclerView rv_tasks;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.frag_task_gallery, container, false);

        Context context = root.getContext();

        getActivity().findViewById(R.id.fab_save).setVisibility(View.INVISIBLE);

        rv_tasks = root.findViewById(R.id.rv_tasks);
        layoutManager = new LinearLayoutManager(context);
        rv_tasks.setLayoutManager(layoutManager);

        mAdapter = new TasksRecyclerViewAdapter(TasksContent.taskList);
        rv_tasks.setAdapter(mAdapter);
        rv_tasks.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

        return root;
    }
}