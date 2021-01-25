package session5.exercise1;

import sun.lwawt.macosx.CSystemTray;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
       Path path = Paths.get("new Directory");
       System.out.println("creating directory :" + path.toString());
       Path newDir = Files.createDirectory(path);
       System.out.println("creating file: newFile1.txt");
       Files.createFile(newDir.resolve("newFile1.txt"));
       System.out.println("creating file: newFile2.txt");
       Files.createFile(newDir.resolve("newFile2.txt"));
       System.out.println("creating file: newFile3.txt");
       Files.createFile(newDir.resolve("newFile3.txt"));
       deleteFile(newDir.toFile());
       System.out.println("Done");

}

    private static boolean deleteFile(File dir) {
        if (dir.isDirectory()) {
            File[] children = dir.listFiles();
            for (int i = 0; i < children.length; i++) {
               deleteFile(children[i]);
            }
        }
        System.out.println("removing file or directory :"+ dir.getName());
        return dir.delete();
    }
}