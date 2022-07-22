package MyOwnFilesMoveToGit.CopyFile;

import java.io.*;

public class CopyFilesUsingIO implements common {

    static void copyFilesUsingIO(String source, String destination) throws IOException {

        try (InputStream is = new BufferedInputStream(new FileInputStream(source));
             OutputStream os = new BufferedOutputStream(new FileOutputStream(destination))) {

            int availableBytes = is.available();
            byte[] buffer = new byte[availableBytes * zapas];

            int lengthReadBytes;

            try {
                if ((lengthReadBytes = is.read(buffer)) > 0) {

                    System.out.print("read bytes: " + lengthReadBytes
                            + " has been read, bytes available at all: " + availableBytes + "\n\n");

                    for (int j = 0; j < buffer.length; j++) {
                        if (buffer[j] != 0) {
                            char c = (char) buffer[j];
                            System.out.print(c);
                        }
                    }

                    int offset = 0;
//                    int offset = 1;
//                    int offset = availableBytes - 1;
//                    int offset = 128;
//                    int offset = buffer.length;
                    System.out.println("\n\nBajtow w buforze: " + lengthReadBytes);
                    os.write(buffer, offset, lengthReadBytes - (offset));
//                    os.write(buffer, offset, lengthReadBytes);
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
