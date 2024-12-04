package edu.ntnu.idi.idatt.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }
}