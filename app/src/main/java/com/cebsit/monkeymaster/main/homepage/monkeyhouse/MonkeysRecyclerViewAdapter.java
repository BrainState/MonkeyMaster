package com.cebsit.monkeymaster.main.homepage.monkeyhouse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cebsit.monkeymaster.R;
import com.cebsit.monkeymaster.backend.UtilsSystem;
import com.cebsit.monkeymaster.database.Monkey;
import com.cebsit.monkeymaster.main.MainViewModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonkeysRecyclerViewAdapter extends RecyclerView.Adapter<MonkeysRecyclerViewAdapter.ViewHolder> {

    private MainViewModel mainViewModel;

    private List<Monkey> myMonkeyList = new ArrayList<>();

    public MonkeysRecyclerViewAdapter(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;
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
        final Monkey selectedMonkey = myMonkeyList.get(position);

        holder.tv_num.setText(String.valueOf(myMonkeyList.size() - position));
        holder.tv_name.setText(selectedMonkey.getMonkeyName());
        holder.tv_gender.setText(selectedMonkey.getGender());
        holder.tv_weight.setText(String.format("%s kg", selectedMonkey.getWeight()));
        holder.tv_birthday.setText(selectedMonkey.getBirthmonth().toString());
        holder.tv_age.setText(getText_age(selectedMonkey));
        holder.tb_details.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    holder.cl_details.setVisibility(View.VISIBLE);
                } else {
                    holder.cl_details.setVisibility(View.GONE);
                }
            }
        });

        holder.ib_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainViewModel.deleteMonkeys(selectedMonkey);
            }
        });
    }

    private String getText_age(Monkey monkey) {
        int year = monkey.getBirthmonth().getYear();
        int month = monkey.getBirthmonth().getMonth();

        Date date = new Date();
        int age = UtilsSystem.timeIntConverter("yyyy") - year;
        String dateUnit = "-year-old";

        if (age == 0) {
            age = UtilsSystem.timeIntConverter("MM") - month;
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
        private ViewGroup cl_details;
        private TextView tv_gender;
        private TextView tv_weight;
        private TextView tv_birthday;
        private TextView tv_age;
        private ToggleButton tb_details;
        private ImageButton ib_edit;
        private ImageButton ib_record;
        private ImageButton ib_delete;

        private ViewHolder(@NonNull View view) {
            super(view);
            tv_num = view.findViewById(R.id.tv_monkey_num);
            tv_name = view.findViewById(R.id.tv_monkey_name);
            cl_details = view.findViewById(R.id.cl_monkey_details);
            tv_gender = view.findViewById(R.id.tv_monkey_gender);
            tv_weight = view.findViewById(R.id.tv_monkey_weight);
            tv_birthday = view.findViewById(R.id.tv_monkey_birthday);
            tv_age = view.findViewById(R.id.tv_monkey_age);
            tb_details = view.findViewById(R.id.tb_monkey_details);
            ib_edit = view.findViewById(R.id.ib_monkey_edit);
            ib_record = view.findViewById(R.id.ib_monkey_record);
            ib_delete = view.findViewById(R.id.ib_monkey_delete);
        }
    }
}
