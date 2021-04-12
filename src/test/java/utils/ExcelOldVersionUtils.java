package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelOldVersionUtils {


    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelOldVersionUtils(String excelPath, String sheetName) {

        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getCellData(int rowNum, int colNum) {
        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));

        // String value = sheet.getRow(1).getCell(0).getStringCellValue();
        // double value = sheet.getRow(1).getCell(2).getNumericCellValue();
        System.out.println(value);
    }

    public void getRowCount() {
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("Num of rows are: " + rowCount);

    }
}
