package com.cebsit.monkeymaster.backend;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsSystem {
    public static int timeIntConverter(String pattern){
        Time time = new Time(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return Integer.parseInt(sdf.format(time));
    }
}
