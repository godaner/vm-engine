package com.vm.base.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具
 */
public class DateUtil {
    /**
     * 缺省的日期显示格式： yyyy-MM-dd
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyyMMdd";
    /**
     * 缺省的日期时间显示格式：yyyy-MM-dd HH:mm:ss
     */
    public static final String DEFAULT_DATETIME_FORMAT = "yyyyMMddHHmmss";

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYY_MM_DD_HH = "yyyy-MM-dd-HH";

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    private static long SevenDay = 604800;

    /**
     * 1s中的毫秒数
     */
    private static final int MILLIS = 1000;

    /**
     * 一年当中的月份数
     */
    private static final int MONTH_PER_YEAR = 12;

    private static final int MINIUTE = MILLIS * 60;

    private static final int HOUR = MINIUTE * 60;

    private static final int DAY = HOUR * 24;

    /**
     * 得到系统当前日期时间
     *
     * @return 当前日期时间
     */
    public static Date getNow() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 得到用缺省方式格式化的当前日期
     *
     * @return 当前日期
     */
    public static String getDate() {
        return getDateTime(DEFAULT_DATE_FORMAT);
    }

    public static String getCurrentDate() {
        return getDateTime(YYYY_MM_DD);
    }


    /**
     * 得到用缺省方式格式化的当前日期及时间
     *
     * @return 当前日期及时间
     */
    public static String getDateTime() {
        return getDateTime(DEFAULT_DATETIME_FORMAT);
    }

    /**
     * 得到系统当前日期及时间，并用指定的方式格式化
     *
     * @param pattern 显示格式
     * @return 当前日期及时间
     */
    public static String getDateTime(String pattern) {
        Date datetime = Calendar.getInstance().getTime();
        return getDateTime(datetime, pattern);
    }

    public static String getUnixDateTime(long unixTime) {
        return getDateTime(new Date(unixTime * 1000), YYYY_MM_DD_HH_MM_SS);
    }

    public static String getUnixDateHourTime(long unixTime) {
        return getDateTime(new Date(unixTime * 1000), YYYY_MM_DD_HH);
    }

    public static String getUnixDateOneHourAgoTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        //减去1天，得到的即本月的最后一天
        calendar.add(Calendar.HOUR, -1);
        Date oneHourAgo = calendar.getTime();
        return getUnixDateHourTime(toUnixTime(oneHourAgo));
    }


    public static String getUnixDateTime(long unixTime, String pattern) {
        return getDateTime(new Date(unixTime * 1000), pattern);
    }

    public static String getYesterday(long unixTime, String pattern) {
        Date date = new Date(unixTime * 1000);
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();
        return getDateTime(yesterday, pattern);
    }




    /**
     * 得到用指定方式格式化的日期
     *
     * @param date    需要进行格式化的日期
     * @param pattern 显示格式
     * @return 日期时间字符串
     */
    public static String getDateTime(Date date, String pattern) {
        if (null == pattern || "".equals(pattern)) {
            pattern = DEFAULT_DATETIME_FORMAT;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    /**
     * 得到当前年份
     *
     * @return 当前年份
     */
    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);

    }

    /**
     * 得到当前月份
     *
     * @return 当前月份
     */
    public static int getCurrentMonth() {
        //用get得到的月份数比实际的小1，需要加上
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    /**
     * 得到当前日
     *
     * @return 当前日
     */
    public static int getCurrentDay() {
        return Calendar.getInstance().get(Calendar.DATE);
    }

    /**
     * 取得当前日期以后若干天的日期。如果要得到以前的日期，参数用负数。 例如要得到上星期同一天的日期，参数则为-7
     *
     * @param days 增加的日期数
     * @return 增加以后的日期
     */
    public static Date addDays(int days) {
        return add(getNow(), days, Calendar.DATE);
    }

    /**
     * 取得指定日期以后若干天的日期。如果要得到以前的日期，参数用负数。
     *
     * @param date 基准日期
     * @return 增加以后的日期
     */
    public static Date addHours(Date date, int hours) {
        return add(date, hours, Calendar.HOUR);
    }

    /**
     * 取得指定日期以后若干天的日期。如果要得到以前的日期，参数用负数。
     *
     * @param date 基准日期
     * @param days 增加的日期数
     * @return 增加以后的日期
     */
    public static Date addDays(Date date, int days) {
        return add(date, days, Calendar.DATE);
    }

    /**
     * 取得当前日期以后某月的日期。如果要得到以前月份的日期，参数用负数。
     *
     * @param months 增加的月份数
     * @return 增加以后的日期
     */
    public static Date addMonths(int months) {
        return add(getNow(), months, Calendar.MONTH);
    }

    /**
     * 取得指定日期以后某月的日期。如果要得到以前月份的日期，参数用负数。
     * 注意，可能不是同一日子，例如2003-1-31加上一个月是2003-2-28
     *
     * @param date   基准日期
     * @param months 增加的月份数
     * @return 增加以后的日期
     */
    public static Date addMonths(Date date, int months) {
        return add(date, months, Calendar.MONTH);
    }

    /**
     * 内部方法。为指定日期增加相应的天数或月数
     *
     * @param date   基准日期
     * @param amount 增加的数量
     * @param field  增加的单位，年，月或者日
     * @return 增加以后的日期
     */
    private static Date add(Date date, int amount, int field) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        calendar.add(field, amount);

        return calendar.getTime();
    }

    /**
     * 通过date对象取得格式为小时:分钟的实符串
     *
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String getHourMin(Date date) {
        StringBuffer sf = new StringBuffer();
        sf.append(date.getHours());
        sf.append(":");
        sf.append(date.getMinutes());
        return sf.toString();
    }

    /**
     * 计算两个日期相差天数。 用第一个日期减去第二个。如果前一个日期小于后一个日期，则返回负数
     *
     * @param one 第一个日期数，作为基准
     * @param two 第二个日期数，作为比较
     * @return 两个日期相差天数
     */
    public static long diffDays(Date one, Date two) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(one);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY)
                , calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        Date d1 = calendar.getTime();
        calendar.clear();
        calendar.setTime(two);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY)
                , calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        Date d2 = calendar.getTime();
        final int MILISECONDS = 24 * 60 * 60 * 1000;
        BigDecimal r = new BigDecimal(new Double((d1.getTime() - d2.getTime()))
                / MILISECONDS);
        return Math.round(r.doubleValue());
    }

    /**
     * 计算两个日期相差月份数 如果前一个日期小于后一个日期，则返回负数
     *
     * @param one 第一个日期数，作为基准
     * @param two 第二个日期数，作为比较
     * @return 两个日期相差月份数
     */
    public static int diffMonths(Date one, Date two) {

        Calendar calendar = Calendar.getInstance();

        //得到第一个日期的年分和月份数
        calendar.setTime(one);
        int yearOne = calendar.get(Calendar.YEAR);
        int monthOne = calendar.get(Calendar.MONDAY);
        //得到第二个日期的年份和月份
        calendar.setTime(two);
        int yearTwo = calendar.get(Calendar.YEAR);
        int monthTwo = calendar.get(Calendar.MONDAY);

        return (yearOne - yearTwo) * MONTH_PER_YEAR + (monthOne - monthTwo);
    }

    /**
     * 获取某一个日期的年份
     *
     * @param d
     * @return
     */
    public static int getYear(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 将一个字符串用给定的格式转换为日期类型。 <br>
     * 注意：如果返回null，则表示解析失败
     *
     * @param datestr 需要解析的日期字符串
     * @param pattern 日期字符串的格式，默认为"yyyy-MM-dd"的形式
     * @return 解析后的日期
     */
    public static Date parse(String datestr, String pattern) {
        Date date = null;

        if (null == pattern || "".equals(pattern)) {
            pattern = DEFAULT_DATE_FORMAT;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            date = dateFormat.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static int getMonthOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.MONTH) + 1;

    }

    public static Date getMonthFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        //将日期设置为当月第一天
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);

        return calendar.getTime();
    }

    public static Date getNextMonthFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        //将日期设置为下月第一天
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        return calendar.getTime();
    }

    public static Date getLastMonthLastDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        //将日期设置为当月第一天
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        //减一获得上月最后一天
        calendar.add(Calendar.DATE, -1);

        return calendar.getTime();
    }

    /**
     * 返回本月的最后一天
     *
     * @return 本月最后一天的日期
     */
    public static Date getMonthLastDay() {
        return getMonthLastDay(getNow());
    }

    /**
     * 返回给定日期中的月份中的最后一天
     *
     * @param date 基准日期
     * @return 该月最后一天的日期
     */
    public static Date getMonthLastDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        //将日期设置为下一月第一天
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, 1);

        //减去1天，得到的即本月的最后一天
        calendar.add(Calendar.DATE, -1);

        return calendar.getTime();
    }

    /**
     * 计算两个具体日期之间的秒差，第一个日期-第二个日期
     *
     * @param date1
     * @param date2
     * @param onlyTime 是否只计算2个日期的时间差异，忽略日期，true代表只计算时间差
     * @return
     */
    public static long diffSeconds(Date date1, Date date2, boolean onlyTime) {
        if (onlyTime) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);
            //calendar.set(1984, 5, 24);
            long t1 = calendar.getTimeInMillis();
            calendar.setTime(date2);
            //calendar.set(1984, 5, 24);
            long t2 = calendar.getTimeInMillis();
            return (t1 - t2) / MILLIS;
        } else {
            return (date1.getTime() - date2.getTime()) / MILLIS;
        }
    }

    /**
     * @param date1
     * @param date2
     * @return
     */
    public static long diffSeconds(Date date1, Date date2) {
        return diffSeconds(date1, date2, false);
    }

    /**
     * 根据日期确定星期几:1-星期日，2-星期一.....s
     *
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        int mydate = cd.get(Calendar.DAY_OF_WEEK);
        return mydate;
    }

    /**
     * 验证用密码是否在有效期内(跟当前日期比较)
     *
     * @param format    "yyyyMMdd"
     * @param validDate
     * @return
     */
    public static boolean isValidDate(String validDate, String format) {
        Date valid = parse(validDate, format);
        Date now = new Date();
        String nowStr = new SimpleDateFormat(format).format(now);
        try {
            now = new SimpleDateFormat(format).parse(nowStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return valid.after(now);
    }

    public static Long getTodayStartUnixTime() {

        String todayBeginStr = DateUtil.getDate() + " 00:00:00";
        return DateUtil.toUnixTime(todayBeginStr, DateUtil.DEFAULT_DATE_FORMAT + " HH:mm:ss");
    }

    /**
     * 获取当前Unix时间(秒数)
     *
     * @return
     */
    public static Long unixTime() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 获取Unix时间(秒数)
     *
     * @param date
     * @return
     */
    public static Long toUnixTime(Date date) {
        return date == null ? null : date.getTime() / 1000;
    }

    public static Long toTimeStamp(Date date) {
        return date == null ? null : date.getTime();
    }

    public static Long toUnixTime(String dateStr, String pattern) {
        if (StringUtils.isEmpty(dateStr) || StringUtils.isEmpty(pattern)) {
            return null;
        }
        Date date = parse(dateStr, pattern);

        return date == null ? null : date.getTime() / 1000;

    }

    public static String formatUnixTime(String longStr, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(new Date(NumberUtils.toLong(longStr) * 1000));
    }

    public static String formatUnixTime(Long time, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(new Date(time * 1000));
    }

    public static Long parseUnixTime(String dateString, String pattern, Long defaultIfError) {
        if (StringUtils.isBlank(dateString)) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            return dateFormat.parse(dateString).getTime() / 1000;
        } catch (ParseException e) {
            return defaultIfError;
        }

    }

    public static String weekSunday(int week) {
        Calendar cal = Calendar.getInstance();
        String monday;
        cal.add(Calendar.DATE, week * 7);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        monday = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());

        return monday;
    }


    public static String weekSaturday(int week) {
        Calendar cal = Calendar.getInstance();
        String monday;
        cal.add(Calendar.DATE, week * 7);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        monday = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());

        return monday;
    }


    public static String weekMonday(int week) {

        Calendar cal = Calendar.getInstance();
        String monday;
        cal.add(Calendar.DATE, week * 7);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        monday = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());

        return monday;
    }

    public static String today() {
        String today = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        return today;
    }

    public static String yesterday() {

        Date yesterDay = new Date(new Date().getTime() - DAY);
        String time = new SimpleDateFormat("yyyyMMdd").format(yesterDay);
        return time;
    }

    public static String lastYear() {

        int year = Calendar.getInstance().get(Calendar.YEAR);
        return String.valueOf(year - 1);
    }

    public static String currentYear() {
        String month = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
        return month;
    }

    public static String lastDay() {
        Date yesterDay = new Date(new Date().getTime() - DAY);
        String time = new SimpleDateFormat(YYYY_MM_DD).format(yesterDay);
        return time;
    }

    static String currentMonth() {
        String month = new SimpleDateFormat("yyyy-MM").format(Calendar.getInstance().getTime());
        return month;
    }
    //20161231_20161225week

