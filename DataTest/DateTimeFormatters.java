package MyOwnFilesMoveToGit.DataTest;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormatters {

    //region DateTimeFormatter
    public static DateTimeFormatter dtf1_ofLocalizedDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
    public static final DateTimeFormatter dtf2 = DateTimeFormatter.ISO_OFFSET_DATE;
    public static DateTimeFormatter dtf3_ISO_DATE = DateTimeFormatter.ISO_DATE;

    public static DateTimeFormatter dtf4_date_time_zone_GMT = DateTimeFormatter.ofPattern(
            "\n'Anno Domini: 'G\n" +
                    "'day-of-week: 'EEEE\n" +
                    "'day-of-month: ' d\n" +
                    "'month-of-year: ' LLLL\n" +
                    "'year: ' u\n" +
                    "'godzina: ' HH:mm:ss\n" +
                    "'time-zone name: ' zzzz\n" +
                    "'localized zone-offset: ' O");

    public static DateTimeFormatter dtf5_ISO_LOCAL_TIME = DateTimeFormatter.ISO_LOCAL_TIME;
    public static DateTimeFormatter dtf6_ISO_OFFSET_TIME = DateTimeFormatter.ISO_OFFSET_TIME;
    public static DateTimeFormatter dtf7_ISO_LOCAL_DATE_TIME = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    public static DateTimeFormatter dtf8_ISO_OFFSET_DATE_TIME = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
    public static DateTimeFormatter dtf9_ISO_ZONED_DATE_TIME = DateTimeFormatter.ISO_ZONED_DATE_TIME;
    public static DateTimeFormatter dtf10_ISO_DATE_TIME = DateTimeFormatter.ISO_DATE_TIME;
    public static DateTimeFormatter dtf11_ISO_ORDINAL_DATE = DateTimeFormatter.ISO_ORDINAL_DATE;
    public static DateTimeFormatter dtf12_ISO_WEEK_DATE = DateTimeFormatter.ISO_WEEK_DATE;
    public static DateTimeFormatter dtf13_ISO_INSTANT = DateTimeFormatter.ISO_INSTANT;
    public static DateTimeFormatter dtf14_BASIC_ISO_DATE = DateTimeFormatter.BASIC_ISO_DATE;
    //endregion
}
