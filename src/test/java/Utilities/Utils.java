package Utilities;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

public class Utils {

    public static WebDriver driver;
    public static final int IMPLICIT_WAIT_TIME = 20;
    public static final int PAGE_LOAD_TIME = 20;

    public static String generateEmail() {
        Date date = new Date();
        String timestamp = date.toString().replace(" ", "_").replace(":", "_");
        String customEmail = "test900"+ timestamp +"@gmail.com";
        return  customEmail;
    }

    public static String getCurrentUrl() {
        driver.getCurrentUrl();
        return null;
    }

    public static Object[][] getTestDataFromExcel(String sheetName) {
        XSSFWorkbook workbook = null;
        File excelFile = new File("src/test/java/TestData/TestData.xlsx");

        try {
            FileInputStream fisExcel = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(fisExcel);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][cols];

        for (int i = 0; i < rows; i++) {
            XSSFRow row = sheet.getRow(i+1);
            for (int j = 0; j < cols; j++) {
                XSSFCell cell = row.getCell(j);
                CellType cellType = cell.getCellType();

                switch (cellType) {
                    case STRING:
                        data[i][j] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        data[i][j] = Integer.toString((int)cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        data[i][j] = cell.getBooleanCellValue();

                }
            }
        }

        return data;

    }

}
