
package com.zhihuisystem.pds.utils;


import com.zhihuisystem.pds.exception.PDSServiceException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {


    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String YMD_S = "yyyyMMdd";

    public static final String Y_M_D = "yyyy-MM-dd";

    public static final String Y_M_D_CN = "yyyy年MM月dd日";

    public static final String Y_M_D_H_CN = "yyyy年MM月dd日HH时";

    public static final String Y_M_CN = "yyyy年MM月";

    public static final String YMDHM = "yyyyMMddHHmm";

    public static final String YMDHMS = "yyyyMMddHHmmss";

    public static final String YMDHMSSS = "yyyyMMddHHmmssSSS";

    public static final String MS = "mmss";

    public static final String HMS = "HHmmss";

    public static final String YM = "yyyyMM";

    public static final String DD = "dd";

    public DateUtils() {
    }


    public static boolean isWeekend() {
        Date bdate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(bdate);
        return cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
    }


    /**
     * 获取N天的日期
     *
     * @param orgidate
     * @param nday
     * @return
     */
    public static String getOtherDay(Date orgidate, int nday) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        Calendar theCa = Calendar.getInstance();
        theCa.setTime(orgidate);
        theCa.add(Calendar.DATE, nday);
        Date date = theCa.getTime();
        return simpleDateFormat.format(date);
    }

    /**
     * <p>
     * 获取当前日期YMD字符串，格式为yyyyMMdd(通用的workdate生成方式)
     * </p>
     *
     * @return SimpleDateFormat格式化为yyyyMMdd的字符串
     */
    public static String getCurrentDate() {
        final SimpleDateFormat YMD = new SimpleDateFormat(YMD_S);
        return YMD.format(new Date());
    }

    // yyyy-MM-dd
    public static String getCurrent_() {
        final SimpleDateFormat format = new SimpleDateFormat(Y_M_D);
        return format.format(new Date());
    }

    /**
     * 将日期格式化为yyyy-MM-dd格式
     *
     * @param date
     * @return
     */
    public static String getDateTimeY_M_D(final Date date) {
        final SimpleDateFormat format = new SimpleDateFormat(Y_M_D);
        return format.format(date);
    }

    /**
     * 将日期格式化为yyyy年MM月dd日格式
     *
     * @param date
     * @return
     */
    public static String getDateTimeYMDCN(Date date) {
        final SimpleDateFormat format = new SimpleDateFormat(Y_M_D_CN);
        return format.format(date);
    }

    /**
     * @param date
     * @return
     */
    public static String getDateTimeYMDHCN(Date date) {
        final SimpleDateFormat format = new SimpleDateFormat(Y_M_D_H_CN);
        return format.format(date);
    }


    /**
     * 将日期格式化为yyyy年MM月格式
     *
     * @param date
     * @return
     */
    public static String getDateTimeYMCN(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(Y_M_CN);
        return format.format(date);
    }

    /**
     * 将日期格式化为dd格式
     *
     * @param date
     * @return
     */
    public static String getDateTimeDD(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DD);
        return format.format(date);
    }

    /**
     * 将yyyyMMdd格式的整形日期格式化为yyyy年MM月dd日格式
     *
     * @param date
     * @return
     */
    public static String getDateTimeYMDCN(int date) {
        final SimpleDateFormat format = new SimpleDateFormat(Y_M_D_CN);
        if (date <= 0) {
            return "";
        }
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, date / 10000);
        c.set(Calendar.MONTH, ((date / 100) % 100 - 1));
        c.set(Calendar.DATE, (date % 100));

        return format.format(c.getTime());
    }

    /* yyyy-MM-dd HH:mm:ss */
    public static String getCurrentDateTime() {
        final SimpleDateFormat YMDHMS_FRONT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return YMDHMS_FRONT.format(new Date());
    }

    /* yyyy-MM-dd HH:mm:ss */
    public static String getCurrentYMDHMTime() {
        final SimpleDateFormat format = new SimpleDateFormat(YMDHM);
        return format.format(new Date());
    }

    /* yyyy-MM-dd HH:mm:ss */
    public static String getCurrentYMDHMSTime() {
        final SimpleDateFormat format = new SimpleDateFormat(YMDHMS);
        return format.format(new Date());
    }

    /* yyyyMMddHHmmssSSS */
    public synchronized static String getCurrentYMDHMSSSTime() {
        final SimpleDateFormat format = new SimpleDateFormat(YMDHMSSS);
        return format.format(new Date());
    }

    /**
     * <p>
     * 不精确判断是否为整点或者半点
     * </p>
     *
     * @return 判断是否为整点
     */
    public static boolean isHourUnAccourate() {
        final SimpleDateFormat format = new SimpleDateFormat(MS);
        boolean status = false;
        final int hourSeconds = Integer.parseInt(format.format(new Date()));
        if (hourSeconds >= 5955 || hourSeconds <= 5 || (hourSeconds <= 3005 && hourSeconds >= 2955)) {
            status = true;
        }
        return status;
    }

    /**
     * <p>
     * 获取当前日期YMD字符串，格式为yyyyMMdd(通用的workdate生成方式)
     * </p>
     *
     * @return SimpleDateFormat格式化为yyyyMMdd的字符串
     */
    public static String getYMDDate(final Date date) {
        final SimpleDateFormat YMD = new SimpleDateFormat(YMD_S);
        return YMD.format(date);
    }

    /**
     * <p>
     * 获取当前时间HMS字符串，格式为HHmmss(通用的workdate生成方式)
     * </p>
     *
     * @return SimpleDateFormat格式化为HHmmss的字符串
     */
    public static String getCurrentTime() {
        final SimpleDateFormat format = new SimpleDateFormat(HMS);
        return format.format(new Date());
    }

    /**
     * <p>
     * 转换当前日期
     * </p>
     *
     * @throws ParseException
     */
    public static Date parseDateYMDHM(final String ymd) throws ParseException {
        final SimpleDateFormat format = new SimpleDateFormat(YMDHM);
        return format.parse(ymd);

    }


    /**
     * <p>
     * 转换当前日期
     * </p>
     *
     * @throws ParseException
     */
    public static Date parseDateY_M_D(final String ymd) throws ParseException {
        final SimpleDateFormat format = new SimpleDateFormat(Y_M_D);
        return format.parse(ymd);

    }

    /**
     * <p>
     * 获取对应的Date的格式yyyyMMddHHmmss
     * </p>
     *
     * @param date 传入的日期
     * @return SimpleDateFormat格式化为yyyyMMddHHmmss的字符串
     */
    public static String getDateTime(final Date date) {
        final SimpleDateFormat format = new SimpleDateFormat(YMDHMS);
        return format.format(date);
    }

    /**
     * <p>
     * 获取对应的Date的格式yyyyMM
     * </p>
     *
     * @param date 传入的日期
     * @return SimpleDateFormat格式化为yyyyMM的字符串
     */
    public static String parseDateYM(final Date date) {
        SimpleDateFormat format = new SimpleDateFormat(YM);
        return format.format(date);
    }

    /**
     * <p>
     * 获取对应的Date的格式yyyy-MM-dd HH:mm:ss
     * </p>
     *
     * @param date 传入的日期String
     * @return SimpleDateFormat格式化为yyyy-MM-dd HH:mm:ss的Date
     * @throws ParseException
     */
    public static Date getDateTimeFront(final String date) throws ParseException {
        final SimpleDateFormat YMDHMS_FRONT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return YMDHMS_FRONT.parse(date);
    }

    /**
     * <p>
     * 用于计算下一天的时间
     * </p>
     *
     * @param orgCutDayTime 当前时间，精确到天级别
     * @return 第二天
     * @throws ParseException
     */
    public static String calculateNextDay(final String orgCutDayTime) throws ParseException {
        final SimpleDateFormat YMD = new SimpleDateFormat(YMD_S);
        final Date orgDate = YMD.parse(orgCutDayTime);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(orgDate);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        final Date currentDate = calendar.getTime();
        return YMD.format(currentDate);
    }


    /**
     * <p>
     * 用于计算前一天的时间
     * </p>
     *
     * @param orgTime 当前时间，精确到天级别
     * @return 前一天时间
     */
    public static String calculatePreDay(final String orgTime) throws ParseException {
        final SimpleDateFormat YMD = new SimpleDateFormat(YMD_S);
        final Date orgDate = YMD.parse(orgTime);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(orgDate);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        final Date currentDate = calendar.getTime();
        return YMD.format(currentDate);
    }

    /**
     * <p>
     * 用于计算前一天的时间
     * </p>
     *
     * @param orgTime
     * @param fomart
     * @return
     * @throws ParseException
     * @Title: calculatePreDay
     */
    public static String calculatePreDay(final String orgTime, String fomart) throws ParseException {
        final SimpleDateFormat YMD = new SimpleDateFormat(fomart);
        final Date orgDate = YMD.parse(orgTime);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(orgDate);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        final Date currentDate = calendar.getTime();
        return YMD.format(currentDate);
    }

    /**
     * <p>
     * 用于计算前2天的时间
     * </p>
     *
     * @param orgTime 当前时间，精确到天级别
     * @return 前一天时间
     * @throws ParseException
     */
    public static String calculatePreNDay(final String orgTime, int preNum) throws ParseException {
        final SimpleDateFormat YMD = new SimpleDateFormat(YMD_S);
        final Date orgDate = YMD.parse(orgTime);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(orgDate);
        calendar.add(Calendar.DAY_OF_MONTH, -preNum);
        final Date currentDate = calendar.getTime();
        return YMD.format(currentDate);
    }

    /**
     * <p>
     * 用于计算前3天的时间
     * </p>
     *
     * @param orgTime 当前时间，精确到天级别
     * @return 前一天时间
     * @throws ParseException
     */
    public static String calculatePre3Day(final String orgTime) throws ParseException {
        final SimpleDateFormat YMD = new SimpleDateFormat(YMD_S);
        final Date orgDate = YMD.parse(orgTime);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(orgDate);
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        final Date currentDate = calendar.getTime();
        return YMD.format(currentDate);
    }

    /**
     * <p>
     * 用于计算前4天的时间
     * </p>
     *
     * @param orgTime 当前时间，精确到天级别
     * @return 前一天时间
     * @throws ParseException
     */
    public static String calculatePre4Day(final String orgTime) throws ParseException {
        final SimpleDateFormat YMD = new SimpleDateFormat(YMD_S);
        final Date orgDate = YMD.parse(orgTime);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(orgDate);
        calendar.add(Calendar.DAY_OF_MONTH, -4);
        final Date currentDate = calendar.getTime();
        return YMD.format(currentDate);
    }

    /**
     * <p>
     * 用于计算前6天的时间
     * </p>
     *
     * @param orgTime 当前时间，精确到天级别
     * @return 前一天时间
     * @throws ParseException
     */
    public static String calculatePre6Day(final String orgTime) throws ParseException {
        final SimpleDateFormat YMD = new SimpleDateFormat(YMD_S);
        final Date orgDate = YMD.parse(orgTime);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(orgDate);
        calendar.add(Calendar.DAY_OF_MONTH, -6);
        final Date currentDate = calendar.getTime();
        return YMD.format(currentDate);
    }

    /**
     * <p>
     * 用于计算前7天的时间
     * </p>
     *
     * @param orgTime 当前时间，精确到天级别
     * @return 前一天时间
     * @throws ParseException
     */
    public static String calculatePre7Day(final String orgTime) throws ParseException {
        final SimpleDateFormat YMD = new SimpleDateFormat(YMD_S);
        final Date orgDate = YMD.parse(orgTime);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(orgDate);
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        final Date currentDate = calendar.getTime();
        return YMD.format(currentDate);
    }

    /**
     * <p>
     * 用于计算前7天的时间
     * </p>
     *
     * @param orgTime 当前时间，精确到天级别
     * @return 前一天时间
     * @throws ParseException
     */
    public static String calculatePre7WeekOfYear(final String orgTime) throws ParseException {
        final SimpleDateFormat YMD = new SimpleDateFormat(YMD_S);
        final Date orgDate = YMD.parse(orgTime);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(orgDate);
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        String week = calendar.get(Calendar.WEEK_OF_YEAR) + "";
        if (String.valueOf(week).length() <= 1) {
            week = "0" + week;
        }

        String mm = calendar.get(Calendar.MONTH) + "";
        if (!(String.valueOf(mm).length() > 1)) {
            mm = "0" + mm;
        }
        return calendar.get(Calendar.YEAR) + mm + week;
    }

    /**
     * <p>
     * 用于计算前14天的时间
     * </p>
     *
     * @param orgTime 当前时间，精确到天级别
     * @return 前一天时间
     * @throws ParseException
     */
    public static String calculatePre14Day(final String orgTime) throws ParseException {
        final SimpleDateFormat YMD = new SimpleDateFormat(YMD_S);
        final Date orgDate = YMD.parse(orgTime);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(orgDate);
        calendar.add(Calendar.DAY_OF_MONTH, -14);
        final Date currentDate = calendar.getTime();
        return YMD.format(currentDate);
    }

    public static String lastMonFirstDay() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        String months = "";
        if (month > 1) {
            month--;
        } else {
            year--;
            month = 12;
        }
        if (String.valueOf(month).length() <= 1) {
            months = "0" + month;
        } else {
            months = String.valueOf(month);
        }
        return year + months + "01";
    }

    public static String lastMonFirstDayYM() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        String months = "";
        if (month > 1) {
            month--;
        } else {
            year--;
            month = 12;
        }
        if (String.valueOf(month).length() <= 1) {
            months = "0" + month;
        } else {
            months = String.valueOf(month);
        }
        return year + months;
    }

    public static String lastweeksunday() {
        final SimpleDateFormat YMD = new SimpleDateFormat(YMD_S);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return YMD.format(cal.getTime());
    }

    public static String lastMonLastDay() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String months = "";
        String days = "";
        if (month > 1) {
            month--;
        } else {
            year--;
            month = 12;
        }
        if (String.valueOf(month).length() <= 1) {
            months = "0" + month;
        } else {
            months = String.valueOf(month);
        }
        if (String.valueOf(day).length() <= 1) {
            days = "0" + day;
        } else {
            days = String.valueOf(day);
        }
        return year + months + days;
    }

    public static String getLastQuarterFirstDay() {
        // 取得日历
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);// 上上季度的年份
        int mouth = calendar.get(Calendar.MONTH) + 1;// 上上季度的月份
        String mm = "";// 月/日
        // 根据月份,判断是哪个季度
        switch (mouth) {
            case 1:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -3);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            case 2:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -4);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;

            case 3:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -5);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;

            case 4:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -3);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            case 5:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -4);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            case 6:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -5);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            case 7:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -3);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            case 8:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -4);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            case 9:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -5);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            case 10:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -3);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            case 11:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -4);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            case 12:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -5);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            default:
        }
        String lastDate = String.valueOf(year) + "" + mm + "01";
        return lastDate;
    }

    public static String getLastQuarterLastDay() {
        // 取得日历
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);// 上上季度的年份
        int mouth = calendar.get(Calendar.MONTH) + 1;// 上上季度的月份
        String mm = "";// 月/日
        // 根据月份,判断是哪个季度
        switch (mouth) {
            case 1:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -1);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            case 2:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -2);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;

            case 3:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -3);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;

            case 4:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -1);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            case 5:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -2);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            case 6:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -3);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            case 7:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -1);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            case 8:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -2);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            case 9:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -3);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            case 10:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -1);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            case 11:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -2);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            case 12:
                calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -3);
                mouth = calendar.get(Calendar.MONTH) + 1;
                if (!(String.valueOf(mouth).length() > 1)) {
                    mm = "0" + mouth;
                } else {
                    mm = mouth + "";
                }
                year = calendar.get(Calendar.YEAR);
                break;
            default:
        }

        calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1);

        return String.valueOf(year) + "" + mm + calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static String getQuarter(Date date) {
        // 取得日历
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);// 上上季度的年份
        int mouth = calendar.get(Calendar.MONTH) + 1;// 上上季度的月份
        String quarter = "";// 月/日
        // 根据月份,判断是哪个季度
        switch (mouth) {
            case 1:
                quarter = "01";
                break;
            case 2:
                quarter = "01";
                break;

            case 3:
                quarter = "01";
                break;

            case 4:
                quarter = "02";
                break;
            case 5:
                quarter = "02";
                break;
            case 6:
                quarter = "02";
                break;
            case 7:
                quarter = "03";
                break;
            case 8:
                quarter = "03";
                break;
            case 9:
                quarter = "03";
                break;
            case 10:
                quarter = "04";
                break;
            case 11:
                quarter = "04";
                break;
            case 12:
                quarter = "04";
                break;
            default:
        }
        return year + quarter;
    }

    /**
     * <p>
     * 将日期字符串转化成日期类型
     * </p>
     *
     * @return
     */
    public static Date parseDate(String dateStr, String parterm) throws PDSServiceException, ParseException {
        Date date = null;
        if (dateStr == null) {
            date = null;
        } else {
            DateFormat df = new SimpleDateFormat(parterm);
            try {
                date = df.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
                throw e;
            }
        }
        return date;
    }

    /**
     * @param date
     * @return
     */
    public static String parseString(Date date, String parterm) {
        final SimpleDateFormat YMDHMS_FRONT = new SimpleDateFormat(parterm);
        return YMDHMS_FRONT.format(date);
    }

    /**
     * 将日期和时间转换为时间 （需按以下示例中的格式传入参数）
     *
     * @param date 例：20141120
     * @param time 例：183030
     * @return 例：2014-11-20 18:30:30
     */
    public static String getFormatDateTime(String date, String time) {
        final SimpleDateFormat YMDHMS_FRONT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        String dateFormat = null;
        if (date != null && date.length() == 8) {
            Calendar calendar = Calendar.getInstance();
            String year = date.substring(0, 4);
            String month = date.substring(4, 6);
            String day = date.substring(6, 8);
            calendar.set(Calendar.YEAR, Integer.parseInt(year));
            calendar.set(Calendar.MONTH, Integer.parseInt(month) - 1);
            calendar.set(Calendar.DATE, Integer.parseInt(day));
            if (time != null && time.length() == 6) {
                String hour = time.substring(0, 2);
                String minute = time.substring(2, 4);
                String second = time.substring(4, 6);
                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
                calendar.set(Calendar.MINUTE, Integer.parseInt(minute));
                calendar.set(Calendar.SECOND, Integer.parseInt(second));
            }
            dateFormat = YMDHMS_FRONT.format(calendar.getTime());
        }
        return dateFormat;
    }

    /**
     * 获取格式化时间yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String getFormatTime(Date date) {
        final SimpleDateFormat YMDHMS_FRONT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return YMDHMS_FRONT.format(date);
    }

    /**
     * 将"yyyyMMdd格式的日期转换为yyyy-MM-dd的格式
     *
     * @param charDate
     * @return
     */
    public static String formatCharDateToComonDateStr(String charDate) {
        if (charDate == null || charDate.length() < 8) {
            return null;
        }
        String sb = new StringBuilder(10).append(charDate.substring(0, 4)).append("-")
                .append(charDate.subSequence(4, 6)).append("-").append(charDate.subSequence(6, 8)).toString();
        return sb;
    }

    /**
     * 将"yyyy-MM-dd格式的日期转换为yyyyMMdd的格式
     *
     * @param commonDate
     * @return
     */
    public static String formatCommonDateStrToCharDate(String commonDate) {
        if (commonDate == null || commonDate.length() != 10) {
            return null;
        }
        String str = new StringBuilder(8).append(commonDate.substring(0, 4)).append(commonDate.substring(5, 7))
                .append(commonDate.substring(8, 10)).toString();
        return str;
    }

    /**
     * 获取格式化时间HHmmss 零点加减areaTime分钟数后的时间
     *
     * @param areaTime
     * @return
     */
    public static String getZeroTimeHHMMSS(int areaTime) {
        final SimpleDateFormat HMS = new SimpleDateFormat("HHmmss");
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.HOUR_OF_DAY, 00);
        ca.set(Calendar.MINUTE, 00 + areaTime);
        ca.set(Calendar.SECOND, 00);
        return HMS.format(ca.getTime());
    }

    /**
     * <p>
     * 相对于制定时间偏移后的时间
     * </p>
     *
     * @param date   基础时间
     * @param offset 偏移量（单位：分钟）
     * @return 偏移后的时间
     */
    public static Date getDateMinuteOffset(Date date, int offset) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, offset);
        return cal.getTime();
    }

    /**
     * 获取当前格式化日期yyyyMMdd
     *
     * @return
     */
    public static String getCurrentYYYYMMdd() {
        final SimpleDateFormat YMD = new SimpleDateFormat(YMD_S);
        return YMD.format(new Date());
    }

    /**
     * 获取当前格式化时间HHmmss
     *
     * @return
     */
    public static String getCurrentHHMMSS() {
        final SimpleDateFormat HMS = new SimpleDateFormat("HHmmss");
        return HMS.format(new Date());
    }

    /**
     * 返回两天前的日期
     *
     * @return
     */
    public static String getBeforeYesterday() {
        final Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DAY_OF_MONTH, -2);
        return getDateTimeY_M_D(ca.getTime());
    }

    /**
     * 返回格式为yyyyMMdd格式的整形日期
     *
     * @param date
     * @return
     */
    public static int getIntDate(Date date) {
        final SimpleDateFormat YMD = new SimpleDateFormat(YMD_S);
        if (date == null) {
            return 0;
        }
        String strDate = YMD.format(date);
        return Integer.getInteger(strDate);
    }

    /**
     * 返回当前日期的yyyyMMdd格式的整形
     *
     * @return
     */
    public static int getIntDate() {
        return getIntDate(new Date());
    }

    /**
     * 返回当前日期前后几天的yyyyMMdd格式的整形
     *
     * @return
     */
    public static int getIntDateBeforeOrAfter(int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, amount);
        return getIntDate(calendar.getTime());
    }


    /**
     * 设置为日期月份中的第一天
     * <p>
     * TODO
     * </p>
     *
     * @param dateStr
     * @param parterm
     * @return
     */
    public static Date getFormatMonthFirstDay(String dateStr, String parterm) throws PDSServiceException, ParseException {
        Date date = DateUtils.parseDate(dateStr, parterm);
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 设置为当前月份的第一天
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * <p>
     * 当前日期增加月份
     * </p>
     *
     * @param date
     * @param offset
     * @return
     */
    public static Date addMonth(Date date, int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, offset);
        return calendar.getTime();
    }

    /**
     * 根据格式化日期输出
     * <p>
     * TODO
     * </p>
     *
     * @param date
     * @param parterm
     * @return
     */
    public static String formatDate(Date date, String parterm) {
        SimpleDateFormat p = new SimpleDateFormat(parterm);
        return p.format(date);
    }

    /**
     * 返回指定日期的指定域
     *
     * @param field
     * @param date
     * @return
     * @see Calendar#get(int)
     */
    public static int getSpecifiedField(int field, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(field);
    }

    /**
     * 同Calendar的add方法
     *
     * @param date
     * @param field
     * @param offset
     * @return
     */
    public static Date add(Date date, int field, int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, offset);
        return calendar.getTime();
    }

    public static String getNextDate(String date) throws PDSServiceException, ParseException {
        final SimpleDateFormat YMD = new SimpleDateFormat(YMD_S);
        return YMD.format(add(parseDate(date, YMD_S), Calendar.DATE, 1));
    }

    public static String getNextDate(String date, String pattern) {
        SimpleDateFormat pf = new SimpleDateFormat(pattern);
        try {
            return pf.format(add(pf.parse(date), Calendar.DATE, 1));
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date getDateYMD(Date src, int offset) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(src);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.add(Calendar.DAY_OF_MONTH, offset);
        return calendar.getTime();
    }

    public static Date getBeginDate(Date date) throws ParseException {
        // 获取当天0点0分 0秒
        final SimpleDateFormat df = new SimpleDateFormat(YMD_S);
        return df.parse(df.format(date));
    }

    /**
     * 将指定时间加上指定月数
     *
     * @param date  计算前时间
     * @param month 月数,传正数为加天数,传负数则减
     * @return
     */
    public static Date dateAddOrMinusMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + month);
        return calendar.getTime();
    }

    /**
     * 比较两个日期
     *
     * @param DATE1
     * @param DATE2
     * @return 1-DATE1>DATE2 -1-DATE1<DATE2 0-DATE1=DATE2
     */
    public static int compareDate(Date DATE1, Date DATE2) {
        try {
            return Long.compare(DATE1.getTime(), DATE2.getTime());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 获得参数所在周的开始一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDateOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(date);

        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        // 所在周开始日期
        cal.add(Calendar.DAY_OF_WEEK, d);
        return cal.getTime();
    }

    public static Date getLastDateOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(date);

        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        // 所在周开始日期
        cal.add(Calendar.DAY_OF_WEEK, d);
        // 所在周结束日期
        cal.add(Calendar.DAY_OF_WEEK, 6);

        return cal.getTime();

    }

    // 获取当月最后一天
    public static Date getLastDateOfMonth() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        return ca.getTime();
    }

    public static boolean checkWeekend(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
    }

    public static int calculationThatDayRemainingTime() {
        final Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        double seconds = (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000f;
        return (int) seconds;
    }

}
