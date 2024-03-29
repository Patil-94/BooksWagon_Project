package com.blz.selenium.utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {


    public static Object[][] getTestData(String sheetName) throws IOException {
        String filePath = "C:\\Users\\sachin\\IdeaProjects\\BooksWagon_Project\\src\\main\\resources\\bookswagon.xlsx";

        FileInputStream file = null;
        try {
            file = new FileInputStream(filePath);//create object of FileInputStream class and pass filepath
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook workbook = new XSSFWorkbook(file);//creating workbook object
        XSSFSheet sheet = workbook.getSheet(sheetName);//get sheet

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;

    }
}
