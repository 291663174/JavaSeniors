import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Wuhen
 * @Description JDK8.0之前的日期时间的API测试
 * 1.System类中currentTimeMillis();
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 * @date 2020-09-23 21:20
 **/
public class DateTimeTest {
    /**
     * SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
     * 1.两个操作
     * 1.1 格式化：日期 --->字符串
     * 1.2 解析：格式化的逆过程：字符串 --->日期
     * 2.SimpleDateFormat的实例化
     **/
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        //格式化:日期-->字符串
        Date date = new Date();
        System.out.println(date);

        String format = simpleDateFormat.format(date);
        System.out.println(format);

        //解析：格式化的逆过程：字符串--->日期
        String str = "2020/9/23 上午12:30";
        Date date1 = simpleDateFormat.parse(str);
        System.out.println(date1);
        //****************按照指定的方式格式化和解析，调用带参的构造器**********************
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = simpleDateFormat1.format(date);
        System.out.println(format1);//2020-09-23 09:56:32
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数体现）
        //否则：抛异常
        Date date2 = simpleDateFormat1.parse("2020-09-23 09:56:32");
        System.out.println(date2);
    }

    /**
     * 练习一：字符串"2020-09-23"转换为java.sql.Date
     **/
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-23";
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat1.parse(birth);
        //System.out.println(date);
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }

    /**
     *  练习二：“三天打渔两天晒网”   1990-01-01 xxxx-xx-xx 打渔？晒网？
     *  举例：2020-09-08  ？ 总天数
     *  总天数 % 5 == 1，2，3  ：打渔
     *  总天数 % 5 == 4，0  ：晒网
     *  总天数的计算？
     *  方式一：(date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1
     *  方式二：1990-01-01   --> 2019-12-31  +  2020-01-01  -->2020-09-08
     **/

    /**
     * Calendar日历类（抽象类）的使用
     **/
    @Test
    public void testCalendar() {
        //实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance();
        Calendar calendar = Calendar.getInstance();
        //System.out.println(calendar.getClass());
        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类 --->Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date --->日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }

    /**
     *  localDate、LocalTime、LocalDateTime的使用
     *  说明：
     *  1.localDateTime相较于LocalDate、LocalTime:使用频率要高
     **/
    @Test
    public void test1(){
        //now()：获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():设置指定的年、月、日、时、分、秒，没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1);

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //体现了不可变性
        //withXxx():设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        //不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
    }

    /**
     *  Instant的使用
     *      类似于java.util.Date类
     **/
    @Test
    public void test2(){
        Instant instant = Instant.now();
        //获取到的时间还需要+8小时才能得到东八区
        System.out.println(instant);

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //toEpochMilli():获取对应的毫秒数，自1970年1月1日0时0分0秒（UTC）开始的毫秒数 -->Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli():通过指定的毫秒数，获取Instant实例  -->Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1600875730055L);
        System.out.println(instant1);
    }

    /**
     *  DateTimeFormatter:格式化或解析日期，时间
     *  类似于SimpleDateFormat
     **/
    @Test
    public void test3(){
        //方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = dateTimeFormatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);

        //解析：字符串 -->日期
        TemporalAccessor parse = dateTimeFormatter.parse("2020-09-24T00:08:26.8186813");
        System.out.println(parse);

        //方式二：本地化相关的格式。如：ofLocalizeDateTime(FormatStyle.LONG)
        //本地化相关的格式，如：ofLocalizedDateTime()
        //FormateStyle.LONG / FormateStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDateTest
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //格式化
        String str2 = dateTimeFormatter1.format(localDateTime);
        System.out.println(str2);

        //本地化相关的格式，如：ofLocalizedDate()
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        //格式化
        String str3 = dateTimeFormatter2.format(LocalDate.now());
        System.out.println(str3);

        //重点：：方式三：自定义的格式。如：ofPattern("yyyy-MM-dd hh:mm:ss")
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String str4 = dateTimeFormatter3.format(LocalDateTime.now());
        System.out.println(str4);

        //解析
        TemporalAccessor accessor = dateTimeFormatter3.parse("2020-09-24 12:56:26");
        System.out.println(accessor);
    }

}
