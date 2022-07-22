package MyOwnFilesMoveToGit.CopyDirectories;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateFileAndCopyFilesContents {

    //region parent file path
    public static String parentPathString = "c:\\repo\\IdeaProjects\\untitled\\TestFilesDir\\";
    static Path parentPath = FileSystems.getDefault().getPath(parentPathString);
    //endregion

    //region SOURCE file path
    static String fileNameSource = "copyFrom.txt";
    static File sourceFile = new File(parentPathString, fileNameSource);
    static Path fileNameSourcePath = Paths.get(parentPathString, fileNameSource);
    //endregion

    //region DESTINATION file path
    static String fileNameDestination = "copyTo.txt";
    static File destinationFile = new File(parentPathString, fileNameDestination);
    static Path fileNameDestionationPath = Paths.get(parentPathString, fileNameDestination);
    //endregion

    //region move file to another directory
    static String fileNameToMoveOriginal = "testq.txt";
    static String fileNameToMoveRenamed = "testq_renamed.txt";
    static String fileToMoveStringPath = parentPathString + fileNameToMoveOriginal;
    static Path filToMovePath = Paths.get(fileToMoveStringPath);
    static String pathToFolderToCopyTo = "c:\\repo\\IdeaProjects\\untitled\\TestFilesDir\\Nowiutki_Folder\\";
    static String fileMovedString = pathToFolderToCopyTo + fileNameToMoveRenamed;
    static Path fileMovedPath = Paths.get(fileMovedString);
    //endregion

    //region main
    public static void main(String[] args) throws IOException {

        try {
            File fileToOperate = new File(fileMovedString);
//            FileInputStream fis = new FileInputStream(fileToOperate);
//            System.out.println(readFromInputStream(fis));

//            givenFileName_whenUsingFileUtils_thenFileData(Paths.get(fileToOperate.toString()));

            // read file
            Stream<String> stringStream = whenReadWithBufferedReader_thenCorrect(fileToOperate);

            // create new file


            // write filtered data to the newly created file


            List<String> strings = stringStream.filter(s -> Pattern
                            .compile("\\w+.txt")
                            .matcher(s)
                            .matches())
                    .collect(Collectors.toList());

            strings.forEach(System.out::println);

            File fileToWrite = new File(pathToFolderToCopyTo, "filenew.txt");
            writeToFile(strings, fileToWrite);

        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }


    }
    //endregion

    //region readFromInputStream
    public static String readFromInputStream(InputStream inputStream) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        }

        return stringBuilder.toString();
    }
    //endregion

    //region readUnicodeBufferedReader
    public static void readUnicodeBufferedReader(String fileName) {

    }
    //endregion

    //region readUnicodeFiles
    public static void readUnicodeFiles(String fileName) {

    }
    //endregion

    //region readUnicodeJava11
    public static void readUnicodeJava11(String fileName) {

    }
    //endregion

    //region Description
    public static void readUnicodeClassic(String fileName) {
    }
    //endregion

    //region whenReadUTFEncodedFile_thenCorrect
    public static void whenReadUTFEncodedFile_thenCorrect(String file) throws IOException {
    }
    //endregion

    //region reatUTFkurwa
    public static void reatUTFkurwa(String file) {
    }
    //endregion

    //region givenFileName_whenUsingFileUtils_thenFileData
    public static void givenFileName_whenUsingFileUtils_thenFileData(Path path)
            throws NullPointerException {
        ClassLoader classLoader = CreateFileAndCopyFilesContents.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(path.getFileName().toString())).getFile());

    }
    //endregion

    //region whenReadWithBufferedReader_thenCorrect
    public static Stream<String> whenReadWithBufferedReader_thenCorrect(File file) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        Stream<String> stringStream = null;
        List<String> stringList = new LinkedList<>();

        while ((line = br.readLine()) != null) {
            stringList.add(line);
        }
        stringStream = stringList.stream();

        return stringStream;

    }
    //endregion

    //region writeToFile
    public static void writeToFile(List<String> stringsToWrite, File fileToWrite) throws IOException {

        try (FileOutputStream fos = new FileOutputStream(fileToWrite)) {
            for (String s : stringsToWrite) {
                fos.write('\t');
                fos.write(s.getBytes(StandardCharsets.UTF_8));
                fos.write('\n');
            }

        } catch (NoSuchFileException e) {
            System.out.println("\n-------->> NoSuchFileException");
        } catch (FileAlreadyExistsException e) {
            System.out.println("\n-------->> FileAlreadyExistsException");
        } catch (FileNotFoundException e) {
            System.out.println("\n-------->> FileNotFoundException");
        } catch (IOException e) {
            System.out.println("\n-------->> IOException");
        }
    }
//endregion
}
