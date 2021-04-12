package utils;

public class ExcelTest {

    public static void main(String[] args) {

        String excelPath = "./data/TestData.xlsx";
        String excelPath1 = "./data/TestData.xls";

        String sheetName = "Sheet1";

        ExcelUtils excelUtils = new ExcelUtils(excelPath, sheetName);
        ExcelOldVersionUtils excelOldVersionUtils = new ExcelOldVersionUtils(excelPath1 , sheetName);

        excelUtils.getRowCount();
        excelUtils.getCellData(1,0);
        excelUtils.getCellData(1,1);
        excelUtils.getCellData(1,2);

        excelOldVersionUtils.getCellData(2,0);
        excelOldVersionUtils.getCellData(2,1);
        excelOldVersionUtils.getCellData(2,2);
    }
}
