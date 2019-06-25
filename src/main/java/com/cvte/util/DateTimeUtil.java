package com.cvte.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author linxiaoyi
 * @date 2019/4/23
 */
public class DateTimeUtil {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date getDateTimeAfterSeconds(int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.SECOND, seconds);
        return calendar.getTime();
    }

    public static Date getDateTimeFromString(String dateString) {
        Date date = null;
        try {
            date = DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getNextZeroTimeFromString(String dateString) {
        return getNextZeroTime(getDateTimeFromString(dateString));
    }

    public static String getDate(Date date) {
        return DATE_FORMAT.format(date);
    }

    private static Date getNextZeroTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

}
