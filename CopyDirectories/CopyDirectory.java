package MyOwnFilesMoveToGit.CopyDirectories;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Properties;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CopyDirectory {

    //region createDirectory
    public static void createDirectory(String destination) {
        Properties properties = System.getProperties();
        String osName = properties.getProperty("os.name");
        Path newdir = FileSystems.getDefault().getPath(destination);

        boolean pathExists = Files.exists(newdir, LinkOption.NOFOLLOW_LINKS);

        if (!pathExists) {
            Set<PosixFilePermission> posixFilePermissionSet =
                    PosixFilePermissions.fromString("rwxrwxrwx");

            FileAttribute<Set<PosixFilePermission>> fileAttribute =
                    PosixFilePermissions.asFileAttribute(posixFilePermissionSet);

            try {
                if (!osName.contains("Windows")) {
                    Files.createDirectories(newdir, fileAttribute);
                } else {
                    Files.createDirectories(newdir);
                }
            } catch (Exception e) {
                System.err.println(e);

            }
        }


    }
    //endregion

    //region copyFolder
    public static void copyFolder(Path source, Path destination) throws IOException {
        try (Stream<Path> stream = Files.walk(source)) {
            stream.forEach(path -> copy(path, destination.resolve(source.relativize(source))));
        }
    }

    public static void copy(Path source, Path destination) {
        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //endregion

    //region copyFileToNonExistingDirectory
    public static void copyFileToNonExistingDirectory(
            String pathToSourceDirectory, String sourceFileName,
            String pathToDestinationDirectory, String destFileName) throws UnsupportedOperationException {

        Path sourceFile = Paths.get(pathToSourceDirectory, sourceFileName);
        Path destFile = Paths.get(pathToDestinationDirectory, destFileName);

        try (InputStream is = new FileInputStream(sourceFile.toFile())) {
            if (destFile.getParent().toFile().exists()) {
                Files.copy(is, destFile, StandardCopyOption.REPLACE_EXISTING);
            } else {
                FileSystem fileSystem = FileSystems.getDefault();
                Path directory = fileSystem.getPath(destFile.toString());
                Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-x---");
                FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
//                Files.createDirectories(directory, attr);
                createDirectory(directory.toString());
                Files.copy(is, destFile, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //endregion

    //region copyDirectoryUsingNIO
    public static void copyDirectoryUsingNIO(
            String sourceDirectoryLocation,
            String destinationDirectoryLocation)
            throws IOException {

        Consumer<Path> pathConsumer = source -> {
            Path destination1 = Paths.get(
                    destinationDirectoryLocation,
                    source.toString().substring(sourceDirectoryLocation.length()));

            File dest = new File(destination1.toString());

            try {
                if (!(dest.exists())) {
                    dest.mkdir();
                }

                Files.copy(source, destination1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

//        Files.walk(Paths.get(sourceDirectoryLocation)).forEach(System.out::println);
        Files.walk(Paths.get(sourceDirectoryLocation)).forEach(pathConsumer);
    }
    //endregion

    //region copyDirectoryWithFilesUsingIO
    public static void copyDirectoryWithFilesUsingIO(File source, File dest) throws IOException {
        if (!dest.exists()) {
            dest.mkdir();
        }

        String[] listsFiles = source.list();

        if (listsFiles.length != 0) {
            for (String filename : listsFiles)
                System.out.println(filename);

            for (String s : listsFiles) {
                copyDirectoryCompatibilityMode(new File(source, s), new File(dest, s));
            }
        }

        deleteDir(dest);

    }

    //region copyDirectoryCompatibilityMode
    private static void copyDirectoryCompatibilityMode(File source, File destination) throws IOException {
        if (source.isDirectory()) {
            copyDirectoryWithFilesUsingIO(source, destination);
        } else {
            copyFile(source, destination);
        }
    }

    //region copyFile
    private static void copyFile(File sourceFile, File destinationFile) throws IOException {
        try (InputStream in = new FileInputStream(sourceFile);
             OutputStream out = new FileOutputStream(destinationFile)) {
            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
        }
    }
    //endregion

    //region deleteDir
    private static void deleteDir(File file) {
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                deleteDir(f);
            }
        }
        file.delete();
    }
    //endregion
    //endregion

    //endregion


}
