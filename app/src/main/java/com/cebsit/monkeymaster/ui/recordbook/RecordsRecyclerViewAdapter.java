package com.cebsit.monkeymaster.ui.recordbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cebsit.monkeymaster.R;
import com.cebsit.monkeymaster.database.Record;

import java.util.ArrayList;
import java.util.List;


public class RecordsRecyclerViewAdapter extends RecyclerView.Adapter<RecordsRecyclerViewAdapter.ViewHolder> {

    private List<Record> myRecordList = new ArrayList<>();

    public RecordsRecyclerViewAdapter() {}

    public void inflateRecords(List<Record> recordList) {
        this.myRecordList = recordList;
    }

    @NonNull
    @Override
    public RecordsRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_record, parent, false);
        return new RecordsRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecordsRecyclerViewAdapter.ViewHolder holder, int position) {
        Record record = myRecordList.get(position);

        holder.tv_num.setText(String.valueOf(position));
        holder.tv_task.setText(record.taskName);
        //TODO
//        holder.tv_monkey.setText(record);
        holder.tv_notes.setText(record.notes);
        holder.tv_creatingTime.setText(record.creatingTime);
    }

    @Override
    public int getItemCount() {
        return myRecordList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_num;
        private TextView tv_task;
        private TextView tv_monkey;
        private TextView tv_notes;
        private TextView tv_creatingTime;

        private ViewHolder(View view) {
            super(view);
            tv_num = view.findViewById(R.id.tv_record_num);
            tv_task = view.findViewById(R.id.tv_record_task);
            tv_monkey = view.findViewById(R.id.tv_record_monkey);
            tv_notes = view.findViewById(R.id.tv_record_notes);
            tv_creatingTime = view.findViewById(R.id.tv_record_creatingTime);
        }
    }
}