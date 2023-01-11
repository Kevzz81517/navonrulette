package com.navonmesh.navonrulette.configuration;

import com.navonmesh.navonrulette.exception.ApplicationException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormattingUtility {

    public static String process(String originalDate, String originalFormat, String targetFormat) {

        try {
            DateFormat originalDateFormat = new SimpleDateFormat(originalFormat);
            DateFormat targetDateFormat = new SimpleDateFormat(targetFormat);
            Date date = originalDateFormat.parse(originalDate);
            return targetDateFormat.format(date);
        } catch (Exception ex) {
            throw new ApplicationException("Invalid date format");
        }
    }

    public static String process(Calendar originalDate, String targetFormat) {

        try {
            DateFormat targetDateFormat = new SimpleDateFormat(targetFormat);
            return targetDateFormat.format(originalDate.getTime());
        } catch (Exception ex) {
            throw new ApplicationException("Invalid date format");
        }
    }

    public static String process(Date originalDate, String targetFormat) {

        try {
            DateFormat targetDateFormat = new SimpleDateFormat(targetFormat);
            return targetDateFormat.format(originalDate);
        } catch (Exception ex) {
            throw new ApplicationException("Invalid date format");
        }
    }

    public static Calendar revProcess(String originalDate, String originalFormat) {

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(originalFormat);

            Calendar calendar = Calendar.getInstance();

            calendar.setTime(simpleDateFormat.parse(originalDate));

            return calendar;
        } catch (Exception ex) {
            throw new ApplicationException("Invalid date format");
        }
    }
}
