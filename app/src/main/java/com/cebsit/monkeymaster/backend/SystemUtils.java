package com.cebsit.monkeymaster.backend;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.view.Display;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemUtils {
    public static int timeIntConverter(String pattern){
        Time time = new Time(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return Integer.parseInt(sdf.format(time));
    }

    public static String timeConverter(long timeStamp){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
        return sdf.format(new Time(timeStamp));
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

    public static int getPossionVariable(double lamda) {
        int x = 0;
        double y = Math.random(), cdf = getPossionProbability(x, lamda);
        while (cdf < y) {
            x++;
            cdf += getPossionProbability(x, lamda);
        }
        return x;
    }

    public static double getPossionProbability(int k, double lamda) {
        double c = Math.exp(-lamda), sum = 1;
        for (int i = 1; i <= k; i++) {
            sum *= lamda / i;
        }
        return sum * c;
    }

    public static int getColor(Application application, SharedPreferences sp, String prefsKey, String defaultValue) {
        return application.getResources().getIdentifier(sp.getString(prefsKey, defaultValue), "color", application.getPackageName());
    }
}
