package ivan.samoylov;

import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Main {
    public static final String PATH_TO_ZIP_LINUX = "/snap/intellij-idea-community/172/lib/ant/src.zip";

    public static void main(String[] args) {
        System.out.println(readCountZipFiles(PATH_TO_ZIP_LINUX));
    }

    private static long readCountZipFiles(String zipFilePath) {
        long fileCounter = 0;
        try {
            ZipFile zipFile = new ZipFile(zipFilePath);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();

            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if (!entry.isDirectory()){
                    fileCounter++;
                }
            }
            zipFile.close();
        } catch (IOException ex) {

        }
        return fileCounter;
    }
}
