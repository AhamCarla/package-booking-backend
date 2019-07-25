package com.oocl.fs.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PackageUtils {

    private static String TIME = "";

    private static Integer ORDER_COUNT = 0;

    public static String getPackageNumber() {
        Date date = Calendar.getInstance().getTime();
        String timestamp = String.valueOf(date.getTime()).substring(9);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateString = sdf.format(date);
        if (TIME.equals(dateString)) {
            ORDER_COUNT++;
            return timestamp + dateString + ORDER_COUNT;
        } else {
            ORDER_COUNT = 0;
            TIME = sdf.format(date);
            ORDER_COUNT++;
            return timestamp + dateString + ORDER_COUNT;
        }
    }

}
