package com.cebsit.monkeymaster.backend;

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsSystem {
    public static int timeIntConverter(String pattern){
        Time time = new Time(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return Integer.parseInt(sdf.format(time));
    }

    public static Point getScreenCentre(Activity activity) {
        Point screen_size = getScreenSize(activity);
        return new Point(screen_size.x/2, screen_size.y/2);
    }

    public static Point getScreenSize(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point screen_size = new Point();
        display.getSize(screen_size);
        return new Point(screen_size.x, screen_size.y);
    }
}
