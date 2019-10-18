package com.github.muhdhariz;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ApachePOIExcelWrite {

    private static final String FILE_NAME = "C:/Users/muhdh/OneDrive - UNIVERSITY UTARA MALAYSIA/Study/A191/Real-Time Programming/Exercise1.xlsx";
    private static XSSFWorkbook workbook = new XSSFWorkbook();
    private static XSSFSheet sheet1 = workbook.createSheet("Students Submit");
    private static XSSFSheet sheet2 = workbook.createSheet("Students Not Submit");
    private static XSSFSheet sheet3 = workbook.createSheet("Unknown List");

    public static void main(String[] args) {
        Compare.main(args);

        Object[][] data1 = Compare.studS;
        Object[][] data2 = Compare.studNS;
        Object[][] data3 = Compare.studU;

        int rowNum = 0;
        System.out.println("Creating Excel File");

        getRowNum(sheet1, data1, rowNum);

        getRowNum(sheet2, data2, rowNum);

        getRowNum(sheet3, data3, rowNum);

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }

    static void getRowNum(XSSFSheet sheet1, Object[][] data1, int rowNum) {
        for (Object[] datatype : data1) {
            Row row = sheet1.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
    }
}
