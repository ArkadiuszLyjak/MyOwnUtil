package MyOwnFilesMoveToGit.CopyFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyFileUsingIO2 implements common {

    public static void copyFileUsingIO2() throws IOException {
        Path path = Paths.get(PATH_TO_DESTINATION);

        if (Files.isWritable(path)) {
            Files.copy(Paths.get(PATH_TO_SOURCE), path, copyOption);
        }

    }

}
