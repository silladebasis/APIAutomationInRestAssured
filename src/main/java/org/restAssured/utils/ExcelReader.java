package org.restAssured.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    static Workbook workbook;
    static Sheet sheet;
    static String SHEET_NAME = System.getProperty("user.dir")+"/src/main/java/org/restAssured/resources/TestData.xlsx";
    public static Object[][] getDataFromExcel(String sheetName) throws IOException {
        FileInputStream file;
        try {
            file = new FileInputStream(SHEET_NAME);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        workbook = WorkbookFactory.create(file);
        sheet = workbook.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i =0;i<sheet.getLastRowNum();i++){
            for (int j = 0; j < sheet.getRow(0).getLastCellNum() ; j++) {
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }
    @DataProvider
    public Object[][] getData() throws IOException {
        return getDataFromExcel("Data");
    }
}
