package MyOwnFilesMoveToGit.DataTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class MonthsBetweenTwoDates {

    private static final LocalDate startLoan = LocalDate.of(2021, 1, 18);
    private static final LocalDate endLoan = LocalDate.of(2046, 8, 15);

    private String dateScannedStart;
    private LocalDate startDate;
    private LocalDate now;
    private String dateScannedEnd;
    private LocalDate endDate;
    private long periodAllTime;

    //region Constructor
    public MonthsBetweenTwoDates(LocalDate startDate, LocalDate endDate, LocalDate now) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.now = now;
    }
    //endregion

    //region main
    public static void main(String[] args) {
        MonthsBetweenTwoDates datesm = new MonthsBetweenTwoDates(startLoan, endLoan, LocalDate.now());

        long periodMonthsWhatLeftLoan = datesm.periodBetweenTwoDatesInMonths(startLoan, endLoan);
        System.out.println(periodMonthsWhatLeftLoan);

        long periodMonthsFullLoan = datesm.periodBetweenTwoDatesInMonths(datesm.getNow(), endLoan);
        System.out.println(periodMonthsFullLoan);
    }
    //endregion

    //region getters
    public static LocalDate getStartLoan() {
        return startLoan;
    }

    public static LocalDate getEndLoan() {
        return endLoan;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public long getPeriodAllTime() {
        return periodAllTime;
    }

    public String getDateScannedStart() {
        return dateScannedStart;
    }

    public String getDateScannedEnd() {
        return dateScannedEnd;
    }

    public LocalDate getNow() {
        return now;
    }
    //endregion

    //region monthsBetweenTwoDates
    private long monthsBetweenTwoDates() {

        DateTimeFormatter parseDateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            // Scanner scanner = new Scanner(System.in);

            // System.out.print("Start date \t(yyyy-mm-dd): \t\t");
            // dateScannedStart = scanner.nextLine();
            dateScannedStart = "2021-03-15";
            startDate = LocalDate.parse(dateScannedStart, parseDateformatter);

            // System.out.print("End date \t(yyyy-mm-dd): \t\t");
            // dateScannedEnd = scanner.nextLine();
            dateScannedEnd = "2021-04-15";
            endDate = LocalDate.parse(dateScannedEnd, parseDateformatter);

            periodAllTime = periodBetweenTwoDatesInMonths(startDate, endDate);

        } catch (
                DateTimeParseException e) {
            e.printStackTrace();
        }

        return periodAllTime;

    }
    //endregion

    //region periodBetweenTwoDatesInMonths
    private long periodBetweenTwoDatesInMonths(LocalDate ld1, LocalDate ld2) {
        return ChronoUnit.MONTHS.between(ld1, ld2);
    }
    //endregion

    //region printCollectedDates
    void printCollectedDates() {
        DateTimeFormatter datePrinter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);

        System.out.println(getDateScannedStart() + " tj. " + datePrinter.format(getStartDate()));
        System.out.println(getDateScannedEnd() + " tj. " + datePrinter.format(getEndDate()));
        System.out.println("Perion in months (exclusive): " + this.getPeriodAllTime());
    }
    //endregion

}
