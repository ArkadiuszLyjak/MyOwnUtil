package MyOwnFilesMoveToGit.LocalesUtility;

import java.text.NumberFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class UtilityClass {

    //region padLeftZeros
    public static String padLeftZeros(String inputString, int length) {

        if (inputString.length() >= length) {
            return inputString;
        }

        StringBuilder sb = new StringBuilder();

        while (sb.length() < length - inputString.length()) {
            sb.append('.');
        }
        sb.append(inputString);

        return sb.toString();
    }
    //endregion

    //region printLocalesList
    public static void printLocalesList(List<LocalesEntity> localesEntityList) {
        for (LocalesEntity localesEntity : localesEntityList) {
            localesEntity.printLocaleInstance();
        }
    }
    //endregion

    //region getCurrencyInLocaleFormatString
    public static Stream<String> getCurrencyInLocaleFormatString(List<LocalesEntity> localesEntityList) {
        Map<NumberFormat, Double> map = new LinkedHashMap<>();

        NumberFormat nf;
        double income;

        for (LocalesEntity localesEntity : localesEntityList) {
            nf = localesEntity.getCurrencyFormat();
            income = localesEntity.getIncome();
            map.put(nf, income);
        }

        //region mapIncomeToStringFunction
        Function<Map<NumberFormat, Double>, List<String>> mapIncomeToStringFunction = numberFormatDoubleMap -> {
            Set<Map.Entry<NumberFormat, Double>> entrySet = numberFormatDoubleMap.entrySet();
            List<String> stringList = new LinkedList<>();

            for (Map.Entry<NumberFormat, Double> entry : entrySet) {
                stringList.add(entry.getKey().format(entry.getValue()));
            }

            return stringList;

        };
        //endregion

        return mapIncomeToStringFunction.apply(map).stream();

    }
    //endregion

    //region mapLocaleToStream
    public static <R> Stream<R> mapLocaleToStream(
            List<LocalesEntity> localesEntityList,
            Function<LocalesEntity, R> function) {

        return localesEntityList.stream().map(function);

    }
    //endregion

    //region takeNumberFromUserToPrintLocaleVariable
    public static void takeNumberFromUserToPrintLocaleVariable() {

    }
    //endregion

    //region printCollection
    public static <T> void printCollection(Collection<T> tCollection) {
        for (T t : tCollection) System.out.println(t);
    }
    //endregion

}