//    public static void main(String[] args) throws ParseException {
//        Random r = new Random();
//        r.nextInt(1);
//        System.out.println(DateUtil.getDateOfNextYear(getNow()));
//        int hour = 60;
//        int min = 60;
//        int day = 24;
//        int year = 365*day*hour*min;
//        int now = unixTime().intValue();//秒
//        System.out.println(DateUtil.getUnixDateTime(now,DateUtil.YYYY_MM_DD));
//        System.out.println(DateUtil.getYesterday(now,DateUtil.YYYY_MM_DD));
//        List<String> days = getLastYearEveryDayFromNow();
//        for (String day : days) {
//            System.out.println(day);
//        }

//        String a = getLastDay("2017-07-01",YYYY_MM_DD);
//        System.out.println(a);

//        Date beginDate = parse("2016-09-30", YYYY_MM_DD);
//        Date endDate = parse("2017-07-01", YYYY_MM_DD);
//        List<MonthlyBasis> monthList = getQuarterSplit(beginDate, endDate);
//        for (MonthlyBasis month : monthList) {
//            System.out.println("begin : " + month.getStartDate() + " end :" + month.getEndDate());
//        }
        /*String t = getUnixDateHourTime(1506009601);
        System.out.println(t);
        String date = getUnixDateTime(1506009601);
        System.out.println(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = dateFormat.parse(date);*/

