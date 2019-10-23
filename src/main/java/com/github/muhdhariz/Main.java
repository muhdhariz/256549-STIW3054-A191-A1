package com.github.muhdhariz;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class ShowProperties {

    static File temp;

    public static void main(String[] args) throws IOException {
        temp = File.createTempFile("Exercise1_", ".xlsx");
    }
}

public class Main {

    private static String FILE_NAME;
    private static XSSFWorkbook workbook = new XSSFWorkbook();
    private static XSSFSheet sheet1 = workbook.createSheet("Students Submit");
    private static XSSFSheet sheet2 = workbook.createSheet("Students Not Submit");
    private static XSSFSheet sheet3 = workbook.createSheet("Unknown List");
    private static Comparison comp = new Comparison();

    public static void main(String[] args) throws IOException {
        ShowProperties.main(args);
        FILE_NAME = ShowProperties.temp.toString();
        comp.main(args);
        Object[][] data1 = Comparison.studS;
        Object[][] data2 = Comparison.studNS;
        Object[][] data3 = Comparison.studU;

        int rowNum = 0;
        System.out.println();
        System.out.println("Creating " + ShowProperties.temp.getName() + " File");
        System.out.println("Excel Filepath: " + ShowProperties.temp.getAbsolutePath());

        getRowNum(sheet1, data1, rowNum);

        getRowNum(sheet2, data2, rowNum);

        getRowNum(sheet3, data3, rowNum);

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found or currently open");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }

    static void getRowNum(XSSFSheet sheet, Object[][] data, int rowNum) {
        for (Object[] datatype : data) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                sheet.autoSizeColumn(rowNum);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        for (int x = 0; x < sheet.getRow(0).getPhysicalNumberOfCells(); x++) {
            sheet.autoSizeColumn(x);
        }
    }
}
