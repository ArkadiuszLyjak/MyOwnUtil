package MyOwnFilesMoveToGit.LocalesUtility;

import java.util.Currency;
import java.util.Formatter;
import java.util.Locale;
import java.util.Set;

public class AvailableCurrencies {

    //region printAvailableCurrencies
    public static void printAvailableCurrencies(Locale[] locales) {
        Set<Currency> currencySet = Currency.getAvailableCurrencies();
        StringBuilder currencyStringBuilder = new StringBuilder();
        Formatter currencyFormatter = new Formatter(currencyStringBuilder);

        String currencyISO4217Code;
        String currencySymbol;
        Currency currencyInstance;

        for (Currency currency : currencySet) {
            currencyISO4217Code = currency.getCurrencyCode();
            currencyFormatter.format("Currency ISO_4217 Code: " + currencyISO4217Code + "\n");

            currencySymbol = currency.getSymbol();
            currencyFormatter.format("Currency symbol: " + currencySymbol + "\n");

            currencyFormatter.format("\n");
        }

        System.out.println(currencyStringBuilder);

    }
    //endregion

}
