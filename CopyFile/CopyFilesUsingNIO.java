package MyOwnFilesMoveToGit.CopyFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyFilesUsingNIO implements common {

    static void copyFilesUsingNIO(String source, String dest) throws IOException {

        Path path = Paths.get(dest);
        int availableBytes;

        try (InputStream inputStream = new FileInputStream(source)) {
            if (Files.isWritable(path)) {
                availableBytes = inputStream.available();
                long bytesCopied = Files.copy(inputStream, path, copyOption);

                if (availableBytes == bytesCopied) {
                    System.out.println("skopiowano: " + bytesCopied + " bytes");
                } else System.out.println("Błąd kopiowania...");
            } else {
                System.out.println("W pliku nie mozna zapisac danych ...");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
