package MyOwnFilesMoveToGit.DataTest;

import java.time.*;

public class DataOfTime {
    // region LocalDateTime
    //Milliseconds precision
    static LocalDateTime localDateTime1 = LocalDateTime.of(
            2019, 03, 28,
            14, 33, 48, 123456789);

    //Month enum
    static LocalDateTime localDateTime2 = LocalDateTime.of(
            2019, Month.MARCH, 28,
            14, 33, 48, 123456789);

    //seconds precision
    static LocalDateTime localDateTime3 = LocalDateTime.of(
            2019, Month.MARCH, 28,
            14, 33, 48);

    //minutes precision
    static LocalDateTime localDateTime4 = LocalDateTime.of(
            2019, Month.MARCH, 28,
            14, 33);

    //local date + local time
    static LocalDate date = LocalDate.of(2109, 03, 28);
    static LocalTime time = LocalTime.of(10, 34);

    static LocalDateTime localDateTime5 = LocalDateTime.of(date, time);
    static ZonedDateTime zoneddatetime1 = ZonedDateTime.now();
    //endregion+
}
