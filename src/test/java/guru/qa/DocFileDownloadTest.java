package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class DocFileDownloadTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://github.com/zxdr/guru-qa-hw7/tree/main/src/test/resources";
    }

    @Test
    void docDownload() throws Exception {
        Selenide.open("/dinostudyguide.doc");

        File downloadedFile = $("#raw-url").download();
        String fileContent = FileUtils.readFileToString(downloadedFile, "UTF-8");

        Assertions.assertTrue(fileContent.contains("What are dinosaurs?"));
    }
}