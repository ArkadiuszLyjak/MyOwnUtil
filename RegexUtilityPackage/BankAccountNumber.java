package MyOwnFilesMoveToGit.RegexUtilityPackage;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankAccountNumber {

    // private long bankAccountNum;
    private final BigInteger bankAccountNum;
    private String takenString;

    public BankAccountNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        String regexNumBank = "^[0-9 ]+$";
        Pattern pattern = Pattern.compile(regexNumBank);
        Matcher matcher;
        boolean match;

        do {
            System.out.print("Type bank acc num: ");
            takenString = sc.nextLine();
            matcher = pattern.matcher(takenString);
            match = matcher.matches();

        } while (!match);

        this.bankAccountNum = giveNumberAsBigInteger(this.takenString);
    }

    public static void main(String[] args) {

        System.out.println("A tutaj mala modyfikacja na master");

        try {

            BankAccountNumber bankAccountNumber = new BankAccountNumber();

            System.out.println("Trimmed String: " + bankAccountNumber.getTakenString());
            System.out.println("String with no spaces beetwen: "
                    + bankAccountNumber.getBankAccountNum());

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    //region give Number As BigInteger
    private BigInteger giveNumberAsBigInteger(String takenString) {
        String trimmedString = takenString.trim();
        String toReplace = "";
        String fromReplace = " ";
        String replaceSpace = trimmedString.replaceAll(fromReplace, toReplace);

        return new BigInteger(replaceSpace);
    }
    //endregion


    //region getters
    String getTakenString() {
        return takenString;
    }

    public BigInteger getBankAccountNum() {
        return bankAccountNum;
    }
    //endregion
}
