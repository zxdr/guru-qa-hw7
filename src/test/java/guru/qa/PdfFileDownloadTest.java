package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.codeborne.selenide.Selenide.$;

public class PdfFileDownloadTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://github.com/zxdr/guru-qa-hw7/tree/main/src/test/resources";
    }

    @Test
    void junitPdfTest() throws IOException {
        Selenide.open("/dino_dinosaur.pdf");

        File downloadedPdfFile = $("#raw-url").download();
        PDF parsedPdf = new PDF(downloadedPdfFile);
        assertThat(parsedPdf.text).contains("What distinguishes dinosaurs from other reptiles?");
    }
}