package MyOwnFilesMoveToGit.LocalesUtility;

import java.text.NumberFormat;
import java.util.Locale;

public class LocalesBuilder {

    private String countryName;
    private double income;
    private String languageName;
    private String languageCode;
    private String variantCode;
    private String threeLetterAbbreviation;
    private String ISO3166;
    private NumberFormat currencyFormat;

    public LocalesBuilder() {
    }

    public LocalesEntity build() {
        return new LocalesEntity(this);
    }

    public NumberFormat getCurrencyFormat() {
        return currencyFormat;
    }

    public LocalesBuilder setCurrencyFormat(Locale locale) {
        this.currencyFormat = NumberFormat.getCurrencyInstance(locale);
        return this;
    }

    public String getCountryName() {
        return countryName;
    }

    public LocalesBuilder setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public String getLanguageName() {
        return languageName;
    }

    public LocalesBuilder setLanguageName(String languageName) {
        this.languageName = languageName;
        return this;

    }

    public String getLanguageCode() {
        return languageCode;
    }

    public LocalesBuilder setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
        return this;

    }

    public double getIncome() {
        return income;
    }

    public LocalesBuilder setIncome(double income) {
        this.income = income;
        return this;
    }

    public String getVariantCode() {
        return variantCode;
    }

    public LocalesBuilder setVariantCode(String variantCode) {
        this.variantCode = variantCode;
        return this;

    }

    public String getThreeLetterAbbreviation() {
        return threeLetterAbbreviation;
    }

    public LocalesBuilder setThreeLetterAbbreviation(String threeLetterAbbreviation) {
        this.threeLetterAbbreviation = threeLetterAbbreviation;
        return this;
    }

    public String getISO3166() {
        return ISO3166;
    }

    public LocalesBuilder setISO3166(String ISO3166) {
        this.ISO3166 = ISO3166;
        return this;
    }
}
