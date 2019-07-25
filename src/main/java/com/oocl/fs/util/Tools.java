package com.oocl.fs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tools {

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


    public static boolean inRange(Date inputJudgeDate) throws ParseException {
        boolean flag = false;
        long longDate = System.currentTimeMillis();
        Date nowDate = new Date(longDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(nowDate);
        String subDate = format.substring(0, 10);
        String beginTime = subDate + " 09:00:00";
        String endTime = subDate + " 20:00:00";
        Date paseBeginTime = dateFormat.parse(beginTime);
        Date paseEndTime = dateFormat.parse(endTime);
        if (inputJudgeDate.after(paseBeginTime) && inputJudgeDate.before(paseEndTime)) {
            flag = true;
        }
        return flag;
    }

}
