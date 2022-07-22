package MyOwnFilesMoveToGit.LocalesUtility;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class AvailableCharsets {

    //region availableCharsets_ver_1
    public static void availableCharsets_ver_1() {


        Map<String, Charset> charSets = Charset.availableCharsets();
        Iterator<String> it = charSets.keySet().iterator();


        while (it.hasNext()) {
            String csName = (String) it.next();
            System.out.print(csName);
            Iterator<String> aliases = ((Charset) charSets.get(csName)).aliases().iterator();
            if (aliases.hasNext())
                System.out.print(": ");
            while (aliases.hasNext()) {
                System.out.print(aliases.next());
                if (aliases.hasNext())
                    System.out.print(", ");
            }

            System.out.println();

        }
    }
    //endregion

    //region availableCharsets_ver_2
    public static LinkedList<String> availableCharsets_ver_2() {

        LinkedList<String> stringList = new LinkedList<>();

        Map charSets = Charset.availableCharsets();
        Iterator it = charSets.keySet().iterator();


        while (it.hasNext()) {
            String csName = (String) it.next();
            StringBuilder builder = new StringBuilder();
            builder.append(csName);

            Iterator aliases = ((Charset) charSets.get(csName)).aliases().iterator();

            if (aliases.hasNext()) {
                builder.append(": ");
            }

            while (aliases.hasNext()) {
                String s = (String) aliases.next();
                builder.append(s);

                if (aliases.hasNext()) {
                    builder.append(", ");
                }

            }

            stringList.add(builder.toString());
        }

        return stringList;
    }
    //endregion

}
