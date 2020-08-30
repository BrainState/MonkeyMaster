package com.cebsit.monkeymaster.backend;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsSystem {
    public static int getYear(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        int year = Integer.parseInt(sdf.format(date));
        return year;
    }

    public static int getMonth(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        int month = Integer.parseInt(sdf.format(date));
        return month;
    }
}
