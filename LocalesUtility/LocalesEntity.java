package MyOwnFilesMoveToGit.LocalesUtility;

import java.text.NumberFormat;
import java.util.Formatter;

public class LocalesEntity {

    private String countryName;
    private double income;
    private String languageName;
    private String languageCode;
    private String variantCode;
    private String threeLetterAbbreviation;
    private String ISO3166;
    private NumberFormat currencyFormat;

    //region LocalesEntity Constructor
    public LocalesEntity(LocalesBuilder localesBuilder) {
        countryName = localesBuilder.getCountryName();
        income = localesBuilder.getIncome();
        languageName = localesBuilder.getLanguageName();
        languageCode = localesBuilder.getLanguageCode();
        variantCode = localesBuilder.getVariantCode();
        threeLetterAbbreviation = localesBuilder.getThreeLetterAbbreviation();
        ISO3166 = localesBuilder.getISO3166();
        currencyFormat = localesBuilder.getCurrencyFormat();
    }
    //endregion

    //region makeString
    public String makeString() {

        StringBuilder bc = new StringBuilder();
        Formatter fm = new Formatter(bc);

        int spaceModifier = 50;

        fm.format("\n%s [%s]\n",
                UtilityClass.padLeftZeros("name for the locale's country: ", spaceModifier),
                countryName);

        fm.format("%s [%s]\n",
                UtilityClass.padLeftZeros("income in locale currency: ", spaceModifier),
                currencyFormat.format(income));

        fm.format("%s [%s]\n",
                UtilityClass.padLeftZeros("name for the locale's language: ", spaceModifier),
                languageName);

        fm.format("%s [%s]\n",
                UtilityClass.padLeftZeros("language code of this Locale: ", spaceModifier),
                languageCode);

        fm.format("%s [%s]\n",
                UtilityClass.padLeftZeros("variant code for this locale: ", spaceModifier),
                variantCode);

        fm.format("%s [%s]\n",
                UtilityClass.padLeftZeros("three-letter abbr. for this locale's country: ", spaceModifier),
                threeLetterAbbreviation);

        fm.format("%s [%s]\n",
                UtilityClass.padLeftZeros("ISO 3166 2-letter code: ", spaceModifier),
                ISO3166);

        return bc.toString();
    }
    //endregion

    //region getters and setters
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public NumberFormat getCurrencyFormat() {
        return currencyFormat;
    }

    public void setCurrencyFormat(NumberFormat currencyFormat) {
        this.currencyFormat = currencyFormat;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getVariantCode() {
        return variantCode;
    }

    public void setVariantCode(String variantCode) {
        this.variantCode = variantCode;
    }

    public String getThreeLetterAbbreviation() {
        return threeLetterAbbreviation;
    }

    public void setThreeLetterAbbreviation(String threeLetterAbbreviation) {
        this.threeLetterAbbreviation = threeLetterAbbreviation;
    }

    public String getISO3166() {
        return ISO3166;
    }

    public void setISO3166(String ISO3166) {
        this.ISO3166 = ISO3166;
    }
    //endregion

    //region printLocaleInstance
    public void printLocaleInstance() {
        System.out.println("\nname for the locale's country: [" + countryName + "]");
        System.out.println("income in locale currency: [" + currencyFormat.format(income) + "]");
        System.out.println("name for the locale's language: [" + languageName + "]");
        System.out.println("language code of this Locale: [" + languageCode + "]");
        System.out.println("variant code for this locale: [" + variantCode + "]");
        System.out.println("three-letter abbr. for this locale's country: [" + threeLetterAbbreviation + "]");
        System.out.println("ISO 3166 2-letter code: [" + ISO3166 + "]");
    }
    //endregion
}
