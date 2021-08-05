package guru.qa;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class XlsFileDownloadTest {

    @Test
    void junitPdfTest() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("dinoTable.xls");

        XLS xlsFile = new XLS(stream);
        String stringFirstDinolValue = xlsFile.excel.getSheetAt(0).getRow(4).getCell(0)
                .getStringCellValue();

        Assertions.assertEquals(stringFirstDinolValue, "Plateosaurus (N=12)");
    }
}