//        Long t = DateUtil.parseUnixTime("2017-04-07 17:03:12",YYYY_MM_DD,null);

//        int now = DateUtil.unixTime().intValue();
//        String yesterDay = DateUtil.getYesterday(now,DateUtil.YYYY_MM_DD);
//        long yesterDayBeginTime = DateUtil.getDayBeginTime(yesterDay);
//        long yesterDayEndTime = DateUtil.getDayEndTime(yesterDay);
//
//        System.out.println(yesterDayBeginTime);
//        System.out.println(yesterDayEndTime);
//    }

    public static String getMonthLastDayByString(String yeaerMonth) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        try {
            Date date = dateFormat.parse(yeaerMonth);
            Date lastDay = getMonthLastDay(date);
            String time = new SimpleDateFormat("yyyyMMdd").format(lastDay);
            return time;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getDateOfLastYear() {
        Calendar calendar = Calendar.getInstance();
        String date = getDate();
        calendar.setTime(parse(date, DateUtil.DEFAULT_DATE_FORMAT));
        //将日期设置为去年今天
        calendar.add(Calendar.YEAR, -1);
        return calendar.getTime();
    }


    public static Date getDateOfLastYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        //将日期设置为去年今天

        calendar.add(Calendar.YEAR, -1);
        return calendar.getTime();
    }


    public static Date getDateOfNextYear() {
        Calendar calendar = Calendar.getInstance();
        String date = getDate();
        calendar.setTime(parse(date, DateUtil.DEFAULT_DATE_FORMAT));
        //将日期设置为去年今天
        calendar.add(Calendar.YEAR, 1);
        return calendar.getTime();
    }


    public static Date getDateOfNextYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        //将日期设置为去年今天

        calendar.add(Calendar.YEAR, 1);
        return calendar.getTime();
    }

    public static List<String> getMonthsBetween(Date date1, Date date2) {
        List<String> result = new ArrayList<String>();
        Calendar start = Calendar.getInstance();
        start.setTime(date1);
        Calendar end = Calendar.getInstance();
        end.setTime(date2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        while (start.before(end)) {
            result.add(sdf.format(start.getTime()));
            start.add(Calendar.MONTH, 1);
        }
        return result;

    }

    public static List<String> getDaysBetween(Date date1, Date date2, String pattern) {
        List<String> result = new ArrayList<String>();
        Calendar start = Calendar.getInstance();
        start.setTime(date1);
        Calendar end = Calendar.getInstance();
        end.setTime(date2);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        while (start.before(end)) {
            result.add(sdf.format(start.getTime()));
            start.add(Calendar.DATE, 1);
        }
        return result;

    }

    public static boolean areDatesTheSame(Date date1, Date date2) {
        return date1.compareTo(date2) == 0;
    }

    public static boolean isDateMonthFirstDay(Date date) {
        return date.compareTo(getMonthFirstDay(date)) == 0;
    }

    public static boolean isDateMonthLastDay(Date date) {
        return date.compareTo(getMonthLastDay(date)) == 0;
    }

    /**
     * 获取某一天的起始时间
     *
     * @param day yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static Long getDayBeginTime(String day) throws ParseException {
        String timeBegin = day + " 00:00:00";
        SimpleDateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        Date bTime = dateFormat.parse(timeBegin);

        return bTime.getTime() / 1000;
    }

    /**
     * 获取某一天的结束时间
     *
     * @param day yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static Long getDayEndTime(String day) throws ParseException {
        String timeBegin = day + " 23:59:59";
        SimpleDateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        Date bTime = dateFormat.parse(timeBegin);

        return bTime.getTime() / 1000;
    }

    public static List<String> getLastDaysFromNow(int days) {
        List<String> everyDays = new ArrayList<String>();
        Long date = new Date().getTime();
        for (Integer day = 0; day < days; day++) {
            Date dateNew = new Date(date - DAY);
            everyDays.add(new SimpleDateFormat(YYYY_MM_DD).format(dateNew));
            date = dateNew.getTime();
        }

        return everyDays;
    }

    public static List<String> getLastDaysFromDateTime(int days, Long date) {
        List<String> everyDays = new ArrayList<String>();
        for (Integer day = 0; day < days; day++) {
            Date dateNew = new Date(date);
            everyDays.add(new SimpleDateFormat(YYYY_MM_DD).format(dateNew));
            date = dateNew.getTime();
            date -= DAY;
        }

        return everyDays;
    }

    public static String getLastDay(String day, String pattern) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Long date = dateFormat.parse(day).getTime();
        Date dateNew = new Date(date - DAY);

        return new SimpleDateFormat(pattern).format(dateNew);
    }


    static public class Week {
        String weekNum;
        int year;
        String weekBegin;
        String weekEnd;

        public String getWeekNum() {
            return weekNum;
        }

        public void setWeekNum(String weekNum) {
            this.weekNum = weekNum;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getWeekBegin() {
            return weekBegin;
        }

        public void setWeekBegin(String weekBegin) {
            this.weekBegin = weekBegin;
        }

        public String getWeekEnd() {
            return weekEnd;
        }

        public void setWeekEnd(String weekEnd) {
            this.weekEnd = weekEnd;
        }
    }

    public static List<Week> getWeekSplit(Date startDate, Date endDate) {
        ArrayList<Week> WeekList = new ArrayList<Week>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
            Calendar startCal = Calendar.getInstance();
            startCal.setTime(startDate);
            Calendar endCal = Calendar.getInstance();
            endCal.setTime(endDate);

            Calendar firstMonday = Calendar.getInstance();
            firstMonday.set(startCal.get(Calendar.YEAR), Calendar.JANUARY, 1, 0, 0, 0);
            while (firstMonday.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
                firstMonday.add(Calendar.DAY_OF_YEAR, 1);
            }

            while (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
                startCal.add(Calendar.DAY_OF_YEAR, 1);
            }
            while (endCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                endCal.add(Calendar.DAY_OF_YEAR, -1);
            }

            int startYear = startCal.get(Calendar.YEAR);
            while (startCal.compareTo(endCal) < 0) {
                int endYear = startCal.get(Calendar.YEAR);
                if (startYear < endYear) {
                    firstMonday.set(endYear, Calendar.JANUARY, 1, 0, 0, 0);
                    while (firstMonday.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
                        firstMonday.add(Calendar.DAY_OF_YEAR, 1);
                    }
                    startYear = endYear;
                }
                Week everyWeek = new Week();
                long WeekNum = (startCal.getTimeInMillis() / 1000 - firstMonday.getTimeInMillis() / 1000) / SevenDay + 1;
                String WeekNumStr = String.valueOf(WeekNum);
                if (WeekNum < 10) {
                    WeekNumStr = "0" + WeekNum;
                }
                everyWeek.setYear(startCal.get(Calendar.YEAR));
                everyWeek.setWeekBegin(sdf.format(startCal.getTime()));
                startCal.add(Calendar.DATE, 6);
                everyWeek.setWeekEnd(sdf.format(startCal.getTime()));
                everyWeek.setWeekNum(WeekNumStr);
                startCal.add(Calendar.DATE, 1);
                WeekList.add(everyWeek);
            }
        } catch (Exception e) {
            return WeekList;
        }


        return WeekList;
    }

    public static class MonthlyBasis {
        private String startDate;
        private String endDate;
        private Integer days;

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public Integer getDays() {
            return days;
        }

        public void setDays(Integer days) {
            this.days = days;
        }
    }

    public static List<MonthlyBasis> getMonthSplit(Date beginDate, Date endDate) {
        List<MonthlyBasis> monthlyBasises = new ArrayList<MonthlyBasis>();
        try {
            String firstDay = "";
            String lastDay = "";
            Calendar startCal = Calendar.getInstance();// 定义日期实例
            startCal.setTime(beginDate);// 设置日期起始时间

            Calendar cale = Calendar.getInstance();
            Calendar monthLastcale = Calendar.getInstance();
            monthLastcale.setTime(beginDate);
            SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);

            while (startCal.getTime().before(endDate) && monthLastcale.getTime().before(endDate)) {// 判断是否到结束日期
                MonthlyBasis monthlyBasis = new MonthlyBasis();
                cale.setTime(startCal.getTime());
                if (1 == startCal.get(startCal.DAY_OF_MONTH)) { //当月第一天
                    firstDay = sdf.format(cale.getTime());
                    cale.set(Calendar.DAY_OF_MONTH, startCal
                            .getActualMaximum(Calendar.DAY_OF_MONTH));
                    lastDay = sdf.format(cale.getTime());
                    monthlyBasis.setStartDate(firstDay);
                    monthlyBasis.setEndDate(lastDay);
                    monthlyBasis.setDays(cale.getActualMaximum(Calendar.DAY_OF_MONTH));
                    monthlyBasises.add(monthlyBasis);
                    startCal.add(Calendar.MONTH, 1);// 进行当前日期月份加1
                } else {
                    startCal.add(Calendar.MONTH, 1);
                    startCal.set(Calendar.DAY_OF_MONTH, startCal.getActualMinimum(Calendar.DAY_OF_MONTH));
                }
                monthLastcale.add(Calendar.MONTH, 1);
                monthLastcale.set(Calendar.DAY_OF_MONTH, startCal
                        .getActualMaximum(Calendar.DAY_OF_MONTH));
            }
        } catch (Exception e) {
            return monthlyBasises;
        }

        return monthlyBasises;
    }

    public static List<MonthlyBasis> getQuarterSplit(Date beginDate, Date endDate) {
        List<MonthlyBasis> monthlyBasises = new ArrayList<MonthlyBasis>();
        try {
            String firstDay = "";
            String lastDay = "";
            Calendar startCal = Calendar.getInstance();// 定义日期实例
            startCal.setTime(beginDate);// 设置日期起始时间

            Calendar cale = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);

            while (startCal.getTime().before(endDate)) {// 判断是否到结束日期
                MonthlyBasis monthlyBasis = new MonthlyBasis();
                if (isQuarterFirstDay(startCal)) {
                    firstDay = sdf.format(startCal.getTime());
                    int days = getDays(startCal, 2);
                    cale.setTime(startCal.getTime());
                    cale.set(Calendar.DAY_OF_MONTH, startCal
                            .getActualMaximum(Calendar.DAY_OF_MONTH));
                    lastDay = sdf.format(cale.getTime());
                    startCal.add(Calendar.MONTH, 1);// 进行当前日期月份加1
                    if(cale.getTime().before(endDate) || cale.getTime().equals(endDate)) {
                        monthlyBasis.setStartDate(firstDay);
                        monthlyBasis.setEndDate(lastDay);
                        monthlyBasis.setDays(days);
                        monthlyBasises.add(monthlyBasis);
                    }
                } else {
                    startCal.add(Calendar.MONTH, 1);
                    startCal.set(Calendar.DAY_OF_MONTH, startCal.getActualMinimum(Calendar.DAY_OF_MONTH));
                }

            }
        } catch (Exception e) {
            return monthlyBasises;
        }

        return monthlyBasises;
    }

    public static List<MonthlyBasis> getHalfYearSplit(Date beginDate, Date endDate) {
        List<MonthlyBasis> monthlyBasises = new ArrayList<MonthlyBasis>();
        try {
            String firstDay = "";
            String lastDay = "";
            Calendar startCal = Calendar.getInstance();// 定义日期实例
            startCal.setTime(beginDate);// 设置日期起始时间

            Calendar cale = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);

            while (startCal.getTime().before(endDate)) {// 判断是否到结束日期
                MonthlyBasis monthlyBasis = new MonthlyBasis();
                if (isHalfYearFirstDay(startCal)) {
                    firstDay = sdf.format(startCal.getTime());
                    int days = getDays(startCal, 5);
                    cale.setTime(startCal.getTime());
                    cale.set(Calendar.DAY_OF_MONTH, startCal
                            .getActualMaximum(Calendar.DAY_OF_MONTH));
                    lastDay = sdf.format(cale.getTime());
                    startCal.add(Calendar.MONTH, 1);// 进行当前日期月份加1
                    if(cale.getTime().before(endDate) || cale.getTime().equals(endDate)) {
                        monthlyBasis.setDays(days);
                        monthlyBasis.setStartDate(firstDay);
                        monthlyBasis.setEndDate(lastDay);
                        monthlyBasises.add(monthlyBasis);
                    }
                } else {
                    startCal.add(Calendar.MONTH, 1);
                    startCal.set(Calendar.DAY_OF_MONTH, startCal.getActualMinimum(Calendar.DAY_OF_MONTH));
                }

            }
        } catch (Exception e) {
            return monthlyBasises;
        }

        return monthlyBasises;
    }

    private static int getDays(Calendar startCal, Integer months) {
        int days = startCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (Integer i = 0; i < months; i++) {
            startCal.add(Calendar.MONTH, 1);// 进行当前日期月份加1
            days += startCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        }

        return days;
    }

    private static boolean isQuarterFirstDay(Calendar calendar) {
        if ((1 == calendar.get(calendar.MONTH) + 1 && 1 == calendar.get(calendar.DAY_OF_MONTH)) ||
                (4 == calendar.get(calendar.MONTH) + 1 && 1 == calendar.get(calendar.DAY_OF_MONTH)) ||
                (7 == calendar.get(calendar.MONTH) + 1 && 1 == calendar.get(calendar.DAY_OF_MONTH)) ||
                (10 == calendar.get(calendar.MONTH) + 1 && 1 == calendar.get(calendar.DAY_OF_MONTH))) {
            return true;
        }

        return false;
    }

    private static boolean isHalfYearFirstDay(Calendar calendar) {
        if ((1 == calendar.get(calendar.MONTH) + 1 && 1 == calendar.get(calendar.DAY_OF_MONTH)) ||
                (7 == calendar.get(calendar.MONTH) + 1 && 1 == calendar.get(calendar.DAY_OF_MONTH))) {
            return true;
        }

        return false;
    }
}

