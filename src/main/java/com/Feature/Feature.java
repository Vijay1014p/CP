package com.Feature;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;



public class Feature {
	
	public static String getTestData(String autoTestCaseNameVal, String label) {
		
		String requiredCellVal = "";
		
		try {
			File f = new File(System.getProperty("user.dir") + "\\Data\\CaseFeature.xlsx");
			FileInputStream fin = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fin);
			XSSFSheet ws = wb.getSheetAt(0);
			int rowNum = ws.getLastRowNum() +1;
			
			Iterator rowIterator =ws.rowIterator();	
			int numberOfCells =0;
			if ((boolean) rowIterator.hasNext()) {
				Row headerRow = (Row) rowIterator.next();
				// get the number of cells in the header row
				numberOfCells = headerRow.getLastCellNum();
				wb.close();
			}
			
			for (int index = 0; index < rowNum; index++) {
				XSSFRow row = ws.getRow(index);
				XSSFCell cell = row.getCell(0);
				
				
				
				String cellVal = cellToString(cell);
				//System.out.println(cellVal);
				if (cellVal.equals(autoTestCaseNameVal)) {
					//System.out.println("Entered"+cellVal+"Row Index:"+index);
					for (int cellIndex = 1; cellIndex < numberOfCells; cellIndex++) {
						XSSFCell findLable = row.getCell(cellIndex);
						String labelString = cellToString(findLable);
						if (labelString.equals(label)) {
							//System.out.println("Cell Index: "+cellIndex);
							XSSFRow nextRow = ws.getRow(index + 1);
							XSSFCell adjacentRowCell = nextRow
									.getCell(cellIndex);
							String adjacentRowCellVal = cellToString(adjacentRowCell);
							//System.out.println("Cell Val: "+adjacentRowCellVal);
							requiredCellVal = adjacentRowCellVal;
							break;
						}
					}

					break;
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return requiredCellVal.trim();
		
		

	}

public static String cellToString(XSSFCell cell) {
	
		
	
	
	int type;
	String result = null;
	type = cell.getCellType();
	

	/*

	



	switch (type) {

	
	
	case Cell.CELL_TYPE_NUMERIC: // numeric value in Excel
		result = "" + cell.getNumericCellValue();
		break;
	case Cell.CELL_TYPE_FORMULA: // precomputed value based on formula
		result = "" + cell.getNumericCellValue();
		break;
	case Cell.CELL_TYPE_STRING: // String Value in Excel
		result = "" + cell.getStringCellValue();
		break;
	case Cell.CELL_TYPE_BLANK:
		result = "";
		break;
	case Cell.CELL_TYPE_BOOLEAN: // boolean value
		result = "" + cell.getBooleanCellValue();
		break;
	case Cell.CELL_TYPE_ERROR:
		result = "Error";
	default:
		throw new RuntimeException(
				"There is no support for this type of cell");
	}

	return result.toString();
	
	*/
	return result;
}
}

