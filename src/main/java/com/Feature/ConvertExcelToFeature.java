package com.Feature;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConvertExcelToFeature {

	public static void main(String[] args) throws Exception {

		File f = new File(System.getProperty("user.dir") + "\\Data\\CaseFeature.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fin);
		List<String> lSb= new ArrayList<String>();
		for (int i = 0; i < wb.getNumberOfSheets()	; i++) {
			Sheet sheetAt = wb.getSheetAt(i);
			int lastRowNum = sheetAt.getLastRowNum();
			System.out.println(lastRowNum);
			for (int j = 1; j <= lastRowNum; j++) {
				Row row = sheetAt.getRow(j);
				if (row==null) {
					continue;
				}
				StringBuffer sb = new StringBuffer();
				Cell cellHead = row.getCell(0);
				
				if (cellHead!=null&&cellHead.getStringCellValue().startsWith("Case")) {
					continue;
				}
				
				
				for (int k = 0; k < 6; k++) {
					Cell cell = row.getCell(k);
					if (cell!=null&&cell.getCellType().equals(CellType.NUMERIC)) {
						double d = cell.getNumericCellValue();
						long l = (long) d;
						System.out.println(String.valueOf(l));
						sb.append(String.valueOf(l).trim() + " ");
					}else if(cell!=null&&cell.getCellType().equals(CellType.STRING))  {
						System.out.println(cell.getStringCellValue());
						sb.append(cell.getStringCellValue().trim() + " ");
					}
				}
				System.out.println(sb.toString().trim());
				lSb.add(sb.toString().trim());
				
			}

			FileWriter fw=new FileWriter(System.getProperty("user.dir") +"\\src\\main\\java\\com\\Feature\\Case.feature");
			System.out.println(fw);
			for(String str: lSb) {
				  fw.write(str + System.lineSeparator());
				}
			fw.close();
		}
	}

	
}
