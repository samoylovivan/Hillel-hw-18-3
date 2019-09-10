package ivan.samoylov;

import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Main {
    public static final String PATH_TO_ZIP_LINUX = "/usr/lib/jvm/jdk-12.0.1/lib/src.zip";

    public static void main(String[] args) {
        readZipFile(PATH_TO_ZIP_LINUX);
    }

    private static void readZipFile(String zipFilePath) {
        try {
            ZipFile zipFile = new ZipFile(zipFilePath);

            Enumeration<? extends ZipEntry> entries = zipFile.entries();

            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                String name = entry.getName();
                long compressedSize = entry.getCompressedSize();
                long normalSize = entry.getSize();
                String type = entry.isDirectory() ? "DIR" : "FILE";

                System.out.println(name);
                System.out.format("\t %s - %d - %d\n", type, compressedSize, normalSize);
            }

            zipFile.close();
        } catch (IOException ex) {

        }
    }
}
