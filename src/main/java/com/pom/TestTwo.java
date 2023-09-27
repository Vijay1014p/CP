package com.pom;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class TestTwo {
	


public static void main(String[] args) {
		
		final String url = "http://automationpractice.com/index.php";
		
		try {
			
			final Document document = Jsoup.connect(url).get();
			
			String title = document.title();
			
			System.out.println(title);
			
			 String interestingFact = document.select("p#interesting").text();

	        System.out.println(interestingFact);
			
			System.out.println(document.outerHtml());
			
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			
			// TODO: handle exception
		}
		
		
	}
	
	
	
	
}
