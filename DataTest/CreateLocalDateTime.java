package MyOwnFilesMoveToGit.DataTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Arrays;

public class CreateLocalDateTime {

    // Klasa jako argument przyjmuje różną liczbę parametrów
    // i zapisuje w instancji klasy w formie tablicy

    //region makeInstance
    void makeInstance(Object... o) {
        DataCollection dc = new DataCollection(o);
        dc.printObjects();
    }
    //endregion

    //region DataCollection
    private static class DataCollection {
        private static Object[] items;
        private static int size = 0;

        private DataCollection(Object... values) {
            size = values.length;
            items = Arrays.copyOf(values, size);
        }

        static private int getSize(String s) {
            return size;
        }

        //region printObjects
        private void printObjects() {
            for (int i = 0; i < size; i++) {
                Object o = getObj(i);
                // Class<?> tClass = o.getClass();

                if (o.getClass() == LocalDateTime.class) {
                    System.out.println("LocalDateTime.class: "
                            + DateTimeFormatters.dtf7_ISO_LOCAL_DATE_TIME.format((LocalDateTime) o));

                } else if (o.getClass() == LocalDate.class) {
                    System.out.println("LocalDate.class: "
                            + DateTimeFormatters.dtf1_ofLocalizedDate.format((LocalDate) o));

                } else if (o.getClass() == LocalTime.class) {
                    System.out.println("LocalTime.class: "
                            + DateTimeFormatters.dtf5_ISO_LOCAL_TIME.format((LocalTime) o));

                } else if (o.getClass() == ZonedDateTime.class) {
                    System.out.println("\nZonedDateTime.class: "
                            + DateTimeFormatters.dtf4_date_time_zone_GMT.format((ZonedDateTime) o));
                }

            }

        }
        //endregion

        private int getSize() {
            return size;
        }

        public int getSize(boolean b) {
            return size;
        }

        private Object getObj(int i) {
            // public Object getObj(int i) {
            // protected Object getObj ( int i){
            return items[i];
        }
    }
    //endregion

}