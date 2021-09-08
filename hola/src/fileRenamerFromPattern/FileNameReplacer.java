package fileRenamerFromPattern;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FileNameReplacer {
    public static final String tobeReplaced = " - (SongsLover.com)";

    public static void main(String arhgs[]) {
        Path dir = Paths.get(".");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file : stream) {
                String a = file.getFileName().toString();
                if (a.contains(tobeReplaced)) {
                    String newName = a.replace(tobeReplaced, "");
                    System.out.println("changing " + a + " to " + newName);
                    File f = file.toFile();
                    f.renameTo(new File(newName));
                }
                System.out.println("no change in "+file.getFileName());

            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }
    }
}
