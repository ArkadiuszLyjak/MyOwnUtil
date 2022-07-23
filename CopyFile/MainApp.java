package MyOwnFilesMoveToGit.CopyFile;

import java.io.IOException;

//region MainAppCopyFileChar
public class MainApp implements common {

    //region main
    public static void main(String[] args) throws IOException {

        CopyFilesUsingNIO.copyFilesUsingNIO(common.PATH_TO_SOURCE, common.PATH_TO_DESTINATION);
//        CopyFilesUsingIO.copyFilesUsingIO(common.PATH_TO_SOURCE, common.PATH_TO_DESTINATION);
//        CopyFileUsingIO2.copyFileUsingIO2();
//        DeleteFile.cleanUpFiles(new File(PATH_TO_DESTINATION));

    }
    //endregion
}
//endregion
