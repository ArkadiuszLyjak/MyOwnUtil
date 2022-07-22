package MyOwnFilesMoveToGit.CopyDirectories;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class MainAppCopyDir {

    //region Description
    static String pathToSourceDirectory = "c:\\repo\\IdeaProjects\\untitled\\TestFilesDir\\";
    static Path dirPathSourcePath = FileSystems.getDefault().getPath(pathToSourceDirectory);
    static File dirPathOriginalFile = new File(pathToSourceDirectory);
    static String pathToDestinationDirectory = "c:\\repo\\IdeaProjects\\untitled\\TestFilesDirCopied\\";
    static Path dirPathDestinationPath = FileSystems.getDefault().getPath(pathToDestinationDirectory);
    static File dirPathDestinationFile = new File(pathToDestinationDirectory);
    static String someFileName = "file.txt";
    static String sourceFileName = "copyFrom.txt";
    static String destFileName = "copyTo.txt";

    Path destFilePath = FileSystems.getDefault().getPath(pathToSourceDirectory + destFileName);

    Path sourceFilePath = FileSystems.getDefault().getPath(pathToSourceDirectory + sourceFileName);
    //endregion

    public static void main(String[] args) throws IOException {


    }
}
