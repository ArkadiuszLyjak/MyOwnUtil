package MyOwnFilesMoveToGit.LocalesUtility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.List;

public class CreateFilesWithCountryInformation {

    //region checIfDirectoryExistsAndCreateIfNot
    private static boolean checIfDirectoryExistsAndCreateIfNot(File directoryPATH) {
        boolean result = true;

        if (!directoryPATH.exists()) {
            result = directoryPATH.mkdir();
        }

        return result;
    }
    //endregion

    //region createFilesWithCountries
    public static void createFilesWithCountries(List<LocalesEntity> localesEntityList) throws IOException {
        String parentDir = "c:\\repo\\IdeaProjects\\untitled\\TestFilesDir\\FilesLocales";
        String filename;
        File absPathToFile;
        boolean fileCreated;
        FileWriter fwr;
        BufferedWriter bwr;

        try {

            File directoryPATH = new File(parentDir);

            if (checIfDirectoryExistsAndCreateIfNot(directoryPATH)) {
                for (LocalesEntity localesEntity : localesEntityList) {
                    filename = localesEntity.getCountryName();
                    absPathToFile = new File(directoryPATH, filename + ".txt");

                    if (!absPathToFile.exists()) {
                        absPathToFile.createNewFile();
                        System.out.println("[" + filename + "] File already created...");
                    }

//                    System.out.println("[" + filename + "] already exists");
                    fwr = new FileWriter(absPathToFile);
                    bwr = new BufferedWriter(fwr);
                    bwr.write(fileInformation(absPathToFile.toString()));
                    bwr.write(localesEntity.makeString());
                    bwr.close();

                }

            } else {
                System.out.println("Directory: " + directoryPATH + " does't exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //endregion

    //region fileInformation
    public static String fileInformation(String filePATH) {
        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);

        try {
            Path file = Paths.get(filePATH);
            BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

            fmt.format("%-20s %20s\n", "creationTime:", formatDateFile(attr.creationTime()));
            fmt.format("%-20s %20s\n", "lastAccessTime:", formatDateFile(attr.lastAccessTime()));
            fmt.format("%-20s %20s\n", "lastModifiedTime:", formatDateFile(attr.lastModifiedTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
    //endregion

    //region formatDateFile
    public static String formatDateFile(FileTime fileTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime ldt = fileTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return ldt.format(dtf);
    }
    //endregion

}
