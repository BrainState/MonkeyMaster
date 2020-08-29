package com.cebsit.monkeymaster.ui.taskgallery;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cebsit.monkeymaster.R;

import java.util.List;

public class TasksRecyclerViewAdapter extends RecyclerView.Adapter<TasksRecyclerViewAdapter.ViewHolder> {

    private List<Task> taskList;
    public TasksRecyclerViewAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public TasksRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_task, parent, false);
        return new TasksRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TasksRecyclerViewAdapter.ViewHolder holder, final int position) {
        Task task = taskList.get(position);

        holder.tv_id.setText(task.taskId);
        holder.tv_name.setText(task.taskName);
        holder.tv_intro.setText(task.intro);
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View mView;
        private TextView tv_id;
        private TextView tv_name;
        private TextView tv_intro;

        private ViewHolder(View view) {
            super(view);
            mView = view;
            tv_id = view.findViewById(R.id.tv_task_id);
            tv_name = view.findViewById(R.id.tv_task_name);
            tv_intro = view.findViewById(R.id.tv_task_intro);
        }
    }
}
