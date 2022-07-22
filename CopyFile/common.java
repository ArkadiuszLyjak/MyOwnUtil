package MyOwnFilesMoveToGit.CopyFile;

import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.StandardCopyOption;

public interface common {
    int zapas = 2;

    String PATH_TO_SOURCE = "C:" + File.separatorChar
            + "repo\\IdeaProjects\\untitled\\TestFilesDir\\"
            + File.separatorChar + "copyFrom.txt";

    String PATH_TO_DESTINATION = "C:" + File.separatorChar
            + "repo\\IdeaProjects\\untitled\\TestFilesDir\\"
            + File.separatorChar + "copyTo.txt";

    CopyOption copyOption = StandardCopyOption.REPLACE_EXISTING;

}
