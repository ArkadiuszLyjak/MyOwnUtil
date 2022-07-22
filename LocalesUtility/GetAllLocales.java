package MyOwnFilesMoveToGit.LocalesUtility;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.function.UnaryOperator;

public class GetAllLocales {

    static int inc = 0;

    //region getAllLocales
    public static List<LocalesEntity> getAllLocales(double incomeDouble) {

        Locale[] locales = Locale.getAvailableLocales();
        List<LocalesEntity> listWithAllLocales = new LinkedList<>();

        boolean variantLocale; // locale's variant
        boolean threeLetterAbbr;
        LocalesBuilder localesBuilder = null;

        //region for
        for (Locale locale : locales) {
            try {
                try {
                    // Returns a name for the locale's country
                    localesBuilder = new LocalesBuilder()
                            .setIncome(incomeDouble)
                            // name for the locale's language
                            .setLanguageName(locale.getDisplayLanguage())
                            // Returns the language code of this Locale.
                            .setLanguageCode(locale.getLanguage())
                            // ISO 3166 2-letter code
                            .setISO3166(locale.getCountry())
                            // ISO 3166-1 alpha-3 uppercase
                            .setThreeLetterAbbreviation(locale.getISO3Country())
                            .setCurrencyFormat(locale);

                    //region variantLocale
                    variantLocale = locale.getVariant().isEmpty();
                    if (!variantLocale) {
                        localesBuilder.setVariantCode(locale.getVariant());
                    } else localesBuilder.setVariantCode("EMPTY");
                    //endregion

                    //region ThreeLetterAbbreviation
                    threeLetterAbbr = locale.getISO3Country().isEmpty();
                    if (!threeLetterAbbr) {
                        localesBuilder.setThreeLetterAbbreviation(locale.getISO3Country());
                    } else localesBuilder.setThreeLetterAbbreviation("locale doesn't specify a country");
                    //endregion

                    //region set country name
                    UnaryOperator<Integer> incrementer = integer -> ++integer;
                    inc = incrementer.apply(inc);
                    String countryName = locale.getDisplayCountry();
                    if (countryName.isEmpty()) {
                        localesBuilder.setCountryName("filename_" + inc);
                    } else {
                        localesBuilder.setCountryName(locale.getDisplayCountry()
                                .replaceAll(" ", "_"));
                    }

                    //endregion
                } catch (MissingResourceException e) {
                    localesBuilder.setThreeLetterAbbreviation("locale doesn't specify a country");
                }

                listWithAllLocales.add(localesBuilder.build());

            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        //endregion

        return listWithAllLocales;
    }
    //endregion

}
