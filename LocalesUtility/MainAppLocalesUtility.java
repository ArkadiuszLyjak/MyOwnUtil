package MyOwnFilesMoveToGit.LocalesUtility;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MainAppLocalesUtility {
    static int inc = 0;

    public static void main(String[] args) throws IOException {

        System.out.println("Jestem na hotfix");
        List<LocalesEntity> allLocales = GetAllLocales.getAllLocales(100000.87);
        for (LocalesEntity le : allLocales) le.printLocaleInstance();
        CreateFilesWithCountryInformation.createFilesWithCountries(allLocales);

        //region Description
        Consumer<String> printString = System.out::println;

        //region countryName
        Stream<String> countryName = UtilityClass.mapLocaleToStream(
                allLocales, LocalesEntity::getCountryName);
        countryName.forEach(printString);
        //endregion

        /*//region languageName
        Stream<String> languageName = UtilityClass.mapLocaleToStream(
                allLocales, LocalesEntity::getLanguageName);
//        languageName.forEach(printString);
        //endregion*/

        /*//region languageCode
        Stream<String> languageCode = UtilityClass.mapLocaleToStream(
                allLocales, LocalesEntity::getLanguageCode);
//        languageCode.forEach(printString);
        //endregion*/

        /*//region variantCode
        Stream<String> variantCode = UtilityClass.mapLocaleToStream(
                allLocales, LocalesEntity::getVariantCode);
//        variantCode.forEach(printString);
        //endregion*/

        /*//region threeLetterAbbreviation
        Stream<String> threeLetterAbbreviation = UtilityClass.mapLocaleToStream(
                allLocales, LocalesEntity::getThreeLetterAbbreviation);
//        threeLetterAbbreviation.forEach(printString);
        //endregion*/

        /*//region ISO3166
        Stream<String> ISO3166 = UtilityClass.mapLocaleToStream(
                allLocales, LocalesEntity::getISO3166);
//        ISO3166.forEach(printString);
        //endregion*/

        //region currencyFormat
        Stream<String> incomeFormattedInLocalesFormatCurrency =
                UtilityClass.getCurrencyInLocaleFormatString(allLocales);

//        incomeFormattedInLocalesFormatCurrency.forEach(printString);
        //endregion
        //endregion

    }
}




