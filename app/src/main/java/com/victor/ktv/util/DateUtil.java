package com.victor.ktv.util;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

/**
 * Created by Administrator on 2017/12/11.
 */

public class DateUtil {
    private static String TAG = "DateUtil";
    /**
     * 获取今天的日期
     * @return
     */
    public static String getRequestTime () {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String today = formatter.format(date);
        Log.e(TAG, "getDateOfToday-today = " + today);
        return today;
    }

    public static String getCurrentYear () {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String today = formatter.format(date);
        Log.e(TAG, "getDateOfToday-today = " + today);
        return today;
    }
    public static String getCurrentMonth () {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        String today = formatter.format(date);
        Log.e(TAG, "getDateOfToday-today = " + today);
        return today;
    }

    public static int getMonthDiff () {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String str1 = "2018-03";
        String str2 = getCurrentMonth();
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        try {
            bef.setTime(sdf.parse(str1));
            aft.setTime(sdf.parse(str2));
            int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
            int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
            return Math.abs(month + result);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static int getTimeDiff (String startTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String currentTime = getCurrentTime();
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        try {
            bef.setTime(sdf.parse(startTime));
            aft.setTime(sdf.parse(currentTime));
            int diff = (int) (aft.getTimeInMillis() - bef.getTimeInMillis());
            if (diff > 0) {
                System.out.println("getTimeDiff----->" + diff);
                return diff;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String[] getChartTitle () {
        int count = getMonthDiff();
        String[] titles = new String[count];
        for (int i=0;i<count;i++) {
            titles[i] = getMontyByNum(i+3);
        }
        Log.e(TAG, "getChartTitle-titles.length= " + titles.length);
        return titles;
    }

    public static String getMontyByNum (int number) {
        String month = "";
        switch (number) {
            case 1:
                month = "JAN";
                break;
            case 2:
                month = "FEB";
                break;
            case 3:
                month = "MAR";
                break;
            case 4:
                month = "APR";
                break;
            case 5:
                month = "MAY";
                break;
            case 6:
                month = "JUN";
                break;
            case 7:
                month = "JUL";
                break;
            case 8:
                month = "AUG";
                break;
            case 9:
                month = "SEP";
                break;
            case 10:
                month = "OCT";
                break;
            case 11:
                month = "NOV";
                break;
            case 12:
                month = "DEC";
                break;
        }
        return month;

    }

    public static String getPlayTime () {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = formatter.format(date);
        return today;
    }

    /**
     * 将毫秒数格式化为"##:##"的时间
     *
     * @param milliseconds 毫秒数
     * @return ##:##
     */
    public static String formatPlayTime(long milliseconds) {
        long totalSeconds = milliseconds / 1000;
        long seconds = totalSeconds % 60;
        long minutes = (totalSeconds / 60) % 60;
        long hours = totalSeconds / 3600;
        StringBuilder stringBuilder = new StringBuilder();
        Formatter mFormatter = new Formatter(stringBuilder, Locale.getDefault());
        if (hours > 0) {
            return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
        } else {
            return mFormatter.format("%02d:%02d", minutes, seconds).toString();
        }
    }

    public static String formatBirthTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy-MM");
        return format.format(date);
    }

    /**
     * 根据年 月 获取对应的月份 天数
     * */
    public static int getDaysByYearMonth(int year, int month) {

        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 获取当前时间的年
     * @return
     */
    public static String getNowYear() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String today = formatter.format(date);
        return today;
    }

    /**
     * 返回的字符串形式是形如：07-31 12:08
     * */
    public static String formatTimeInMillis(long timeInMillis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeInMillis);
        Date date = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "MM-dd HH:mm");
        String fmt = dateFormat.format(date);

        return fmt;
    }

    /**
     * 返回的字符串形式是形如：03/17/1990
     * @param timeInMillis
     * @return
     */
    public static String formatDateInMillis(long timeInMillis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeInMillis);
        Date date = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "MM/dd/yyyy");
        String fmt = dateFormat.format(date);

        return fmt;
    }

    public static long formatTime2Ms (String date) {
        long ms = 0;
        SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
        Date dt = null;
        try {
            dt = sdf.parse(date);
            //继续转换得到毫秒数的long型
            ms = dt.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ms;
    }

    /**
     * 获取当前时间的小时
     * @return
     */
    public static int getCurrentHour24 () {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String getCurrentTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String currentTime = formatter.format(date);
        return currentTime;
    }


    /**
     * 获取今天的日期
     * @return
     */
    public static String getTodayDate () {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String today = formatter.format(date);
        return today;
    }

    public static void main(String[] args) {
        getTimeDiff("15:00:00");
//        getChartTitle();
    }
}
