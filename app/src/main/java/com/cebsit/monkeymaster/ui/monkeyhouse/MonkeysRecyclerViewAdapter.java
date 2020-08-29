package com.cebsit.monkeymaster.ui.monkeyhouse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cebsit.monkeymaster.R;
import com.cebsit.monkeymaster.database.Monkey;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MonkeysRecyclerViewAdapter extends RecyclerView.Adapter<MonkeysRecyclerViewAdapter.ViewHolder> {

    private List<Monkey> myMonkeyList = new ArrayList<>();

    public MonkeysRecyclerViewAdapter() {
    }

    public void inflateMonkeys(List<Monkey> monkeyList) {
        this.myMonkeyList = monkeyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_monkey, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Monkey monkey = myMonkeyList.get(position);

        holder.tv_num.setText(String.valueOf(myMonkeyList.size() - position));
        holder.tv_name.setText(monkey.monkeyName);
        holder.tv_gender.setText(monkey.gender);
        holder.tv_weight.setText(String.format("%s kg", monkey.weight));
        holder.tv_birthday.setText(monkey.birthmonth.toString());
        holder.tv_age.setText(getText_age(monkey));
    }

    private String getText_age(Monkey monkey) {
        int year = monkey.birthmonth.year;
        int month = monkey.birthmonth.month;

        int age = new Date(System.currentTimeMillis()).getYear() - year;
        String dateUnit = "-year-old";

        if (age == 0) {
            age = new Date(System.currentTimeMillis()).getMonth() - month;
            dateUnit = "-month-old";
        }

        if (age == 0) {
            return "< 1-month-old";
        }
        return "" + age + dateUnit;
    }

    @Override
    public int getItemCount() {
        return myMonkeyList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_num;
        private TextView tv_name;
        private TextView tv_gender;
        private TextView tv_weight;
        private TextView tv_birthday;
        private TextView tv_age;

        private ViewHolder(@NonNull View view) {
            super(view);
            tv_num = view.findViewById(R.id.tv_monkey_num);
            tv_name = view.findViewById(R.id.tv_monkey_name);
            tv_gender = view.findViewById(R.id.tv_monkey_gender);
            tv_weight = view.findViewById(R.id.tv_monkey_weight);
            tv_birthday = view.findViewById(R.id.tv_monkey_birthday);
            tv_age = view.findViewById(R.id.tv_monkey_age);
        }
    }
}
