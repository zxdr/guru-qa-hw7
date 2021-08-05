package guru.qa;

import net.lingala.zip4j.ZipFile;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ZipFileDownloadTest {

    private static final String ZIP_FILE = "zip/dinostudyguide.zip";
    private static final String DOC_FILE = "dinostudyguide.doc";
    private static final String PASSWORD = "Qwerty!23";

    @Test
    void zipDownload() throws IOException {
        ZipFile docFileFromZip = new ZipFile(
                Objects.requireNonNull(this.getClass().getClassLoader().getResource(ZIP_FILE)).getPath(),
                PASSWORD.toCharArray());

        docFileFromZip.extractFile(DOC_FILE, this.getClass().getClassLoader().getResource("zip").getPath());
        String path = this.getClass().getClassLoader().getResource("zip").getPath() + "/" + DOC_FILE;
        File file = new File(path);
        String fileContent = FileUtils.readFileToString(file, "UTF-8");

        Assertions.assertTrue(fileContent.contains("What are dinosaurs?"));
    }
}