package com.jobless.utilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.joblssMedha.basetest.HomepageTestBase;


public class ExcelUtility extends HomepageTestBase {
	
	private static Workbook workbook;
	private static Sheet sheet;
	private static Row row;
	private static Cell cell;
	
	@SuppressWarnings("deprecation")
	private static String getCellData(int iRowSerialNum, int iColSerialNum) {
		
		row = sheet.getRow(iRowSerialNum);
		//cell= row.getCell(iColSerialNum);
		cell = row.getCell(iColSerialNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);

		String sCellData = "";
	
		if(cell==null || cell.getCellType()==cell.CELL_TYPE_BLANK) {
		sCellData ="";
		return sCellData;
		}
		
		switch(cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			sCellData = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			sCellData = Integer.toString((int)cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			sCellData = Boolean.toString(cell.getBooleanCellValue());
			break;
		}
		
		return sCellData;
	}

	public static int getRowNameOnSearchingString(String searchStrings, String sheetName) {
		try {
			workbook = new XSSFWorkbook(new File(resource_Dir + data_excelName));
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int numOfRows = sheet.getPhysicalNumberOfRows();
		int iRowNum = 0;
		
		for(int rowCounter=1; rowCounter<numOfRows; rowCounter++) {
			row = sheet.getRow(rowCounter);
			int numOfCells = row.getPhysicalNumberOfCells();
			for(int cellCounter=0; cellCounter < numOfCells ; cellCounter++) {
				String cellData = getCellData(rowCounter, cellCounter).toString();
				if(cellData.equalsIgnoreCase(searchStrings)) {
					iRowNum = rowCounter;
					break;
				}
			}
		}
		return iRowNum;
	}
	 
	public static HashMap <String, String> getRowData(int iRowNum){
		String cellHeaderData = "";
		String cellRowData = "";
		HashMap <String, String> testData = new HashMap<String, String>();
		Row headerRow = sheet.getRow(0);
		int numOfCells = headerRow.getPhysicalNumberOfCells();
		for(int cellCounter=0; cellCounter < numOfCells ; cellCounter++) {
			cellHeaderData = getCellData(0, cellCounter).toString();
			row = sheet.getRow(iRowNum);
			cellRowData = getCellData(iRowNum, cellCounter);
			testData.put(cellHeaderData, cellRowData);
		}
		return testData;
	}

}
