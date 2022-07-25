package MyOwnFilesMoveToGit.CopyFile;

import java.io.IOException;

//region MainAppCopyFileChar
public class MainApp implements common {

    //region main
    public static void main(String[] args) throws IOException {

        System.out.println("A tu jade na masterze!");
        System.out.println("Robie nowy branch na masterze");
        System.out.println("Robie nowy branch na masterze2");
        System.out.println("Zostawiam zmiany i spier.alam stad");
        System.out.println("Zostawiam zmiany i spier.alam stad2");
        System.out.println("Działam na hotfix");
        System.out.println("A teraz utw. quickFix-a");
        System.out.println("Wrocilem na hotfix-a");
        System.out.println("A tu jade na masterze!");
        System.out.println("Robie nowy branch na masterze");
        System.out.println("Działam na qucikMod");
        System.out.println("Działam na qucikMod2");
        System.out.println("Działam na qucikModHot");
        System.out.println("Działam na qucikMod");
        System.out.println("Działam na qucikMod2");
        System.out.println("Działam na quickFix");
        CopyFilesUsingNIO.copyFilesUsingNIO(common.PATH_TO_SOURCE, common.PATH_TO_DESTINATION);
//        CopyFilesUsingIO.copyFilesUsingIO(common.PATH_TO_SOURCE, common.PATH_TO_DESTINATION);
//        CopyFileUsingIO2.copyFileUsingIO2();
//        DeleteFile.cleanUpFiles(new File(PATH_TO_DESTINATION));

    }
    //endregion
}
//endregion
