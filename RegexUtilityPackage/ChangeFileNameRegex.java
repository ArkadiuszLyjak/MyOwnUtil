package MyOwnFilesMoveToGit.RegexUtilityPackage;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeFileNameRegex {

    // TODO przeszukac katalogi i wypisac nazwy katalogow
    // TODO zastosowac wyr. regularne do zmiany nazw:
    // TODO zastapic polskie znaki na ASCII
    // usunac wszelkie inne znaki niz '_' (podkreslnik)
    // zostawic rozszerzenia bez zmian np. .jpg .txt itp

    private static final String directoryPath = "c:\\Users\\alyja\\Documents\\files_to_rename\\";
    private static final String regex = " ";
    private static final String replacement = "_";
    private static final File fileDirectoryPath = new File(directoryPath);

    public static void main(String[] args) {
        try {
            renameFiles(fileDirectoryPath, regex, replacement);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //region renameFiles
    public static void renameFiles(File fileDirectoryPath, String regex, String replacement)
            throws IOException {

        try {

            for (File file : Objects.requireNonNull(fileDirectoryPath.listFiles())) {
                try {
                    System.out.println(file.getName());

                    // TODO zapisac gdzies extension lub replejsmentowac caly plik
                    //region Description
                    String removedExtension = removeFileExtension(file.getName(), false)
                            .trim()
                            .replaceAll("(_{2,})", "_")
                            .replaceAll("([^a-zA-Z0-9])", "_");

//                    System.out.println(removedExtension);

                    File sourceFileName = new File(fileDirectoryPath, file.getName());
                    Path pathToSourceFile = Paths.get(String.valueOf(sourceFileName));

                    Files.move(pathToSourceFile, Paths.get(fileDirectoryPath.toString(),
                                    file.getName()).resolveSibling(removedExtension),
                            StandardCopyOption.REPLACE_EXISTING);
                    //endregion

                    System.out.println();

                } catch (FileAlreadyExistsException e) {
                    System.out.println("\nFile ---> \n\"" + file.getName() + "\"\nexists\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //endregion

    //region removeFileExtension
    public static String removeFileExtension(String filename, boolean removeAllExtensions) {
        if (filename == null || filename.isEmpty()) {
            System.out.println("Filename empty");
            return filename;
        }

        String extPattern = "(?<!^)[.]" + (removeAllExtensions ? ".*" : "[^.]*$");
        return filename.replaceAll(extPattern, ".MISSING_EXTENSION");
    }
    //endregion

    //region countDigits
    static int countDigits(String stringToSearch) {
        Pattern digitRegex = Pattern.compile("\\d");
        Matcher countEmailMatcher = digitRegex.matcher(stringToSearch);

        int count = 0;
        while (countEmailMatcher.find()) {
            count++;
        }

        return count;
    }
    //endregion
}
