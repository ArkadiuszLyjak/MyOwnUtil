package MyOwnFilesMoveToGit.DataTest;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class GetZonesIDs {

    //region printDatesZones
    public static void printDatesZones(List<String> stringList) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern("uuuu/MM/dd HH:mm:ss a VV O");

//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.BASIC_ISO_DATE;
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE;
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE;
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_OFFSET_TIME;
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_TIME;
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_ORDINAL_DATE;
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_WEEK_DATE;
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_INSTANT;
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.RFC_1123_DATE_TIME;

        ZonedDateTime zdt = ZonedDateTime.now();

        for (String s : stringList) {
            ZoneId zoneId = ZoneId.of(s);

            String zoneIdString = zoneId.getDisplayName(
                    TextStyle.FULL,
                    Locale.getDefault());

            ZonedDateTime zoneAtPlaces = zdt.withZoneSameInstant(zoneId);
            System.out.println(dateTimeFormatter.format(zoneAtPlaces)
                    + " " + zoneIdString);

            System.out.println();
        }

    }
    //endregion

    //region getIds
    public static List<String> getIds() {
        Set<String> allZones = ZoneId.getAvailableZoneIds();

        return new ArrayList<>(allZones);
    }
    //endregion

}
