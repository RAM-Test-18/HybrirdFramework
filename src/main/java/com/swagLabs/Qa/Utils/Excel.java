package com.swagLabs.Qa.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	
	
	protected static String _excelPath =null;
	
	private static FileInputStream fis;
	
	private static XSSFWorkbook wb;
	
	private static XSSFSheet sheet;
	
	private static Excel excelData;
	

	public Excel(String excelpath) 
	{
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			System.out.println(
					String.valueOf(Input.timeStamp()) + " : EXCEL : Excel File Could not be find. { " + e + " }");
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getDataFromExcel(int sheetnumber, int row, int column) 
	{
		excelData = new Excel(_excelPath);
		sheet = wb.getSheetAt(sheetnumber);
		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue((Cell) sheet.getRow(row).getCell(column));
	}

	public static int getRowCount(int sheetIndex) 
	{
		excelData = new Excel(_excelPath);
		return wb.getSheetAt(sheetIndex).getPhysicalNumberOfRows();
	}

	public static int getColCount(int sheetIndex) 
	{
		excelData = new Excel(_excelPath);
		sheet = wb.getSheetAt(sheetIndex);
		return sheet.getRow(0).getLastCellNum();
	}
	
	

}
