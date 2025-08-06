package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.io.IOException;
// This class reads login details from an Excel file using Apache POI
public class ReadFromExcel {
    // Define the path to the Excel file
    private static String testDataDir = System.getProperty("user.dir") + "/src/test/java/TestData/data.xlsx";

    // Declare variables to hold username and password
    public String password;
    public String username;
    XSSFSheet sheet;
    public ReadFromExcel() throws IOException {
        // Constructor can be used to initialize resources if needed

        // Open the Excel file
        FileInputStream fis = new FileInputStream(testDataDir);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("login Details");

        // Assuming the first row contains headers and the second row contains data
        username = sheet.getRow(1).getCell(0).getStringCellValue();
        password = sheet.getRow(1).getCell(1).getStringCellValue();
        workbook.close();
        fis.close();
    }
}
